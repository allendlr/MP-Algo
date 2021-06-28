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
public class matrix_gui extends javax.swing.JFrame {
    int n = 0;
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


    public matrix_gui() {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFielda = new javax.swing.JTextField();
        jTextFieldb = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Table Size", "2", "4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextFielda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFielda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldaActionPerformed(evt);
            }
        });

        jTextFieldb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldbActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SIMULATION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("[a - h values]");

        jLabel3.setText("Submatrix a");

        jLabel4.setText("Submatrix b");

        jLabel5.setText("Submatrix c");

        jLabel6.setText("Submatrix d");

        jLabel7.setText("Submatrix e");

        jLabel8.setText("Submatrix f");

        jLabel9.setText("Submatrix g");

        jLabel10.setText("Submatrix h");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("[p1 - p7 values]");

        jLabel12.setText("Submatrix p4:");

        jLabel13.setText("Submatrix p5: ");

        jLabel14.setText("Submatrix p6:");

        jLabel15.setText("Submatrix p7:");

        jLabel17.setText("Submatrix p1: ");

        jLabel18.setText("Submatrix p2:");
        jLabel18.setToolTipText("");

        jLabel19.setText("Submatrix p3: ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Final Answer");

        jButton2.setText("Prev");

        jButton3.setText("Next");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane8.setViewportView(jTextArea8);

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane9.setViewportView(jTextArea9);

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jScrollPane10.setViewportView(jTextArea10);

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane11.setViewportView(jTextArea11);

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jScrollPane12.setViewportView(jTextArea12);

        jTextArea13.setColumns(20);
        jTextArea13.setRows(5);
        jScrollPane13.setViewportView(jTextArea13);

        jTextArea14.setColumns(20);
        jTextArea14.setRows(5);
        jScrollPane14.setViewportView(jTextArea14);

        jTextArea15.setColumns(20);
        jTextArea15.setRows(5);
        jScrollPane15.setViewportView(jTextArea15);

        jTextArea16.setColumns(20);
        jTextArea16.setRows(5);
        jScrollPane16.setViewportView(jTextArea16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(316, 316, 316)
                                                .addComponent(jLabel1)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextFielda, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(115, 115, 115)
                                                                .addComponent(jLabel2))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextFieldb, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(31, 31, 31)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                                                .addGap(32, 32, 32)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel3)
                                                                                        .addComponent(jLabel4)
                                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel6)
                                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(30, 30, 30)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(38, 38, 38)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel12)
                                                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(62, 62, 62))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addGap(146, 146, 146))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel15)
                                                                .addGap(146, 146, 146))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(134, 134, 134))))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(206, 206, 206))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(280, 280, 280))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3)
                                                .addGap(265, 265, 265))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)))
                                                .addComponent(jTextFielda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addComponent(jTextFieldb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel11))
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jLabel3))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel12)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabel4)
                                                                                        .addComponent(jLabel8)
                                                                                        .addComponent(jLabel18)
                                                                                        .addComponent(jLabel13)))
                                                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel19)
                                                        .addComponent(jLabel14))
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFielda.getAccessibleContext().setAccessibleDescription("");
        jTextFieldb.getAccessibleContext().setAccessibleDescription("");
        jTextField1.getAccessibleContext().setAccessibleDescription("");
        jTextField2.getAccessibleContext().setAccessibleDescription("");
        jTextField3.getAccessibleContext().setAccessibleDescription("");
        jTextField4.getAccessibleContext().setAccessibleDescription("");
        jTextField5.getAccessibleContext().setAccessibleDescription("");
        jTextField6.getAccessibleContext().setAccessibleDescription("");
        jTextField7.getAccessibleContext().setAccessibleDescription("");
        jTextField8.getAccessibleContext().setAccessibleDescription("");
        jTextField9.getAccessibleContext().setAccessibleDescription("");
        jTextField10.getAccessibleContext().setAccessibleDescription("");
        jTextField11.getAccessibleContext().setAccessibleDescription("");
        jTextField12.getAccessibleContext().setAccessibleDescription("");
        jTextField13.getAccessibleContext().setAccessibleDescription("");
        jTextField14.getAccessibleContext().setAccessibleDescription("");
        jTextField15.getAccessibleContext().setAccessibleDescription("");
        jTextField16.getAccessibleContext().setAccessibleDescription("");
        jTextField17.getAccessibleContext().setAccessibleDescription("");
        jTextField18.getAccessibleContext().setAccessibleDescription("");
        jTextField19.getAccessibleContext().setAccessibleDescription("");
        jTextField20.getAccessibleContext().setAccessibleDescription("");
        jTextField21.getAccessibleContext().setAccessibleDescription("");
        jTextField22.getAccessibleContext().setAccessibleDescription("");
        jTextField23.getAccessibleContext().setAccessibleDescription("");
        jTextField24.getAccessibleContext().setAccessibleDescription("");
        jTextField25.getAccessibleContext().setAccessibleDescription("");
        jTextField26.getAccessibleContext().setAccessibleDescription("");
        jTextField27.getAccessibleContext().setAccessibleDescription("");
        jTextField28.getAccessibleContext().setAccessibleDescription("");
        jTextField29.getAccessibleContext().setAccessibleDescription("");
        jTextField30.getAccessibleContext().setAccessibleDescription("");
        jTextField31.getAccessibleContext().setAccessibleDescription("");
        jTextField32.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

        String selectedValue = jComboBox1.getSelectedItem().toString();{
            switch (selectedValue){
                case "2":
                    jTextFielda.setText(" Enter 4 elements: [ 1st - 2 x 2 table ] ");
                    jTextFielda.setEditable(false);
                    jTextFieldb.setText(" Enter 4 elements: [ 2nd - 2 x 2 table ] ");
                    jTextFieldb.setEditable(false);
                    jTextField1.setVisible(true);
                    jTextField2.setVisible(true);
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField17.setVisible(true);
                    jTextField18.setVisible(true);
                    jTextField19.setVisible(true);
                    jTextField20.setVisible(true);
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
                    jTextField21.setVisible(false);
                    jTextField22.setVisible(false);
                    jTextField23.setVisible(false);
                    jTextField24.setVisible(false);
                    jTextField25.setVisible(false);
                    jTextField26.setVisible(false);
                    jTextField27.setVisible(false);
                    jTextField28.setVisible(false);
                    jTextField29.setVisible(false);
                    jTextField30.setVisible(false);
                    jTextField31.setVisible(false);
                    jTextField32.setVisible(false);
                    break;
                case "4":
                    jTextFielda.setText(" Enter 16 elements: [ 1st - 4 x 4 table ] ");
                    jTextFielda.setEditable(false);
                    jTextFieldb.setText(" Enter 16 elements: [ 2nd - 4 x 4 table ] ");
                    jTextFieldb.setEditable(false);
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
                    jTextField22.setVisible(true);
                    jTextField23.setVisible(true);
                    jTextField24.setVisible(true);
                    jTextField25.setVisible(true);
                    jTextField26.setVisible(true);
                    jTextField27.setVisible(true);
                    jTextField28.setVisible(true);
                    jTextField29.setVisible(true);
                    jTextField30.setVisible(true);
                    jTextField31.setVisible(true);
                    jTextField32.setVisible(true);
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
                    jTextField22.setVisible(false);
                    jTextField23.setVisible(false);
                    jTextField24.setVisible(false);
                    jTextField25.setVisible(false);
                    jTextField26.setVisible(false);
                    jTextField27.setVisible(false);
                    jTextField28.setVisible(false);
                    jTextField29.setVisible(false);
                    jTextField30.setVisible(false);
                    jTextField31.setVisible(false);
                    jTextField32.setVisible(false);
                    break;

            }
        }
        // TODO add your handling code here:
    }

    private void jTextFieldaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int[][] x = new int[n][n];
        int[][] y = new int[n][n];
        String selectedValue = jComboBox1.getSelectedItem().toString();{
            switch (selectedValue){
                case "2":
                    x[0][0]= Integer.parseInt(jTextField1.getText());    // a
                    x[0][1]= Integer.parseInt(jTextField2.getText());    // b
                    x[1][0]= Integer.parseInt(jTextField3.getText());    // c
                    x[1][1]= Integer.parseInt(jTextField4.getText());    // d
                    y[0][0]= Integer.parseInt(jTextField17.getText());   // e
                    y[0][1]= Integer.parseInt(jTextField18.getText());   // f
                    y[1][0]= Integer.parseInt(jTextField19.getText());   // g
                    y[1][1]= Integer.parseInt(jTextField20.getText());   // h
                    break;
                case "4":
                    x[0][0]= Integer.parseInt(jTextField1.getText());   //1 a
                    x[0][1]= Integer.parseInt(jTextField2.getText());   //2
                    x[1][0]= Integer.parseInt(jTextField5.getText());   //5
                    x[1][1]= Integer.parseInt(jTextField6.getText());   //6
                    x[0][2]= Integer.parseInt(jTextField3.getText());   //3 b
                    x[0][3]= Integer.parseInt(jTextField4.getText());   //4
                    x[1][2]= Integer.parseInt(jTextField7.getText());   //7
                    x[1][3]= Integer.parseInt(jTextField8.getText());   //8
                    x[2][0]= Integer.parseInt(jTextField9.getText());   //9 c
                    x[2][1]= Integer.parseInt(jTextField10.getText());  //10
                    x[3][0]= Integer.parseInt(jTextField13.getText());  //13
                    x[3][1]= Integer.parseInt(jTextField14.getText());  //14
                    x[2][2]= Integer.parseInt(jTextField11.getText());   //11 d
                    x[2][3]= Integer.parseInt(jTextField12.getText());   //12
                    x[3][2]= Integer.parseInt(jTextField15.getText());   //15
                    x[3][3]= Integer.parseInt(jTextField16.getText());   //16
                    y[0][0]= Integer.parseInt(jTextField17.getText());  //17 e
                    y[0][1]= Integer.parseInt(jTextField18.getText());  //18
                    y[1][0]= Integer.parseInt(jTextField21.getText());  //21
                    y[1][1]= Integer.parseInt(jTextField22.getText());  //22
                    y[0][2]= Integer.parseInt(jTextField19.getText());  //19 f
                    y[0][3]= Integer.parseInt(jTextField20.getText());  //20
                    y[1][2]= Integer.parseInt(jTextField23.getText());  //23
                    y[1][3]= Integer.parseInt(jTextField24.getText());  //24
                    y[2][0]= Integer.parseInt(jTextField25.getText());  //25 g
                    y[2][1]= Integer.parseInt(jTextField26.getText());  //26
                    y[3][0]= Integer.parseInt(jTextField29.getText());  //29
                    y[3][1]= Integer.parseInt(jTextField30.getText());  //30
                    y[2][2]= Integer.parseInt(jTextField27.getText());  //27 h
                    y[2][3]= Integer.parseInt(jTextField28.getText());  //28
                    y[3][2]= Integer.parseInt(jTextField31.getText());  //31
                    y[3][3]= Integer.parseInt(jTextField32.getText());  //32
                    break;
                default:
                    jTextField1.setText("error");
                    break;
            }
        }
    }

    /**
     * @param args the commanda line arguments
     */
    public static void main(String args[]) {
        matrix_gui object = new matrix_gui();
        object.show();


    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextArea jTextArea2;
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
    private javax.swing.JTextField jTextField22;
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
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFielda;
    private javax.swing.JTextField jTextFieldb;
    // End of variables declaration
}
