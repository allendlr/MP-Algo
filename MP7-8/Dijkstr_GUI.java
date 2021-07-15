import java.io.*;
import java.util.*;

public class Dijkstr_GUI extends javax.swing.JFrame {
    int n;
    char l = 'A';
    char[] letters = new char[n];
    int [][] a = new int[n][n];
    static int[] res;
    int k;
    int count = 0;
    static Vector<Vector<Integer>> table_status;
    static Vector<Vector<Boolean>> visited_status;
    static int ConvertLetter(int n, char starting_vertex, char[] letters) {
        int vertex = -1;
        for (int i = 0; i < n; i++) {
            if (letters[i] == starting_vertex) {
                vertex = i;
                break;
            }
        }
        return vertex;
    }
    static int GetMinimumDistance(int[] distance, boolean[] visited) {
        int mn = Integer.MAX_VALUE;
        int id = -1;
        for (int i = 0; i < (int) distance.length; i++) {
            if (!visited[i] && distance[i] <= mn) {
                mn = distance[i];
                id = i;
            }
        }
        return id;
    }
    static Vector<Integer> ConvertIntegerArray(int[] distance) {
        Vector<Integer> temp_1D = new Vector<Integer>();
        for (int i = 0; i < (int) distance.length; i++) {
            temp_1D.add(distance[i]);
        }
        return temp_1D;
    }
    static Vector<Boolean> ConvertBooleanArray(boolean[] visited) {
        Vector<Boolean> temp_1D = new Vector<Boolean>();
        for (int i = 0; i < (int) visited.length; i++) {
            temp_1D.add(visited[i]);
        }
        return temp_1D;
    }
    static int[] GetShortestPath(int[][] a, int start) {
        int n = (int) a.length;
        table_status = new Vector<Vector<Integer>>();
        visited_status = new Vector<Vector<Boolean>>();
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[start] = 0;
        table_status.add(ConvertIntegerArray(distance));
        visited[start] = true;
        visited_status.add(ConvertBooleanArray(visited));
        visited[start] = false;
        for (int i = 0; i < n; i++) {
            int origin = GetMinimumDistance(distance, visited);
            visited[origin] = true;
            for (int j = 0; j < n; j++) {
                int alternative = distance[origin] + a[origin][j];
                if (!visited[j] && a[origin][j] != 0 && distance[origin] != Integer.MAX_VALUE && alternative < distance[j]) {
                    distance[j] = alternative;
                }
            }
            table_status.add(ConvertIntegerArray(distance));
            visited_status.add(ConvertBooleanArray(visited));
        }
        return distance;
    }
    public Dijkstr_GUI() {
        initComponents();
    }
    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Table Size:", "2", "3", "4", "5", "6" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("User Input");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Randomize");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Starting Point");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("A");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("B");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C");
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("Confirm Table");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("D");
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("E");
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("F");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("A");
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("B");
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("C");
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("D");
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("E");
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("F");
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setText("Original Table");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("Next");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);
        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Simulation:");
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Unvisited Vertices:");
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("A");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("B");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("C");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("D");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("E");
        jButton7.setToolTipText("");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("F");
        jButton8.setToolTipText("");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Starting Vertex:");
        jTextField1.setEnabled(false);jTextField2.setEnabled(false);jTextField3.setEnabled(false);jTextField4.setEnabled(false);jTextField5.setEnabled(false);jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);jTextField8.setEnabled(false);jTextField9.setEnabled(false);jTextField10.setEnabled(false);jTextField11.setEnabled(false);jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);jTextField14.setEnabled(false);jTextField15.setEnabled(false);jTextField16.setEnabled(false);jTextField17.setEnabled(false);jTextField18.setEnabled(false);
        jTextField19.setEnabled(false);jTextField20.setEnabled(false);jTextField21.setEnabled(false);jTextField22.setEnabled(false);jTextField23.setEnabled(false);jTextField24.setEnabled(false);
        jTextField25.setEnabled(false);jTextField26.setEnabled(false);jTextField27.setEnabled(false);jTextField28.setEnabled(false);jTextField29.setEnabled(false);jTextField30.setEnabled(false);
        jTextField31.setEnabled(false);jTextField32.setEnabled(false);jTextField33.setEnabled(false);jTextField34.setEnabled(false);jTextField35.setEnabled(false);jTextField36.setEnabled(false);
        jButton1.setEnabled(false);jButton2.setEnabled(false);jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(false);
        jButton7.setEnabled(false);jButton8.setEnabled(false);jButton9.setEnabled(false);jButton10.setEnabled(false);jButton11.setEnabled(false);
        jTextArea1.setEnabled(false);jTextArea2.setEnabled(false);jTextArea3.setEnabled(false);jTextArea4.setEnabled(false);
        jScrollPane1.setEnabled(false);jScrollPane2.setEnabled(false);jScrollPane3.setEnabled(false);jScrollPane4.setEnabled(false);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton9)
                                                .addGap(77, 77, 77))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(81, 81, 81)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                        .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.LEADING)))
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                        .addComponent(jTextField2)
                                                                                        .addComponent(jTextField14)
                                                                                        .addComponent(jTextField20)
                                                                                        .addComponent(jTextField26)
                                                                                        .addComponent(jTextField32))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                        .addComponent(jTextField9)
                                                                                        .addComponent(jTextField15)
                                                                                        .addComponent(jTextField21)
                                                                                        .addComponent(jTextField27)
                                                                                        .addComponent(jTextField33))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                        .addComponent(jTextField10)
                                                                                        .addComponent(jTextField16)
                                                                                        .addComponent(jTextField22)
                                                                                        .addComponent(jTextField28)
                                                                                        .addComponent(jTextField34))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                                        .addComponent(jTextField11)
                                                                                                        .addComponent(jTextField17)
                                                                                                        .addComponent(jTextField23)
                                                                                                        .addComponent(jTextField29)
                                                                                                        .addComponent(jTextField35))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                                                                                        .addComponent(jTextField12)
                                                                                                        .addComponent(jTextField18)
                                                                                                        .addComponent(jTextField24)
                                                                                                        .addComponent(jTextField30)
                                                                                                        .addComponent(jTextField36))))))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(jLabel14)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jLabel15)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel16)
                                                                .addGap(0, 0, 0)))
                                                .addGap(7, 7, 7))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(114, 114, 114)
                                                                .addComponent(jLabel1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton11)
                                                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton9))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel15)
                                                                .addComponent(jLabel16))
                                                        .addComponent(jLabel14))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton11)))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        jLabel4.getAccessibleContext().setAccessibleDescription("");
        jLabel5.getAccessibleContext().setAccessibleDescription("");
        pack();
    }
    public void ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        char[] letters = new char[n];
        int start = 1;
        char starting_vertex;
        if(jComboBox1.getSelectedItem()== "2"){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            n = 2;
        }else if (jComboBox1.getSelectedItem()== "3"){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            n = 3;
        }else if (jComboBox1.getSelectedItem()== "4"){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            n = 4;
        }else if (jComboBox1.getSelectedItem()== "5"){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            n = 5;
        }else if (jComboBox1.getSelectedItem()== "6"){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            n = 6;
        }
        if (evt.getSource() == jButton3){
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            l = 'A';
            jButton3.setEnabled(true);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        } else if (evt.getSource() == jButton4){
            l = 'B';
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);jButton4.setEnabled(true);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        } else if (evt.getSource() == jButton5){
            l = 'C';
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(true);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        } else if (evt.getSource() == jButton6){
            l = 'D';
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(true);jButton7.setEnabled(false);jButton8.setEnabled(false);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        } else if (evt.getSource() == jButton7){
            l = 'E';
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(true);jButton8.setEnabled(false);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        } else if (evt.getSource() == jButton8){
            l = 'F';
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(true);
            jButton10.setVisible(true);jButton10.setEnabled(true);
        }
        starting_vertex = l;
        if (evt.getSource() == jButton2){
            jButton1.setEnabled(false);
            if(jComboBox1.getSelectedItem()== "2"){
                n = 2;
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(false);jButton6.setVisible(false);jButton7.setVisible(false);jButton8.setVisible(false);
            }else if (jComboBox1.getSelectedItem()== "3"){
                n = 3;
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(false);jButton7.setVisible(false);jButton8.setVisible(false);
            }else if (jComboBox1.getSelectedItem()== "4"){
                n = 4;
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(false);jButton8.setVisible(false);
            }else if (jComboBox1.getSelectedItem()== "5"){
                n = 5;
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(true);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(true);jButton8.setVisible(false);
            }else if (jComboBox1.getSelectedItem()== "6"){
                n = 6;
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(true);jButton8.setEnabled(true);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(true);jButton8.setVisible(true);
            }
            int [][] b = new int[n][n];
            int end = 20;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        b[i][j] = (int) Math.floor(Math.random() * (end - start + 1) + start);

                    }
                    a = b;
                }
            }
        }else if (evt.getSource() == jButton1){
            jButton9.setEnabled(true);
            jButton2.setEnabled(false);
            if (jComboBox1.getSelectedItem() == "2") {
                jTextField1.setEnabled(false);jTextField2.setEnabled(true);
                jTextField7.setEnabled(true);jTextField8.setEnabled(false);
            } else if (jComboBox1.getSelectedItem() == "3") {
                jTextField1.setEnabled(false);jTextField2.setEnabled(true);jTextField3.setEnabled(true);
                jTextField7.setEnabled(true);jTextField8.setEnabled(false);jTextField9.setEnabled(true);
                jTextField13.setEnabled(true);jTextField14.setEnabled(true);jTextField15.setEnabled(false);
            } else if (jComboBox1.getSelectedItem() == "4") {
                jTextField1.setEnabled(false);jTextField2.setEnabled(true);jTextField3.setEnabled(true);jTextField4.setEnabled(true);
                jTextField7.setEnabled(true);jTextField8.setEnabled(false);jTextField9.setEnabled(true);jTextField10.setEnabled(true);
                jTextField13.setEnabled(true);jTextField14.setEnabled(true);jTextField15.setEnabled(false);jTextField16.setEnabled(true);
                jTextField19.setEnabled(true);jTextField20.setEnabled(true);jTextField21.setEnabled(true);jTextField22.setEnabled(false);
            } else if (jComboBox1.getSelectedItem() == "5") {
                jTextField1.setEnabled(false);jTextField2.setEnabled(true);jTextField3.setEnabled(true);jTextField4.setEnabled(true);jTextField5.setEnabled(true);
                jTextField7.setEnabled(true);jTextField8.setEnabled(false);jTextField9.setEnabled(true);jTextField10.setEnabled(true);jTextField11.setEnabled(true);
                jTextField13.setEnabled(true);jTextField14.setEnabled(true);jTextField15.setEnabled(false);jTextField16.setEnabled(true);jTextField17.setEnabled(true);
                jTextField19.setEnabled(true);jTextField20.setEnabled(true);jTextField21.setEnabled(true);jTextField22.setEnabled(false);jTextField23.setEnabled(true);
                jTextField25.setEnabled(true);jTextField26.setEnabled(true);jTextField27.setEnabled(true);jTextField28.setEnabled(true);jTextField29.setEnabled(false);
            } else if (jComboBox1.getSelectedItem() == "6") {
                jTextField1.setEnabled(false);jTextField2.setEnabled(true);jTextField3.setEnabled(true);jTextField4.setEnabled(true);jTextField5.setEnabled(true);jTextField6.setEnabled(true);
                jTextField7.setEnabled(true);jTextField8.setEnabled(false);jTextField9.setEnabled(true);jTextField10.setEnabled(true);jTextField11.setEnabled(true);jTextField12.setEnabled(true);
                jTextField13.setEnabled(true);jTextField14.setEnabled(true);jTextField15.setEnabled(false);jTextField16.setEnabled(true);jTextField17.setEnabled(true);jTextField18.setEnabled(true);
                jTextField19.setEnabled(true);jTextField20.setEnabled(true);jTextField21.setEnabled(true);jTextField22.setEnabled(false);jTextField23.setEnabled(true);jTextField24.setEnabled(true);
                jTextField25.setEnabled(true);jTextField26.setEnabled(true);jTextField27.setEnabled(true);jTextField28.setEnabled(true);jTextField29.setEnabled(false);jTextField30.setEnabled(true);
                jTextField31.setEnabled(true);jTextField32.setEnabled(true);jTextField33.setEnabled(true);jTextField34.setEnabled(true);jTextField35.setEnabled(true);jTextField36.setEnabled(false);
            }
        }else if (evt.getSource() == jButton9){
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton10.setVisible(true);
            int [][] b = new int[n][n];
            if (jComboBox1.getSelectedItem() == "2") {
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(false);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(false);jButton6.setVisible(false);jButton7.setVisible(false);jButton8.setVisible(false);
                b[0][0] = 0;b[0][1] = Integer.parseInt(jTextField2.getText());
                b[1][0] = Integer.parseInt(jTextField7.getText());b[1][1] = 0;
            } else if (jComboBox1.getSelectedItem() == "3") {
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(false);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(false);jButton7.setVisible(false);jButton8.setVisible(false);
                b[0][0] = 0;b[0][1] = Integer.parseInt(jTextField2.getText());b[0][2] = Integer.parseInt(jTextField3.getText());
                b[1][0] = Integer.parseInt(jTextField7.getText());b[1][1] = 0;b[1][2] = Integer.parseInt(jTextField9.getText());
                b[2][0] = Integer.parseInt(jTextField13.getText());b[2][1] = Integer.parseInt(jTextField14.getText());b[2][2] = 0;
            } else if (jComboBox1.getSelectedItem() == "4") {
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(false);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(false);jButton8.setVisible(false);
                b[0][0] = 0;b[0][1] = Integer.parseInt(jTextField2.getText());b[0][2] = Integer.parseInt(jTextField3.getText());b[0][3] = Integer.parseInt(jTextField4.getText());
                b[1][0] = Integer.parseInt(jTextField7.getText());b[1][1] = 0;b[1][2] = Integer.parseInt(jTextField9.getText());b[1][3] = Integer.parseInt(jTextField10.getText());
                b[2][0] = Integer.parseInt(jTextField13.getText());b[2][1] = Integer.parseInt(jTextField14.getText());b[2][2] = 0;b[2][3] = Integer.parseInt(jTextField16.getText());
                b[3][0] = Integer.parseInt(jTextField19.getText());b[3][1] = Integer.parseInt(jTextField20.getText());b[3][2] = Integer.parseInt(jTextField21.getText());b[3][3] = 0;
            } else if (jComboBox1.getSelectedItem() == "5") {
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(true);jButton8.setEnabled(false);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(true);jButton8.setVisible(false);
                b[0][0] = 0;b[0][1] = Integer.parseInt(jTextField2.getText());b[0][2] = Integer.parseInt(jTextField3.getText());b[0][3] = Integer.parseInt(jTextField4.getText());b[0][4] = Integer.parseInt(jTextField5.getText());
                b[1][0] = Integer.parseInt(jTextField7.getText());b[1][1] = 0;b[1][2] = Integer.parseInt(jTextField9.getText());b[1][3] = Integer.parseInt(jTextField10.getText());b[1][4] = Integer.parseInt(jTextField11.getText());
                b[2][0] = Integer.parseInt(jTextField13.getText());b[2][1] = Integer.parseInt(jTextField14.getText());b[2][2] = 0;b[2][3] = Integer.parseInt(jTextField16.getText());b[2][4] = Integer.parseInt(jTextField17.getText());
                b[3][0] = Integer.parseInt(jTextField19.getText());b[3][1] = Integer.parseInt(jTextField20.getText());b[3][2] = Integer.parseInt(jTextField21.getText());b[3][3] = 0;b[3][4] = Integer.parseInt(jTextField23.getText());
                b[4][0] = Integer.parseInt(jTextField25.getText());b[4][1] = Integer.parseInt(jTextField26.getText());b[4][2] = Integer.parseInt(jTextField27.getText());b[4][3] = Integer.parseInt(jTextField28.getText());b[4][4] = 0;
            } else if (jComboBox1.getSelectedItem() == "6") {
                jButton3.setEnabled(true);jButton4.setEnabled(true);jButton5.setEnabled(true);jButton6.setEnabled(true);jButton7.setEnabled(true);jButton8.setEnabled(true);
                jButton3.setVisible(true);jButton4.setVisible(true);jButton5.setVisible(true);jButton6.setVisible(true);jButton7.setVisible(true);jButton8.setVisible(true);
                b[0][0] = 0;b[0][1] = Integer.parseInt(jTextField2.getText());b[0][2] = Integer.parseInt(jTextField3.getText());b[0][3] = Integer.parseInt(jTextField4.getText());b[0][4] = Integer.parseInt(jTextField5.getText());b[0][5] = Integer.parseInt(jTextField6.getText());
                b[1][0] = Integer.parseInt(jTextField7.getText());b[1][1] = 0;b[1][2] = Integer.parseInt(jTextField9.getText());b[1][3] = Integer.parseInt(jTextField10.getText());b[1][4] = Integer.parseInt(jTextField11.getText());b[1][5] = Integer.parseInt(jTextField12.getText());
                b[2][0] = Integer.parseInt(jTextField13.getText());b[2][1] = Integer.parseInt(jTextField14.getText());b[2][2] = 0;b[2][3] = Integer.parseInt(jTextField16.getText());b[2][4] = Integer.parseInt(jTextField17.getText());b[2][5] = Integer.parseInt(jTextField18.getText());
                b[3][0] = Integer.parseInt(jTextField19.getText());b[3][1] = Integer.parseInt(jTextField20.getText());b[3][2] = Integer.parseInt(jTextField21.getText());b[3][3] = 0;b[3][4] = Integer.parseInt(jTextField23.getText());b[3][5] = Integer.parseInt(jTextField24.getText());
                b[4][0] = Integer.parseInt(jTextField25.getText());b[4][1] = Integer.parseInt(jTextField26.getText());b[4][2] = Integer.parseInt(jTextField27.getText());b[4][3] = Integer.parseInt(jTextField28.getText());b[4][4] = 0;b[4][5] = Integer.parseInt(jTextField30.getText());
                b[5][0] = Integer.parseInt(jTextField31.getText());b[5][1] = Integer.parseInt(jTextField32.getText());b[5][2] = Integer.parseInt(jTextField33.getText());b[5][3] = Integer.parseInt(jTextField34.getText());b[5][4] = Integer.parseInt(jTextField35.getText());b[5][5] = 0;
            }
            a = b;
        }else if (evt.getSource() == jButton10){
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jTextArea1.setEnabled(true);
            jButton9.setEnabled(false);
            jButton11.setEnabled(true);
            start = 65;
            jTextArea1.setText("");
            for (int i = 0 ; i < n; i++, start++) {
                letters[i] = (char) (start);
            }
            k = ConvertLetter(n, starting_vertex, letters);
            for (int i = 0; i < n; i++) {
                System.out.print("\t" + letters[i]);
                jTextArea1.append(String.valueOf("\t" + letters[i]));
            }
            System.out.println("");
            jTextArea1.append("\n");
            for (int i = 0; i < n; i++) {
                System.out.print(letters[i]);
                jTextArea1.append(String.valueOf(letters[i]));
                for (int j = 0; j < n; j++) {
                    System.out.print("\t" + a[i][j]);
                    jTextArea1.append(String.valueOf("\t" + a[i][j]));
                }
                System.out.println("");
                jTextArea1.append("\n");
            }
        } else if (evt.getSource() == jButton11) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton10.setEnabled(false);
            jTextArea2.setEnabled(true);
            jTextArea3.setEnabled(true);
            jTextArea4.setEnabled(true);
            if (jComboBox1.getSelectedItem() == "2") {
                n = 2;
            } else if (jComboBox1.getSelectedItem() == "3") {
                n = 3;
            } else if (jComboBox1.getSelectedItem() == "4") {
                n = 4;
            } else if (jComboBox1.getSelectedItem() == "5") {
                n = 5;
            } else if (jComboBox1.getSelectedItem() == "6") {
                n = 6;
            }
            int vertex = k;
            res = GetShortestPath(a, vertex);
            if (count < (int) table_status.size()){
                System.out.println("\nSimulation:\n");
                jTextArea2.setText(" ");
                for (int j = 0; j < (int) table_status.get(count).size(); j++) {
                    int element = table_status.get(count).get(j);
                    System.out.println((element == Integer.MAX_VALUE ? "INF" : element) + " ");
                    jTextArea2.append(String.valueOf(element == Integer.MAX_VALUE ? "INF" : element) + "\n");
                }
                jTextArea3.setText(" ");
                System.out.println("\nUnvisited Vertices:\n");
                for (int j = 0; j < (int) visited_status.get(count).size(); j++) {
                    boolean element = visited_status.get(count).get(j);
                    String status = (element ? "Visited" : "Not Yet Visited");
                    System.out.println(letters[j] + ": " + status);
                    jTextArea3.append(String.valueOf(status)+"\n");
                }
                System.out.println("\n-----\n");
            }else if (count >= table_status.size()){
                jTextArea4.setText(" ");
                System.out.println("Starting Vertex: " + starting_vertex + "\n");
                jTextArea4.append("Starting Vertex: " + starting_vertex + "\n");
                for (int i = 0; i < (int) res.length; i++) {
                    System.out.println(letters[i] + ": " + (res[i] == Integer.MAX_VALUE ? "INF" : res[i]));
                    jTextArea4.append(String.valueOf((res[i] == Integer.MAX_VALUE ? "INF" : res[i])) + "\n");
                }
                System.out.println();
                jTextArea4.append("");
                jButton11.setEnabled(false);
                count = 0;
            }
            count++;
        }
    }
    public static void main(String args[]) {
        Dijkstr_GUI object = new Dijkstr_GUI();
        object.show();
        object.setSize(900, 680);
        object.setResizable(false);
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
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
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
}
