/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Arrays;
import javax.swing.JTextArea;
/**
 *
 * @author Dracogray
 */
public class tsp_gui extends javax.swing.JFrame {
    static int cost = 0;
    static String path = "";
    String last_path = "";
    int count = 0;
    int n = 0;
    int s = 0;

    // Note: *Use only ONE (1) test case per program testing (because they have the same identifier)
    // TEST CASE 1: (Output should 30, this is from M3S2) (UNCOMMENT below to enable)
    //  static char[] letters = {'A', 'B', 'C', 'D', 'E'};
    //   static int val[][] = {{Integer.MAX_VALUE, 7, 6, 8, 4},
    //       {7, Integer.MAX_VALUE, 8, 5, 6},
    //      {6, 8, Integer.MAX_VALUE, 9, 7},
    //       {8, 5, 9, Integer.MAX_VALUE, 8},
    //     {4, 6, 7, 8, Integer.MAX_VALUE}};

    //     TEST CASE 2: (Output should 17, this is from TSP EXER1) (UNCOMMENT below to enable)
    static char[] letters = {'A', 'B', 'C', 'D', 'E'};
    static int val[][] = {{Integer.MAX_VALUE, 3, 6, 2, 3},
            {3, Integer.MAX_VALUE, 5, 2, 3},
            {6, 5, Integer.MAX_VALUE, 6, 5},
            {2, 2, 6, Integer.MAX_VALUE, 6},
            {3, 3, 5, 6, Integer.MAX_VALUE}};

    // TEST CASE 3: (Output should be 110, this is from TSP EXER2) (UNCOMMENT below to enable)
//  static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};
    // static int val[][]= {{Integer.MAX_VALUE, 20, 23, 27, 29, 34},
    //                   {21, Integer.MAX_VALUE, 19, 26, 31, 24},
    //                     {26, 28, Integer.MAX_VALUE, 15, 36, 26},
    //                   {25, 26, 25, Integer.MAX_VALUE, 23, 28},
    //                    {23, 40, 13, 31, Integer.MAX_VALUE, 10},
    //                  {27, 18, 12, 35, 16, Integer.MAX_VALUE}};

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

    static void Print(int[][] table) {
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
    }

    static Vector<Vector<Integer>> ConvertVector(int[][] table) {
        Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        for (int i = 0; i < (int) table.length; i++) {
            Vector<Integer> temp = new Vector<Integer>();
            for (int j = 0; j < (int) table[i].length; j++) {
                temp.add(table[i][j]);
            }
            v.add(temp);
        }
        return v;
    }

    public tsp_gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea13 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea14 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea15 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea16 = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextArea17 = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea18 = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTextArea19 = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea20 = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextArea21 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jButton4.setVisible(false);
        jButton1.setVisible(false);
        jButton3.setVisible(false);
        jButton2.setText("Ok");
        jButton2.setVisible(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("D");

        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("COST");

        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(51, 153, 255));
        jPanel.setToolTipText("");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Prev");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(5);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setTabSize(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(5);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setTabSize(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTextArea4.setColumns(5);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setTabSize(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTextArea5.setColumns(5);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setTabSize(5);
        jScrollPane5.setViewportView(jTextArea5);

        jTextArea6.setColumns(5);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setTabSize(5);
        jScrollPane6.setViewportView(jTextArea6);

        jTextArea7.setColumns(5);
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setTabSize(5);
        jScrollPane7.setViewportView(jTextArea7);

        jTextArea8.setColumns(5);
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setTabSize(5);
        jScrollPane8.setViewportView(jTextArea8);

        jTextArea9.setColumns(5);
        jTextArea9.setLineWrap(true);
        jTextArea9.setRows(5);
        jTextArea9.setTabSize(5);
        jScrollPane9.setViewportView(jTextArea9);

        jTextArea10.setColumns(5);
        jTextArea10.setLineWrap(true);
        jTextArea10.setRows(5);
        jTextArea10.setTabSize(5);
        jScrollPane10.setViewportView(jTextArea10);

        jTextArea12.setColumns(5);
        jTextArea12.setLineWrap(true);
        jTextArea12.setRows(5);
        jTextArea12.setTabSize(5);
        jScrollPane12.setViewportView(jTextArea12);

        jTextArea13.setColumns(5);
        jTextArea13.setLineWrap(true);
        jTextArea13.setRows(5);
        jTextArea13.setTabSize(5);
        jScrollPane13.setViewportView(jTextArea13);

        jTextArea14.setColumns(5);
        jTextArea14.setLineWrap(true);
        jTextArea14.setRows(5);
        jTextArea14.setTabSize(5);
        jScrollPane14.setViewportView(jTextArea14);

        jTextArea15.setColumns(5);
        jTextArea15.setLineWrap(true);
        jTextArea15.setRows(5);
        jTextArea15.setTabSize(5);
        jScrollPane15.setViewportView(jTextArea15);

        jTextArea16.setColumns(5);
        jTextArea16.setLineWrap(true);
        jTextArea16.setRows(5);
        jTextArea16.setTabSize(5);
        jScrollPane16.setViewportView(jTextArea16);

        jTextArea17.setColumns(5);
        jTextArea17.setLineWrap(true);
        jTextArea17.setRows(5);
        jTextArea17.setTabSize(5);
        jScrollPane17.setViewportView(jTextArea17);

        jTextArea18.setColumns(5);
        jTextArea18.setLineWrap(true);
        jTextArea18.setRows(5);
        jTextArea18.setTabSize(5);
        jScrollPane18.setViewportView(jTextArea18);

        jTextArea19.setColumns(5);
        jTextArea19.setLineWrap(true);
        jTextArea19.setRows(5);
        jTextArea19.setTabSize(5);
        jScrollPane19.setViewportView(jTextArea19);

        jTextArea20.setColumns(5);
        jTextArea20.setLineWrap(true);
        jTextArea20.setRows(5);
        jTextArea20.setTabSize(5);
        jScrollPane20.setViewportView(jTextArea20);

        jTextArea21.setColumns(5);
        jTextArea21.setLineWrap(true);
        jTextArea21.setRows(5);
        jTextArea21.setTabSize(5);
        jScrollPane21.setViewportView(jTextArea21);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("PROCESS");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(13, 13, 13)
                                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(13, 13, 13)
                                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane17)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton3)
                                                .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jScrollPane5)
                                        .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane13)
                                                        .addComponent(jScrollPane15)
                                                        .addComponent(jScrollPane16)
                                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("E");

        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane11.setViewportView(jTextArea11);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choices", "Pre Loaded", "User Input" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("A");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("B");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("C");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setText("Original");

        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setText("Row Minimization");

        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setText("Column Minimization");

        jButton4.setText("FINAL PATH");
        jButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButton4StateChanged(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("Penalty");

        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setText("End");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(58, 58, 58)
                                                                                .addComponent(jLabel5))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(7, 7, 7))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(12, 12, 12)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jButton4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        val[0][0]= Integer.MAX_VALUE;// a
        val[0][1]= Integer.parseInt(jTextField2.getText()); // a
        val[0][2]= Integer.parseInt(jTextField3.getText()); // a
        val[0][3]= Integer.parseInt(jTextField4.getText()); // a
        val[0][4]= Integer.parseInt(jTextField5.getText()); // a
        val[1][0]= Integer.parseInt(jTextField6.getText()); // b
        val[1][1] = Integer.MAX_VALUE; // b
        val[1][2]= Integer.parseInt(jTextField8.getText()); // b
        val[1][3]= Integer.parseInt(jTextField9.getText()); // b
        val[1][4]= Integer.parseInt(jTextField10.getText()); // b
        val[2][0]= Integer.parseInt(jTextField11.getText()); // c
        val[2][1]= Integer.parseInt(jTextField12.getText()); // c
        val[2][2]= Integer.MAX_VALUE; // c
        val[2][3]= Integer.parseInt(jTextField14.getText());
        val[2][4]= Integer.parseInt(jTextField15.getText()); // c
        val[3][0]= Integer.parseInt(jTextField16.getText()); // d
        val[3][1]= Integer.parseInt(jTextField17.getText()); // d
        val[3][2]= Integer.parseInt(jTextField18.getText()); // d
        val[3][3]= Integer.MAX_VALUE; // d
        val[3][4]= Integer.parseInt(jTextField20.getText()); // d
        val[4][0]= Integer.parseInt(jTextField21.getText()); // e
        val[4][1]= Integer.parseInt(jTextField23.getText()); // e
        val[4][2]= Integer.parseInt(jTextField24.getText()); // e
        val[4][3]= Integer.parseInt(jTextField25.getText()); // e
        val[4][4]= Integer.MAX_VALUE; // c
        jButton4.setVisible(true);
    }

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jButton3.setVisible(true);
        jButton4.setVisible(false);
        tsp_gui object = new tsp_gui ();
        // create a copy of 'val' (2D table that contains the values)

        int table[][] = new int[(int) val.length][(int) val.length];
        for (int i = 0; i < (int) table.length; i++) {
            for (int j = 0; j < (int) table[i].length; j++) {
                table[i][j] = val[i][j];
            }
        }
        // newly added code block
        Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        v = ConvertVector(table);
        Vector<Vector<Vector<Integer>>> status = new Vector<Vector<Vector<Integer>>>();
        status.add(v);
        // run a while-loop
        while (true) {
            if (object.Check(table)) {
                // the Check() function will decide if the while-loop will stop
                break;
            }
            //        System.out.println("\nTable Status: Before Row Minimization");
            //        Print(table);
            // first, the table undergoes Row Minimization (if there are no zeroes in a row)
            table = object.RowMinimization(table);
            v = ConvertVector(table);
            status.add(v);
            //        System.out.println("\nTable Status: After Row Minimization");
            //        Print(table);
            // second, the table undergoes Column Minimization (if there are no zeroes in a column)
            //        System.out.println("\nTable Status: Before Column Minimization");
            //        Print(table);
            table = object.ColumnMinimization(table);
            v = ConvertVector(table);
            status.add(v);
            //        System.out.println("\nTable Status: After Column Minimization");
            //        Print(table);
            // third, the table undergoes the Penalty process
            //        System.out.println("\nTable Status: Before Penalty");
            //        Print(table);
            table = object.Penalty(table);
            v = ConvertVector(table);
            status.add(v);
            //        System.out.println("\nTable Status: After Penalty");
            //        Print(table);
        }
        // for previous and next functions (GUI)
        // outer loop ('i') = number of 2D tables (status)
        JTextArea area[] = {jTextArea1,jTextArea2,jTextArea3,jTextArea4,jTextArea5,jTextArea6,jTextArea7,jTextArea8,
                jTextArea9,jTextArea10,jTextArea12,jTextArea13,jTextArea14,jTextArea15,jTextArea16,jTextArea17,jTextArea18,
                jTextArea19,jTextArea20,jTextArea11};
        area[s].setLineWrap(true);
        area[s].setColumns(5);
        area[s].setRows(5);
        area[s].setWrapStyleWord(true);
        area[s].setFont(new Font("monospaced", Font.PLAIN, 8));
        for (int j = 0; j < (int) status.get(count).size(); j++) {
            for (int k = 0; k < (int) status.get(count).get(j).size(); k++) {
                int val = status.get(count).get(j).get(k);
                String a =((val == Integer.MAX_VALUE ? "-" : val) + " ");
                area[s].append(a);
            }
        }
        count++;
        s++;
        if (count == 1){
            jTextField27.setBackground(Color.yellow);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 2 || count == 5 || count == 8 ||
                count == 11 || count == 14 || count == 17){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.yellow);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 3 || count == 6 || count == 9 ||
                count == 12 || count == 15 || count == 18){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.yellow);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 4 || count == 7 || count == 10 ||
                count == 13 || count == 16 || count == 19){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.yellow);
            jTextField31.setBackground(Color.white);
        }
        if (count == status.size()){
            jButton1.setVisible(false);
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.yellow);
            jTextField31.setBackground(Color.yellow);
        }


    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jButton1.setVisible(true);
        JTextArea area[] = {jTextArea1,jTextArea2,jTextArea3,jTextArea4,jTextArea5,jTextArea6,jTextArea7,jTextArea8,
                jTextArea9,jTextArea10,jTextArea12,jTextArea13,jTextArea14,jTextArea15,jTextArea16,jTextArea17,jTextArea18,
                jTextArea19,jTextArea20,jTextArea21,jTextArea11};
        --count;
        --s;
        if ( n <= count) {

            area[count].setText("");

        }
        if (count == 1){
            jTextField27.setBackground(Color.yellow);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 2 || count == 5 || count == 8 ||
                count == 11 || count == 14 || count == 17){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.yellow);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 3 || count == 6 || count == 9 ||
                count == 12 || count == 15 || count == 18){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.yellow);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }
        if (count == 4 || count == 7 || count == 10 ||
                count == 13 || count == 16 || count == 19){
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.yellow);
            jTextField31.setBackground(Color.white);
        }


        if (count == 0){
            jButton3.setVisible(false);
            jTextField27.setBackground(Color.white);
            jTextField28.setBackground(Color.white);
            jTextField29.setBackground(Color.white);
            jTextField30.setBackground(Color.white);
            jTextField31.setBackground(Color.white);
        }

    }

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

        String selectedValue = jComboBox1.getSelectedItem().toString();{
            switch (selectedValue){
                case "Pre Loaded":
                    jButton2.setVisible(false);
                    jButton4.setVisible(true);
                    jTextField1.setText(" - "); // a 1
                    jTextField2.setText(String.valueOf(val[0][1])); // a 2
                    jTextField3.setText(String.valueOf(val[0][2])); // a 3
                    jTextField4.setText(String.valueOf(val[0][3])); // a 4
                    jTextField5.setText(String.valueOf(val[0][4])); // a 5
                    jTextField6.setText(String.valueOf(val[1][0])); // b 1
                    jTextField7.setText(" - "); // b 2
                    jTextField8.setText(String.valueOf(val[1][2])); // b 3
                    jTextField9.setText(String.valueOf(val[1][3])); // b 4
                    jTextField10.setText(String.valueOf(val[1][4])); // b 5
                    jTextField11.setText(String.valueOf(val[2][0])); // c 1
                    jTextField12.setText(String.valueOf(val[2][1])); // c 2
                    jTextField13.setText(" - "); // c 3
                    jTextField14.setText(String.valueOf(val[2][3])); // c 4
                    jTextField15.setText(String.valueOf(val[2][4])); // c 5
                    jTextField16.setText(String.valueOf(val[3][0])); // d 1
                    jTextField17.setText(String.valueOf(val[3][1])); // d 2
                    jTextField18.setText(String.valueOf(val[3][2])); // d 3
                    jTextField19.setText(" - "); // d 4
                    jTextField20.setText(String.valueOf(val[3][4])); // d 5
                    jTextField21.setText(String.valueOf(val[4][0])); // e 1
                    jTextField23.setText(String.valueOf(val[4][1])); // e 2
                    jTextField24.setText(String.valueOf(val[4][2])); // e 3
                    jTextField25.setText(String.valueOf(val[4][3])); // e 4
                    jTextField26.setText(" - "); // e 5
                    jTextField1.setEditable(false);
                    jTextField2.setEditable(false);
                    jTextField3.setEditable(false);
                    jTextField4.setEditable(false);
                    jTextField5.setEditable(false);
                    jTextField6.setEditable(false);
                    jTextField7.setEditable(false);
                    jTextField8.setEditable(false);
                    jTextField9.setEditable(false);
                    jTextField10.setEditable(false);
                    jTextField11.setEditable(false);
                    jTextField12.setEditable(false);
                    jTextField13.setEditable(false);
                    jTextField14.setEditable(false);
                    jTextField15.setEditable(false);
                    jTextField16.setEditable(false);
                    jTextField17.setEditable(false);
                    jTextField18.setEditable(false);
                    jTextField19.setEditable(false);
                    jTextField20.setEditable(false);
                    jTextField21.setEditable(false);
                    jTextField23.setEditable(false);
                    jTextField24.setEditable(false);
                    jTextField25.setEditable(false);
                    jTextField26.setEditable(false);
                    jTextField1.setVisible(true);
                    jTextField2.setVisible(true);
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField6.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField8.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField10.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jTextField15.setVisible(true);
                    jTextField16.setVisible(true);
                    jTextField17.setVisible(true);
                    jTextField18.setVisible(true);
                    jTextField19.setVisible(true);
                    jTextField20.setVisible(true);
                    jTextField21.setVisible(true);
                    jTextField23.setVisible(true);
                    jTextField24.setVisible(true);
                    jTextField25.setVisible(true);
                    jTextField26.setVisible(true);
                    break;
                case "User Input":
                    jButton4.setVisible(false);
                    jTextField1.setText(" - "); // a 1
                    jTextField7.setText(" - "); // b 2
                    jTextField13.setText(" - "); // c 3
                    jTextField19.setText(" - "); // d 4
                    jTextField26.setText(" - "); // e 5
                    jTextField1.setEditable(false);
                    jTextField2.setEditable(true);
                    jTextField3.setEditable(true);
                    jTextField4.setEditable(true);
                    jTextField5.setEditable(true);
                    jTextField6.setEditable(true);
                    jTextField7.setEditable(false);
                    jTextField8.setEditable(true);
                    jTextField9.setEditable(true);
                    jTextField10.setEditable(true);
                    jTextField11.setEditable(true);
                    jTextField12.setEditable(true);
                    jTextField13.setEditable(false);
                    jTextField14.setEditable(true);
                    jTextField15.setEditable(true);
                    jTextField16.setEditable(true);
                    jTextField17.setEditable(true);
                    jTextField18.setEditable(true);
                    jTextField19.setEditable(false);
                    jTextField20.setEditable(true);
                    jTextField21.setEditable(true);
                    jTextField23.setEditable(true);
                    jTextField24.setEditable(true);
                    jTextField25.setEditable(true);
                    jTextField26.setEditable(false);
                    jButton2.setVisible(true);
                    jTextField1.setVisible(true);
                    jTextField2.setVisible(true);
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField6.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField8.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField10.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jTextField15.setVisible(true);
                    jTextField16.setVisible(true);
                    jTextField17.setVisible(true);
                    jTextField18.setVisible(true);
                    jTextField19.setVisible(true);
                    jTextField20.setVisible(true);
                    jTextField21.setVisible(true);
                    jTextField23.setVisible(true);
                    jTextField24.setVisible(true);
                    jTextField25.setVisible(true);
                    jTextField26.setVisible(true);
                    break;
                default:
                    jTextField1.setVisible(false);
                    jTextField2.setVisible(false);
                    jTextField3.setVisible(false);
                    jTextField4.setVisible(false);
                    jTextField5.setVisible(false);
                    jTextField6.setVisible(false);
                    jTextField7.setVisible(false);
                    jTextField8.setVisible(false);
                    jTextField9.setVisible(false);
                    jTextField10.setVisible(false);
                    jTextField11.setVisible(false);
                    jTextField12.setVisible(false);
                    jTextField13.setVisible(false);
                    jTextField14.setVisible(false);
                    jTextField15.setVisible(false);
                    jTextField16.setVisible(false);
                    jTextField17.setVisible(false);
                    jTextField18.setVisible(false);
                    jTextField19.setVisible(false);
                    jTextField20.setVisible(false);
                    jTextField21.setVisible(false);
                    jTextField23.setVisible(false);
                    jTextField24.setVisible(false);
                    jTextField25.setVisible(false);
                    jTextField26.setVisible(false);
                    break;

            }
        }
        // TODO add your handling code here:
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        tsp_gui object = new tsp_gui();
        int table[][] = new int[(int) val.length][(int) val.length];
        for (int i = 0; i < (int) table.length; i++) {
            for (int j = 0; j < (int) table[i].length; j++) {
                table[i][j] = val[i][j];
            }
        }
        // newly added code block
        Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        v = ConvertVector(table);
        Vector<Vector<Vector<Integer>>> status = new Vector<Vector<Vector<Integer>>>();
        status.add(v);
        // run a while-loop
        while (true) {
            if (object.Check(table)) {
                // the Check() function will decide if the while-loop will stop
                break;
            }
//        System.out.println("\nTable Status: Before Row Minimization");
//        Print(table);
            // first, the table undergoes Row Minimization (if there are no zeroes in a row)
            table = object.RowMinimization(table);
            v = ConvertVector(table);
            status.add(v);
//        System.out.println("\nTable Status: After Row Minimization");
//        Print(table);
            // second, the table undergoes Column Minimization (if there are no zeroes in a column)
//        System.out.println("\nTable Status: Before Column Minimization");
//        Print(table);
            table = object.ColumnMinimization(table);
            v = ConvertVector(table);
            status.add(v);
//        System.out.println("\nTable Status: After Column Minimization");
//        Print(table);
            // third, the table undergoes the Penalty process
//        System.out.println("\nTable Status: Before Penalty");
//        Print(table);
            table = object.Penalty(table);
            v = ConvertVector(table);
            status.add(v);
//        System.out.println("\nTable Status: After Penalty");
//        Print(table);
        }
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
        Vector<String> separate = new Vector<String>();
        for (int i = 0; i < (int) path.length(); i += 2) {
            String temp = String.valueOf(path.charAt(i)) + String.valueOf(path.charAt(i + 1));
            separate.add(temp);
        }
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
        jTextArea11.append(last_path + " = " + cost + '\n');
        jButton4.setVisible(false);
        jButton1.setVisible(true);
        jButton3.setVisible(true);
        jTextArea11.setEditable(false);

    }

    private void jButton4StateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        tsp_gui object = new tsp_gui();
        object.show();

    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextArea16;
    private javax.swing.JTextArea jTextArea17;
    private javax.swing.JTextArea jTextArea18;
    private javax.swing.JTextArea jTextArea19;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea20;
    private javax.swing.JTextArea jTextArea21;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration
}
