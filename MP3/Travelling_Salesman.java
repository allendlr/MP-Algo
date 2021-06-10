/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author markjasongalang
 */

import java.io.*;
import java.util.*;

public class Travelling_Salesman {
  static int cost = 0;
  static String path = "";
  
  // Note: *Use only ONE (1) test case per program testing (because they have the same identifier)
  // TEST CASE 1: (Output should 30, this is from M3S2) (UNCOMMENT below to enable)
  static char[] letters = {'A', 'B', 'C', 'D', 'E'};
  static int val[][] = {{Integer.MAX_VALUE, 7, 6, 8, 4},
                        {7, Integer.MAX_VALUE, 8, 5, 6},
                        {6, 8, Integer.MAX_VALUE, 9, 7},
                        {8, 5, 9, Integer.MAX_VALUE, 8},
                        {4, 6, 7, 8, Integer.MAX_VALUE}};

  //     TEST CASE 2: (Output should 17, this is from TSP EXER1) (UNCOMMENT below to enable)
//  static char[] letters = {'A', 'B', 'C', 'D', 'E'};
//  static int val[][] = {{Integer.MAX_VALUE, 3, 6, 2, 3},
//                        {3, Integer.MAX_VALUE, 5, 2, 3},
//                        {6, 5, Integer.MAX_VALUE, 6, 5},
//                        {2, 2, 6, Integer.MAX_VALUE, 6},
//                        {3, 3, 5, 6, Integer.MAX_VALUE}};
  
//      TEST CASE 3: (Output should be 110, this is from TSP EXER2) (UNCOMMENT below to enable)
//  static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};
//  static int val[][]= {{Integer.MAX_VALUE, 20, 23, 27, 29, 34},
//                       {21, Integer.MAX_VALUE, 19, 26, 31, 24},
//                       {26, 28, Integer.MAX_VALUE, 15, 36, 26},
//                       {25, 26, 25, Integer.MAX_VALUE, 23, 28},
//                       {23, 40, 13, 31, Integer.MAX_VALUE, 10},
//                       {27, 18, 12, 35, 16, Integer.MAX_VALUE}};
  
  // Check() function -> this checks if the table does not contain any values except for 0 and Integer.MAX_VALUE
  private boolean Check(int[][] table) {
    for (int i = 0; i < (int) table.length; i++) {
      for (int j = 0; j < (int) table[i].length; j++) {
        if (table[i][j] != 0 && table[i][j] != Integer.MAX_VALUE) {
          return false;
        }
      }
    }
    return true;
  }

  // Zero() function -> this checks if the row or column contains a ZERO (0)
  private boolean Zeroes(Vector<Integer> temp) {
    for (int i = 0; i < (int) temp.size(); i++) {
      if (temp.elementAt(i) == 0) {
        return true;
      }
    }
    return false;
  }
  
  // RowMinimization() -> this minimizes the values in the row (if there are no ZEROES)
  private int[][] RowMinimization(int[][] table) {
    for (int i = 0; i < (int) table.length; i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) table.length; j++) {
        temp.add(table[i][j]);
      }
      // check if there are any zeroes present in the row
      if (Zeroes(temp)) {
        continue;
      }
      int minimum = Integer.MAX_VALUE;
      // find the minimum value in the row
      for (int j = 0; j < (int) table[i].length; j++) {
        minimum = Math.min(minimum, table[i][j]);
      }
      // minimize the row by subtracting the minimum value to all the elements except for
      // Integer.MAX_VALUE (because this represents the '-' in the table)
      for (int j = 0; j < (int) table[i].length; j++) {
        if (table[i][j] != Integer.MAX_VALUE) {
          table[i][j] = table[i][j] - minimum;
        }
      }
    }
    return table;
  }
  
  // ColumnMinimization() -> this minimizes the values in the column (if there are no ZEROES)
  private int[][] ColumnMinimization(int[][] table) {
    for (int i = 0; i < (int) table.length; i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) table.length; j++) {
        temp.add(table[j][i]);
      }
      // check if there are any zeroes present in the row
      if (Zeroes(temp)) {
        continue;
      }
      // find the minimum value in the column
      int minimum = Integer.MAX_VALUE;
      for (int j = 0; j < (int) table[i].length; j++) {
        minimum = Math.min(minimum, table[j][i]);
      }
      // minimize the column by subtracting the minimum value to all the elements except for
      // Integer.MAX_VALUE (because this represents the '-' in the table)
      for (int j = 0; j < (int) table[i].length; j++) {
        if (table[j][i] != Integer.MAX_VALUE) {
          table[j][i] = table[j][i] - minimum;
        }
      }
    }
    return table;
  }
  
  // Penalty() -> this applies the penalty process in the table
  private int[][] Penalty(int[][] table) {
    // create a copy of the current table
    int[][] temp = new int[(int) table.length][(int) table.length];
    for (int i = 0; i < (int) table.length; i++) {
      for (int j = 0; j < (int) table[i].length; j++) {
        temp[i][j] = table[i][j];
      }
    }
    // 'key' will hold the maximum penalty score (maximum value that was applied in a zero)
    int key = Integer.MIN_VALUE;
    for (int i = 0; i < (int) temp.length; i++) {
      for (int j = 0; j < (int) temp[i].length; j++) {
        // apply the penalty rule on the zero values scattered in the table
        if (table[i][j] == 0) {
          // find the minimum value in the current row
          int row_minimum = Integer.MAX_VALUE;
          for (int k = 0; k < (int) temp[i].length; k++) {
            if (k != j) {
              row_minimum = Math.min(row_minimum, table[i][k]);
            }
          }
          // find the minimum value in the column row
          int column_minimum = Integer.MAX_VALUE;
          for (int k = 0; k < (int) temp[i].length; k++) {
            if (k != i) {
              column_minimum = Math.min(column_minimum, table[k][j]);
            }
          }
          // set the sum of the minimum value of the row and column in a this specific zero value
          temp[i][j] = row_minimum + column_minimum;
          // store the largest value (highest penalty score that will removed later)
          key = Math.max(key, temp[i][j]);
        }
      }
    }
    // 'row_index' will contain the i-th index of the key (highest penalty score)
    int row_index = -1;
    // 'column_index' will contain the j-th index of the key (highest penalty score)
    int column_index = -1;
    for (int i = 0; i < (int) temp.length; i++) {
      for (int j = 0; j < (int) temp[i].length; j++) {
        // find the 'i-th' and 'j-th' indices of the key in the table
        if (table[i][j] == 0 && temp[i][j] == key) {
          row_index = i;
          column_index = j;
          // calculate the cost (weight) of this path
          cost += val[i][j];
          // concatenate the letters that formed a connection (to be used later in the main function)
          path += String.valueOf(letters[i]);
          path += String.valueOf(letters[j]);
          // break this loop (inner) (since we only need to this ONCE)
          break;
        }
      }
      if (row_index != -1 && column_index != -1) {
        // if they key was found, then break this loop (outer) as well
        break;
      }
    }
    // find the reciprocal (reverse 'row_index' and 'column_index' values) place and
    // render this place useless by setting its value to Integer.MAX_VALUE
    table[column_index][row_index] = Integer.MAX_VALUE;
    // set all the values that are placed in the row that matches the chosen 'row_index' and all the values
    // that are also placed in the column that matches the chosen 'column_index' to Integer.MAX_VALUE
    for (int i = 0; i < (int) table.length; i++) {
      for (int j = 0; j < (int) table[i].length; j++) {
        if (i == row_index || j == column_index) {
          // if the 'i-th' matches the chosen 'row_index' or the 'j-t' index matches the chosen
          // 'column_index', then set all the values on that row or column to Integer.MAX_VALUE
          table[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    return table;
  }
  
  public static void main(String[] args) {
      Travelling_Salesman object = new Travelling_Salesman();
      // create a copy of 'val' (2D table that contains the values)
      int table[][] = new int[(int) val.length][(int) val.length];
      for (int i = 0; i < (int) table.length; i++) {
        for (int j = 0; j < (int) table[i].length; j++) {
          table[i][j] = val[i][j];
        }
      }
      // run a while-loop
      while (true) {
        if (object.Check(table)) {
          // the Check() function will decide if the while-loop will stop
          break;
        }
        // first, the table undergoes Row Minimization (if there are no zeroes in a row)
        table = object.RowMinimization(table);
        // second, the table undergoes Column Minimization (if there are no zeroes in a column)
        table = object.ColumnMinimization(table);
        // third, the table undergoes the Penalty process
        table = object.Penalty(table);
      }
      // print the final status (appearance) of the table after all the operations
      System.out.println("Table Status:");
      System.out.print(" ");
      for (int i = 0; i < (int) letters.length; i++) {
        System.out.print(" " + letters[i]);
      }
      System.out.println("");
      for (int i = 0; i < (int) table.length; i++) {
        System.out.print(letters[i] + " ");
        for (int j = 0; j < (int) table[i].length; j++) {
          // replace all the Integer.MAX_VALUE elements with dash signs ('-')
          System.out.print((table[i][j] == Integer.MAX_VALUE ? "-" : table[i][j]) + " ");
        }
        System.out.println("");
      }
      // this for-loop below will handle the final case (step) which leads to finding the path
      for (int i = 0; i < (int) table.length; i++) {
        int zeroes = 0;
        // count the zeroes in every row
        for (int j = 0; j < (int) table.length; j++) {
          if (table[i][j] == 0) {
            zeroes++;
          }
        }
        int minimum_per_row = Integer.MAX_VALUE;
        int row_index = -1;
        int column_index = -1;
        // find the minimum cost (of path) to take in every row
        for (int j = 0; j < (int) table.length; j++) {
          if (table[i][j] == 0) {
            boolean checker = false;
            if (j == 0) {
              // there is an extra case, whenever the origin position or 'A' has a zero
              for (int k = 0; k < (int) table[i].length; k++) {
                // check if there are zeroes in the same column
                if (table[k][j] == 0 && k != i) {
                  checker = true;
                  break;
                }
              }
            }
            if (checker && zeroes > 1) {
              // if there are other zeroes beside the current one (for 'j' = 0), and it has another path
              // then, skip this path because there is another path to the origin which will appear (later)
              continue;
            }
            if (val[i][j] < minimum_per_row) {
              // if the cost (weight) of from origin to destination is STRICTLY less than or equal to the one
              // that we have currently stored, then update the value of the stored value to this one
              minimum_per_row = val[i][j];
              // store the 'row_index' ('i-th' index)
              row_index = i;
              // store the 'column_index' ('j-th' index)
              column_index = j;
            }
          }
        }
        // check if there is minimum value that was found in a row (or if other paths still exist that
        // was not taken out or revealed from undergoing the Penalty process above
        if (minimum_per_row != Integer.MAX_VALUE) {
          // convert the 'row_index' and 'column_index' to their respective letter equivalence
          String connected = String.valueOf(letters[row_index]) + String.valueOf(letters[column_index]);
          // concatenate the origina and destination that was found (always contains two letters 
          // which is origin and destination)
          path += connected;
          // store the cost (weight) of this path
          cost += minimum_per_row;
        }
      }
      // separate the every two letters (origin and destination) in a vector
      Vector<String> separate = new Vector<String>();
      for (int i = 0; i < (int) path.length(); i += 2) {
        String temp = String.valueOf(path.charAt(i)) + String.valueOf(path.charAt(i + 1));
        separate.add(temp);
      }
      System.out.println("\nFinal Path:");
      // 'last_path' will store the final path of the travelling salesman
      String last_path = "";
      // 'visited' array will check if the path was already visited (included in the 'last_path')
      boolean[] visited = new boolean[(int) separate.size()];
      // fill all the values with 'false'
      Arrays.fill(visited, false);
      for (int i = 0; i < (int) separate.size(); i++) {
        // find the starting place of the path (which contains letter 'A')
        if (separate.elementAt(i).charAt(0) == 'A') {
          // mark this index as visited (set 'visited' to true)
          visited[i] = true;
          // concatenate this path (contains two letters: origin and destination) in the 'last_path'
          last_path += String.valueOf(separate.elementAt(i).charAt(0)) + "->" + String.valueOf(separate.elementAt(i).charAt(1));
          // break the loop since there is only one (1) starting place
          break;
        }
      }
      // run a while-loop until it forms the 'last_path' (all the places are visited)
      while (true) {
        boolean checker = true;
        for (int i = 0; i < (int) visited.length; i++) {
          // check if all the places where visited (added in the 'last_path')
          if (!visited[i]) {
            // if yes, then set 'checker' to true and break the loop
            checker = false;
            break;
          }
        }
        if (checker) {
          // if 'checker' is true, then stop this while-loop
          break;
        }
        // form a straight connection using all the available paths using this for-loop below
        for (int i = 0; i < (int) separate.size(); i++) {
          // check if the destination (second letter) of a path matches the origin (first letter) of another path
          if (last_path.charAt((int) last_path.length() - 1) == separate.elementAt(i).charAt(0)) {
            // if yes, then set visit this index by setting 'visited[i]' to true
            visited[i] = true;
            // concatenate the chosen path in the 'last_path' together with an arrow ('->')
            last_path += ("->" + String.valueOf(separate.elementAt(i).charAt(1)));
            // break this loop to form another searching of path from the start
            break;
          }
        }
      }
      // print the straight path formed together with the minimum cost that was calculated above
      System.out.println(last_path + " = " + cost + '\n');
   }
}
