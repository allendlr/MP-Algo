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

public class GaussianEliminationAlgo {
  static Vector<Vector<Double>> GetMatrix(double[][] matrix) {
    Vector<Vector<Double>> temp_2D = new Vector<Vector<Double>>();
    for (int i = 0; i < (int) matrix.length; i++) {
      Vector<Double> temp_1D = new Vector<Double>();
      for (int j = 0; j < (int) matrix[i].length; j++) {
        temp_1D.add(matrix[i][j]);
      }
      temp_2D.add(temp_1D);
    }
    return temp_2D;
  }
  
  static void Print(double[][] matrix) {
    for (int i = 0; i < (int) matrix.length; i++) {
      for (int j = 0; j < (int) matrix[i].length; j++) {
        if (matrix[i][j] % 1 == 0) {
          System.out.print((int) (matrix[i][j]) + " ");
        } else {
          System.out.printf("%.2f ", matrix[i][j]);
        }
      }
      System.out.println("");
    }
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 0;
    while (true) {
      System.out.print("Enter number of equations (2, 3, 4, 5, 6): ");
      n = in.nextInt();
      if (n != 2 && n != 3 && n != 4 && n != 5 && n != 6) {
        System.out.println("Please try again.");
      } else {
        break;
      }
    }
    // Choose if input or random
    double[][] matrix = new double[n][n + 1]; 
    while (true) {
      System.out.print("Randomize values or not (Y/N): ");
      char ch = in.next().charAt(0);
      if (ch == 'Y' || ch == 'y') {
        int mn = 1;
        int mx = 100;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n + 1; j++) {
            matrix[i][j] = (int) Math.floor(Math.random() * (mx - mn + 1) + mn);
          }
        }
        break;
      } else if (ch == 'N' || ch == 'n') {
        System.out.println("\nValues for the system of linear equations");
        for (int i = 0; i < n; i++) {
          System.out.println("Equation #" + (i + 1) + " values: (Enter " + (n + 1) + " values)");
          for (int j = 0; j < n + 1; j++) {
            matrix[i][j] = in.nextDouble();
          }
        }
        break;
      }
      System.out.println("Please try again.");
    }
    // print matrix form
    System.out.println("\nEquation Form:");
    for (int i = 0; i < n; i++) {
      int coeff = 97;
      for (int j = 0; j < n + 1; j++) {
        if (j == n) {
          System.out.print(" = ");
        } else if (j > 0) {
          System.out.print(matrix[i][j] > 0 ? " + " : " - ");
        }
        if (matrix[i][j] % 1 == 0) {
          int val = (int) (matrix[i][j]);
          if (j > 0 && j < n) {
            System.out.print(val > 0 ? val: -val);
          } else {
            System.out.print(val);
          }
        } else {
          double val = matrix[i][j];
          if (j > 0 && j < n) {
            System.out.printf("%.2f", val > 0 ? val : -val);
          } else {
            System.out.printf("%.2f", val);
          }
        }
        if (j < n) {
          System.out.print((char) (coeff));
        }
        coeff++;
      }
      System.out.println("");
    }
    // print the matrix form
    System.out.println("\nMatrix Form:");
    Print(matrix);
    // solving part (for upper triangular matrix)
    Vector<Vector<Vector<Double>>> v = new Vector<Vector<Vector<Double>>>();
    int step = 1;
    Vector<String> operations = new Vector<String>();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double quotient = matrix[j][i] / matrix[i][i];
        operations.add(String.valueOf("R" + (j + 1) + " + " + -quotient + "R" + (i + 1)));
        for (int k = 0; k < n + 1; k++) {
          matrix[j][k] = matrix[j][k] - (matrix[i][k] * quotient);
        }
        // store tables in 3D vector (for simulation)
        v.add(GetMatrix(matrix));
      }
    }
    // simulation
    System.out.println("\nSimulation");
    for (int i = 0; i < (int) v.size(); i++) {
      System.out.print("\nRow Operation: ");
      System.out.println(operations.get(i));
      for (int j = 0; j < (int) v.get(i).size(); j++) {
        for (int k = 0; k < (int) v.get(i).get(j).size(); k++) {
          double element = v.get(i).get(j).get(k);
          if (element % 1 == 0) {
            System.out.print((int) (element) + " ");
          } else {
            System.out.printf("%.2f ", element);
          }
        }
        System.out.println("");
      }
    }
    // upper triangular matrix
    System.out.println("\nUpper Triangular Matrix");
    Print(matrix);
    // getting the values part    
    double[] solutions = new double[n];
    for (int i = n - 1; i >= 0; i--) {
      double res = 0;
      for (int j = i + 1; j < n; j++) {
        res += (matrix[i][j] * solutions[j]);
      }
      solutions[i] = (matrix[i][n] - res) / matrix[i][i];
    }
    // final part (solutions)
    boolean checker = true;
    for (int i = 0; i < n; i++) {
      Double d = new Double(solutions[i]);
      if (d.isNaN()) {
        checker = false;
        break;
      }
    }
    System.out.println("\nSolutions:");
    if (checker) {
      int coeff = 97;
      for (int i = 0; i < (int) solutions.length; i++) {
        System.out.println((char) (coeff) + " = " + solutions[i]);
        coeff++;
      }
    } else {
      System.out.println("Infinitely Many Solutions or No Solutions");
    }
    System.out.println("");
  }
}
