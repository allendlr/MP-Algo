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

public class JasonMatrixAlgorithm {
  // multiply two given matrices (parameters)
  static Vector<Vector<Integer>> Multiply2DParts(Vector<Vector<Integer>> a, Vector<Vector<Integer>> b) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    for (int i = 0; i < (int) a.size(); i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) a.size(); j++) {
        int sum = 0;
        for (int k = 0; k < (int) a.size(); k++) {
          sum += (a.get(i).get(k) * b.get(k).get(j));
        }
        temp.add(sum);
      }
      res.add(temp);
    }
    return res;
  }
  
  // add two given matrices (parameters)
  static Vector<Vector<Integer>> Add2DParts(Vector<Vector<Integer>> a, Vector<Vector<Integer>> b) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    for (int i = 0; i < (int) a.size(); i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) a.size(); j++) {
        temp.add(a.get(i).get(j) + b.get(i).get(j));
      }
      res.add(temp);
    }
    return res;
  }
  
  // subtracts two given matrices (parameters)
  static Vector<Vector<Integer>> Subtract2DParts(Vector<Vector<Integer>> a, Vector<Vector<Integer>> b) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    for (int i = 0; i < (int) a.size(); i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) a.size(); j++) {
        temp.add(a.get(i).get(j) - b.get(i).get(j));
      }
      res.add(temp);
    }
    return res;
  }
  
  // separate the 2D matrix from its specific 3D matrix (parameter)
  static Vector<Vector<Integer>> Get2DParts(int id, Vector<Vector<Vector<Integer>>> v) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    for (int i = 0; i < (int) v.get(id).size(); i++) {
      Vector<Integer> temp = new Vector<Integer>();
      for (int j = 0; j < (int) v.get(id).get(i).size(); j++) {
        temp.add(v.get(id).get(i).get(j));
      }
      res.add(temp);
    }
    return res;
  }
  
  // calculate the 'a' - 'h' submatrices using the formula
  static Vector<Vector<Integer>> GetValuesForP(int id, Vector<Vector<Vector<Integer>>> v1, Vector<Vector<Vector<Integer>>> v2) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    Vector<Vector<Integer>> a = Get2DParts(0, v1);
    Vector<Vector<Integer>> b = Get2DParts(1, v1);
    Vector<Vector<Integer>> c = Get2DParts(2, v1);
    Vector<Vector<Integer>> d = Get2DParts(3, v1);
    Vector<Vector<Integer>> e = Get2DParts(0, v2);
    Vector<Vector<Integer>> f = Get2DParts(1, v2);
    Vector<Vector<Integer>> g = Get2DParts(2, v2);
    Vector<Vector<Integer>> h = Get2DParts(3, v2);
    if (id == 1) {
      res = Multiply2DParts(a, Subtract2DParts(f, h));
    } else if (id == 2) {
      res = Multiply2DParts(Add2DParts(a, b), h);
    } else if (id == 3) {
      res = Multiply2DParts(Add2DParts(c, d), e); 
   } else if (id == 4) {
      res = Multiply2DParts(d, Subtract2DParts(g, e));
    } else if (id == 5) {
      res = Multiply2DParts(Add2DParts(a, d), Add2DParts(e, h));
    } else if (id == 6) {
      res = Multiply2DParts(Subtract2DParts(b, d), Add2DParts(g, h));
    } else {
      res = Multiply2DParts(Subtract2DParts(a, c), Add2DParts(e, f));
    }
    return res;
  }
  
  // calculate p1 - p7 submatrices using the formula
  static Vector<Vector<Integer>> GetValuesForAnswer(int id, Vector<Vector<Vector<Integer>>> p) {
    Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
    Vector<Vector<Integer>> p1 = Get2DParts(0, p);
    Vector<Vector<Integer>> p2 = Get2DParts(1, p);
    Vector<Vector<Integer>> p3 = Get2DParts(2, p);
    Vector<Vector<Integer>> p4 = Get2DParts(3, p);
    Vector<Vector<Integer>> p5 = Get2DParts(4, p);
    Vector<Vector<Integer>> p6 = Get2DParts(5, p);
    Vector<Vector<Integer>> p7 = Get2DParts(6, p);
    if (id == 1) {
     res = Add2DParts(p5, p4);
     res = Subtract2DParts(res, p2);
     res = Add2DParts(res, p6);
    } else if (id == 2) {
      res = Add2DParts(p1, p2);
    } else if (id == 3) {
      res = Add2DParts(p3, p4);
    } else {
      res = Add2DParts(p1, p5);
      res = Subtract2DParts(res, p3);
      res = Subtract2DParts(res, p7);
    }
    return res;
  }
  
  // DivideMatrix() -> divide the main matrix into four (n / 2) submatrices
  static Vector<Vector<Vector<Integer>>> DivideMatrix(int[][] mat, int n) {
    Vector<Vector<Vector<Integer>>> v = new Vector<Vector<Vector<Integer>>>();
    for (int i = 0; i < n; i += (n / 2)) {
      for (int j = 0; j < n; j += (n / 2)) {
        Vector<Vector<Integer>> temp_2D = new Vector<Vector<Integer>>();
        for (int k = i; k < (i + (n / 2)); k++) {
          Vector<Integer> temp_1D = new Vector<Integer>();
          for (int l = j; l < (j + (n / 2)); l++) {
            temp_1D.add(mat[k][l]);
          }
          temp_2D.add(temp_1D);
        }
        v.add(temp_2D);
      }
    }
    return v;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // choose table size (must be a power of 2 e.g., 2, 4, 8)
    int n = 0;
    while (true) {
      System.out.print("Choose table size [2, 4, 8]: ");
      n = in.nextInt();
      if (n != 2 && n != 4 && n != 8) {
        System.out.println("Please try again.");
        continue;
      }
      System.out.println();
      break;
    }
    // input first table
    System.out.println("Enter " + n * n + " elements: [1st - " + n + " x " + n + " table]");
    int[][] x = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        x[i][j] = in.nextInt();
      }
    }
    // input second table
    System.out.println("Enter " + n * n + " elements: [2nd - " + n + " x " + n + " table]");
    int[][] y = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        y[i][j] = in.nextInt();
      }
    }
    // divide the ('n' x 'n') matrix into 4 ('n' / 2) submatrices ('x' 2D array)
    Vector<Vector<Vector<Integer>>> v1 = DivideMatrix(x, n);
    // divide the ('n' x 'n') matrix into 4 ('n' / 2) submatrices ('y' 2D array)
    Vector<Vector<Vector<Integer>>> v2 = DivideMatrix(y, n);
    // FOR SIMULATION:
    // 'a' to 'h' submatrices values;
    System.out.println("\nSIMULATION");
    System.out.println("[a - h values]");
    char letter = (char) (97);
    for (int i = 0; i < (int) v1.size(); i++) {
      System.out.println("Submatrix " + letter);
      for (int j = 0; j < (int) v1.get(i).size(); j++) {
        for (int k = 0; k < (int) v1.get(i).get(j).size(); k++) {
          System.out.print(v1.get(i).get(j).get(k) + " ");
        }
        System.out.println("");
      }
      System.out.println("");
      letter = (char) (letter + 1);
    }
    for (int i = 0; i < (int) v2.size(); i++) {
      System.out.println("Submatrix " + letter);
      for (int j = 0; j < (int) v2.get(i).size(); j++) {
        for (int k = 0; k < (int) v2.get(i).get(j).size(); k++) {
          System.out.print(v2.get(i).get(j).get(k) + " ");
        }
        System.out.println("");
      }
      System.out.println("");
      letter = (char) (letter + 1);
    }
    // 'p1' to 'p7' submatrices values
    System.out.println("[p1 - p7 values]");
    Vector<Vector<Vector<Integer>>> p = new Vector<Vector<Vector<Integer>>>();
    for (int i = 0; i < 7; i++) {
      p.add(GetValuesForP(i + 1, v1, v2));
    }
    // 'p' values
    for (int i = 0; i < 7; i++) {
      System.out.println("Submatrix p" + (i + 1) + ": ");
      for (int j = 0; j < (int) p.get(i).size(); j++) {
        for (int k = 0; k < (int) p.get(i).get(j).size(); k++) {
          System.out.print(p.get(i).get(j).get(k) + " ");
        }
        System.out.println("\n");
      }
    }
    // final part
    System.out.println("Final Answer: ");
    Vector<Vector<Vector<Integer>>> res = new Vector<Vector<Vector<Integer>>>();
    for (int i = 0; i < 4; i++) {
      res.add(GetValuesForAnswer(i + 1, p));
    }
    // find the resulting 4 submatrices and store it in a 3D vector
    Vector<Vector<Vector<Integer>>> combine = new Vector<Vector<Vector<Integer>>>();
    for (int i = 0; i < (int) res.size(); i++) {
      Vector<Vector<Integer>> temp_2D = new Vector<Vector<Integer>>();
      for (int j = 0; j < (int) res.get(i).size(); j++) {
        Vector<Integer> temp_1D = new Vector<Integer>();
        for (int k = 0; k < (int) res.get(i).get(j).size(); k++) {
          temp_1D.add(res.get(i).get(j).get(k));
        }
        temp_2D.add(temp_1D);
      }
      combine.add(temp_2D);
    }
    // store them back to their corresponding positions in the 'n' x 'n' matrix
    Vector<Vector<Vector<Integer>>> ans = new Vector<Vector<Vector<Integer>>>();
    for (int i = 0; i < (int) combine.size(); i += 2) {
      Vector<Vector<Integer>> temp_2D = new Vector<Vector<Integer>>();
      for (int j = 0; j < (int) combine.get(i).size(); j++) {
        Vector<Integer> temp_1D = new Vector<Integer>();
        for (int k = 0; k < (int) combine.get(i).get(j).size(); k++) {
          int value = combine.get(i).get(j).get(k);
          temp_1D.add(value);
        }
        for (int k = 0; k < (int) combine.get(i).get(j).size(); k++) {
          int value = combine.get(i + 1).get(j).get(k);
          temp_1D.add(value);
        }
        temp_2D.add(temp_1D);
      }
      ans.add(temp_2D);
    }
    // print the 'n' x 'n' matrix (final answer)
    for (int i = 0; i < (int) ans.size(); i++) {
      for (int j = 0; j < (int) ans.get(i).size(); j++) {
        for (int k = 0; k < (int) ans.get(i).get(j).size(); k++) {
          System.out.print(ans.get(i).get(j).get(k) + " ");
        }
        System.out.println("");
      }
      if (i == (int) ans.size() - 1) {
        System.out.println("");
      }
    }
  }
}
