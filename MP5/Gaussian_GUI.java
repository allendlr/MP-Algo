import javax.swing.*;
import java.util.Vector;

public class Gaussian_GUI extends javax.swing.JFrame {
    int n = 0;
    double [][] example = new double[n][n+1];
    int count = 0;
    int m = 0;
    /**
     * Creates new form NewJFrame
     */
    public Gaussian_GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    static Vector<Vector<Double>> GetMatrix(double[][] example) {
        Vector<Vector<Double>> temp_2D = new Vector<Vector<Double>>();
        for (int i = 0; i < (int) example.length; i++) {
            Vector<Double> temp_1D = new Vector<Double>();
            for (int j = 0; j < (int) example[i].length; j++) {
                temp_1D.add(example[i][j]);
            }
            temp_2D.add(temp_1D);
        }
        return temp_2D;
    }
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField30 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextArea5 = new javax.swing.JTextArea();
        jTextField41 = new javax.swing.JTextField();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField40 = new javax.swing.JTextField();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField39 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField38 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField33 = new javax.swing.JTextField();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField32 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField31 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextArea7 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jTextArea6 = new javax.swing.JTextArea();
        jTextField42 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number Of Equations", "2", "3", "4", "5", "6" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("Solutions");
        jButton5.setToolTipText("");
        jButton5.setHideActionText(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Upper Triangular Matrix");
        jButton4.setToolTipText("");
        jButton4.setHideActionText(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Simulation");
        jButton3.setToolTipText("");
        jButton3.setHideActionText(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Matrix");
        jButton2.setToolTipText("");
        jButton2.setHideActionText(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Randomize");
        jButton1.setToolTipText("");
        jButton1.setHideActionText(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("User Input");
        jButton6.setToolTipText("");
        jButton6.setHideActionText(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);

        jButton7.setText("Confirm");

        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);

        jButton1.setEnabled(false);jButton2.setEnabled(false);jButton3.setEnabled(false);jButton4.setEnabled(false);jButton5.setEnabled(false);jButton6.setEnabled(false);
        jTextArea1.setVisible(false);jTextArea2.setVisible(false);jTextArea3.setVisible(false);jTextArea4.setVisible(false);jTextArea5.setVisible(false);jTextArea6.setVisible(false);jTextArea7.setVisible(false);
        jTextArea1.setEditable(false);jTextArea2.setEditable(false);jTextArea3.setEditable(false);jTextArea4.setEditable(false);jTextArea5.setEditable(false);jTextArea6.setEditable(false);jTextArea7.setEditable(false);
        jTextField1.setVisible(false);jTextField2.setVisible(false);jTextField3.setVisible(false);jTextField4.setVisible(false);jTextField5.setVisible(false);jTextField6.setVisible(false);jTextField7.setVisible(false);
        jTextField8.setVisible(false);jTextField9.setVisible(false);jTextField10.setVisible(false);jTextField11.setVisible(false);jTextField12.setVisible(false);jTextField13.setVisible(false);jTextField14.setVisible(false);
        jTextField15.setVisible(false);jTextField16.setVisible(false);jTextField17.setVisible(false);jTextField18.setVisible(false);jTextField19.setVisible(false);jTextField20.setVisible(false);jTextField21.setVisible(false);
        jTextField22.setVisible(false);jTextField23.setVisible(false);jTextField24.setVisible(false);jTextField25.setVisible(false);jTextField26.setVisible(false);jTextField27.setVisible(false);jTextField28.setVisible(false);
        jTextField29.setVisible(false);jTextField30.setVisible(false);jTextField31.setVisible(false);jTextField32.setVisible(false);jTextField33.setVisible(false);jTextField34.setVisible(false);jTextField35.setVisible(false);
        jTextField36.setVisible(false);jTextField37.setVisible(false);jTextField38.setVisible(false);jTextField39.setVisible(false);jTextField40.setVisible(false);jTextField41.setVisible(false);jTextField42.setVisible(false);
        jButton7.setVisible(false);

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(86, 86, 86)
                                                                                                .addComponent(jButton7))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        .addComponent(jTextArea7, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3)
                                                .addGap(7, 7, 7)
                                                .addComponent(jButton4)
                                                .addGap(7, 7, 7)
                                                .addComponent(jButton5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton7))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextArea7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JTextArea a []  = {jTextArea1, jTextArea2,jTextArea3,jTextArea4,jTextArea5,jTextArea6};
        for (int i = 0; i < 6;i++ ){
            a[i].setText("");
            jTextArea7.setText("");
            jTextArea7.setVisible(false);
        }

        if (evt.getSource() == jComboBox1){
            jButton1.setEnabled(true);
            if (jComboBox1.getSelectedItem() == "2"){
                jButton6.setEnabled(true);
            }else if (jComboBox1.getSelectedItem() == "3"){
                jButton1.setEnabled(true);
                jButton6.setEnabled(true);
            }else if (jComboBox1.getSelectedItem() == "4"){
                jButton1.setEnabled(true);
                jButton6.setEnabled(true);
            }else if (jComboBox1.getSelectedItem() == "5"){
                jButton1.setEnabled(true);
                jButton6.setEnabled(true);
            }else if (jComboBox1.getSelectedItem() == "6"){
                jButton1.setEnabled(true);
                jButton6.setEnabled(true);
            } else {
                jButton1.setEnabled(false);
            }

        }else if (evt.getSource() == jButton1) {
            jButton2.setEnabled(true);
            jButton6.setEnabled(false);
            jLabel1.setText("Equation Form");
            if (jComboBox1.getSelectedItem() == "2") {
                n = 2;

                for (int i = 0; i < 6;i++ ){
                    a[i].setText("");
                    a[i].setVisible(false);
                    jTextArea7.setText("");
                    jTextArea7.setVisible(false);
                }
            } else if (jComboBox1.getSelectedItem() == "3") {
                n = 3;
                jTextArea7.setText("");
                jTextArea7.setVisible(false);
                for (int i = 0; i < 6;i++ ){
                    a[i].setText("");
                    a[i].setVisible(false);

                }
            } else if (jComboBox1.getSelectedItem() == "4") {
                n = 4;
                for (int i = 0; i < 6;i++ ){
                    a[i].setText("");
                    a[i].setVisible(false);
                    jTextArea7.setText("");
                    jTextArea7.setVisible(false);
                }
            } else if (jComboBox1.getSelectedItem() == "5") {
                n = 5;
                for (int i = 0; i < 6;i++ ){
                    a[i].setText("");
                    a[i].setVisible(false);
                    jTextArea7.setText("");
                    jTextArea7.setVisible(false);
                }
            } else if (jComboBox1.getSelectedItem() == "6") {
                n = 6;
                for (int i = 0; i < 6;i++ ){
                    a[i].setText("");
                    a[i].setVisible(false);
                    jTextArea7.setText("");
                    jTextArea7.setVisible(false);
                }
            }

            double[][] matrix = new double[n][n + 1];

            int mn = 1;
            int mx = 100;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    matrix[i][j] = (int) Math.floor(Math.random() * (mx - mn + 1) + mn);

                }
                example = matrix;
            }
            System.out.println("\nEquation Form:");
            for (int i = 0; i < n; i++) {
                int coeff = 97;
                for (int j = 0; j < n + 1; j++) {
                    if (j == n) {
                        System.out.print(" = ");
                        a[i].append(" = ");
                        a[i].setVisible(true);
                    } else if (j > 0) {
                        System.out.print(matrix[i][j] > 0 ? " + " : " - ");
                        a[i].append(String.valueOf(matrix[i][j] > 0 ? " + " : " - "));
                    }
                    if (matrix[i][j] % 1 == 0) {
                        int val = (int) (matrix[i][j]);
                        if (j > 0 && j < n) {
                            System.out.print(val > 0 ? val : -val);
                            a[i].append(String.valueOf(val > 0 ? val : -val));
                        } else {
                            a[i].append(String.valueOf(val));
                            System.out.print(val);
                        }
                    } else {
                        double val = matrix[i][j];
                        if (j > 0 && j < n) {
                            System.out.printf("%.2f", val > 0 ? val : -val);
                            a[i].append(String.valueOf(String.format("%.2f ", val)));
                        } else {
                            System.out.printf("%.2f", val);
                            a[i].append(String.valueOf(String.format("%.2f ", val)));
                        }
                    }
                    if (j < n) {
                        System.out.print((char) (coeff));
                        a[i].append(String.valueOf((char) +coeff));
                    }
                    coeff++;
                }
                a[i].append("\n");
                System.out.println("");
            }

        } else if (evt.getSource() == jButton6){
            jButton1.setEnabled(false);
            jButton7.setVisible(true);
            if (jComboBox1.getSelectedItem() == "2"){
                jTextField1.setVisible(true);jTextField2.setVisible(true);jTextField3.setVisible(true);
                jTextField8.setVisible(true);jTextField9.setVisible(true);jTextField10.setVisible(true);
            }else if (jComboBox1.getSelectedItem() == "3"){
                jTextField1.setVisible(true);jTextField2.setVisible(true);jTextField3.setVisible(true);jTextField4.setVisible(true);
                jTextField8.setVisible(true);jTextField9.setVisible(true);jTextField10.setVisible(true);jTextField11.setVisible(true);
                jTextField15.setVisible(true);jTextField16.setVisible(true);jTextField17.setVisible(true);jTextField18.setVisible(true);
            }else if (jComboBox1.getSelectedItem() == "4"){
                jTextField1.setVisible(true);jTextField2.setVisible(true);jTextField3.setVisible(true);jTextField4.setVisible(true);jTextField5.setVisible(true);
                jTextField8.setVisible(true);jTextField9.setVisible(true);jTextField10.setVisible(true);jTextField11.setVisible(true);jTextField12.setVisible(true);
                jTextField15.setVisible(true);jTextField16.setVisible(true);jTextField17.setVisible(true);jTextField18.setVisible(true);jTextField19.setVisible(true);
                jTextField22.setVisible(true);jTextField23.setVisible(true);jTextField24.setVisible(true);jTextField25.setVisible(true);jTextField26.setVisible(true);
            }else if (jComboBox1.getSelectedItem() == "5"){
                jTextField1.setVisible(true);jTextField2.setVisible(true);jTextField3.setVisible(true);jTextField4.setVisible(true);jTextField5.setVisible(true);jTextField6.setVisible(true);
                jTextField8.setVisible(true);jTextField9.setVisible(true);jTextField10.setVisible(true);jTextField11.setVisible(true);jTextField12.setVisible(true);jTextField13.setVisible(true);
                jTextField15.setVisible(true);jTextField16.setVisible(true);jTextField17.setVisible(true);jTextField18.setVisible(true);jTextField19.setVisible(true);jTextField20.setVisible(true);
                jTextField22.setVisible(true);jTextField23.setVisible(true);jTextField24.setVisible(true);jTextField25.setVisible(true);jTextField26.setVisible(true);jTextField27.setVisible(true);
                jTextField29.setVisible(true);jTextField30.setVisible(true);jTextField31.setVisible(true);jTextField32.setVisible(true);jTextField33.setVisible(true);jTextField34.setVisible(true);
            }else if (jComboBox1.getSelectedItem() == "6"){
                jTextField1.setVisible(true);jTextField2.setVisible(true);jTextField3.setVisible(true);jTextField4.setVisible(true);jTextField5.setVisible(true);jTextField6.setVisible(true);jTextField7.setVisible(true);
                jTextField8.setVisible(true);jTextField9.setVisible(true);jTextField10.setVisible(true);jTextField11.setVisible(true);jTextField12.setVisible(true);jTextField13.setVisible(true);jTextField14.setVisible(true);
                jTextField15.setVisible(true);jTextField16.setVisible(true);jTextField17.setVisible(true);jTextField18.setVisible(true);jTextField19.setVisible(true);jTextField20.setVisible(true);jTextField21.setVisible(true);
                jTextField22.setVisible(true);jTextField23.setVisible(true);jTextField24.setVisible(true);jTextField25.setVisible(true);jTextField26.setVisible(true);jTextField27.setVisible(true);jTextField28.setVisible(true);
                jTextField29.setVisible(true);jTextField30.setVisible(true);jTextField31.setVisible(true);jTextField32.setVisible(true);jTextField33.setVisible(true);jTextField34.setVisible(true);jTextField35.setVisible(true);
                jTextField36.setVisible(true);jTextField37.setVisible(true);jTextField38.setVisible(true);jTextField39.setVisible(true);jTextField40.setVisible(true);jTextField41.setVisible(true);jTextField42.setVisible(true);
            }

        }else if (evt.getSource() == jButton7){
            jButton6.setVisible(false);
            ++m;
            jLabel1.setText("Equation Form");
            double[][] matrix = new double[n][n + 1];
            if (jComboBox1.getSelectedItem() == "2"){
                n = 2;
                matrix[0][0] = Integer.parseInt(jTextField1.getText());matrix[0][1] = Integer.parseInt(jTextField2.getText());matrix[0][2] = Integer.parseInt(jTextField3.getText());
                matrix[1][0] = Integer.parseInt(jTextField8.getText());matrix[1][1] = Integer.parseInt(jTextField9.getText());matrix[1][2] = Integer.parseInt(jTextField10.getText());;
            }else if (jComboBox1.getSelectedItem() == "3"){
                n = 3;
                matrix[0][0] = Integer.parseInt(jTextField1.getText());matrix[0][1] = Integer.parseInt(jTextField2.getText());matrix[0][2] = Integer.parseInt(jTextField3.getText());matrix[0][3] = Integer.parseInt(jTextField4.getText());
                matrix[1][0] = Integer.parseInt(jTextField8.getText());matrix[1][1] = Integer.parseInt(jTextField9.getText());matrix[1][2] = Integer.parseInt(jTextField10.getText());matrix[1][3] = Integer.parseInt(jTextField11.getText());
                matrix[2][0] = Integer.parseInt(jTextField15.getText());matrix[2][1] = Integer.parseInt(jTextField16.getText());matrix[2][2] = Integer.parseInt(jTextField17.getText());matrix[2][3] = Integer.parseInt(jTextField18.getText());
            }else if (jComboBox1.getSelectedItem() == "4"){
                n = 4;
                matrix[0][0] = Integer.parseInt(jTextField1.getText());matrix[0][1] = Integer.parseInt(jTextField2.getText());matrix[0][2] = Integer.parseInt(jTextField3.getText());matrix[0][3] = Integer.parseInt(jTextField4.getText());matrix[0][4] = Integer.parseInt(jTextField5.getText());
                matrix[1][0] = Integer.parseInt(jTextField8.getText());matrix[1][1] = Integer.parseInt(jTextField9.getText());matrix[1][2] = Integer.parseInt(jTextField10.getText());matrix[1][3] = Integer.parseInt(jTextField11.getText());matrix[1][4] = Integer.parseInt(jTextField12.getText());
                matrix[2][0] = Integer.parseInt(jTextField15.getText());matrix[2][1] = Integer.parseInt(jTextField16.getText());matrix[2][2] = Integer.parseInt(jTextField17.getText());matrix[2][3] = Integer.parseInt(jTextField18.getText());matrix[2][4] = Integer.parseInt(jTextField19.getText());
                matrix[3][0] = Integer.parseInt(jTextField22.getText());matrix[3][1] = Integer.parseInt(jTextField23.getText());matrix[3][2] = Integer.parseInt(jTextField24.getText());matrix[3][3] = Integer.parseInt(jTextField25.getText());matrix[3][4] = Integer.parseInt(jTextField26.getText());
            }else if (jComboBox1.getSelectedItem() == "5"){
                n = 5;
                matrix[0][0] = Integer.parseInt(jTextField1.getText());matrix[0][1] = Integer.parseInt(jTextField2.getText());matrix[0][2] = Integer.parseInt(jTextField3.getText());matrix[0][3] = Integer.parseInt(jTextField4.getText());matrix[0][4] = Integer.parseInt(jTextField5.getText());matrix[0][5] = Integer.parseInt(jTextField6.getText());
                matrix[1][0] = Integer.parseInt(jTextField8.getText());matrix[1][1] = Integer.parseInt(jTextField9.getText());matrix[1][2] = Integer.parseInt(jTextField10.getText());matrix[1][3] = Integer.parseInt(jTextField11.getText());matrix[1][4] = Integer.parseInt(jTextField12.getText());matrix[1][5] = Integer.parseInt(jTextField13.getText());
                matrix[2][0] = Integer.parseInt(jTextField15.getText());matrix[2][1] = Integer.parseInt(jTextField16.getText());matrix[2][2] = Integer.parseInt(jTextField17.getText());matrix[2][3] = Integer.parseInt(jTextField18.getText());matrix[2][4] = Integer.parseInt(jTextField19.getText());matrix[2][5] = Integer.parseInt(jTextField20.getText());
                matrix[3][0] = Integer.parseInt(jTextField22.getText());matrix[3][1] = Integer.parseInt(jTextField23.getText());matrix[3][2] = Integer.parseInt(jTextField24.getText());matrix[3][3] = Integer.parseInt(jTextField25.getText());matrix[3][4] = Integer.parseInt(jTextField26.getText());matrix[3][5] = Integer.parseInt(jTextField27.getText());
                matrix[4][0] = Integer.parseInt(jTextField28.getText());matrix[4][1] = Integer.parseInt(jTextField30.getText());matrix[4][2] = Integer.parseInt(jTextField31.getText());matrix[4][3] = Integer.parseInt(jTextField32.getText());matrix[4][4] = Integer.parseInt(jTextField33.getText());matrix[4][5] = Integer.parseInt(jTextField34.getText());
            }else if (jComboBox1.getSelectedItem() == "6"){
                n = 6;
                matrix[0][0] = Integer.parseInt(jTextField1.getText());matrix[0][1] = Integer.parseInt(jTextField2.getText());matrix[0][2] = Integer.parseInt(jTextField3.getText());matrix[0][3] = Integer.parseInt(jTextField4.getText());matrix[0][4] = Integer.parseInt(jTextField5.getText());matrix[0][5] = Integer.parseInt(jTextField6.getText());matrix[0][6] = Integer.parseInt(jTextField7.getText());
                matrix[1][0] = Integer.parseInt(jTextField8.getText());matrix[1][1] = Integer.parseInt(jTextField9.getText());matrix[1][2] = Integer.parseInt(jTextField10.getText());matrix[1][3] = Integer.parseInt(jTextField11.getText());matrix[1][4] = Integer.parseInt(jTextField12.getText());matrix[1][5] = Integer.parseInt(jTextField13.getText());matrix[1][6] = Integer.parseInt(jTextField14.getText());
                matrix[2][0] = Integer.parseInt(jTextField15.getText());matrix[2][1] = Integer.parseInt(jTextField16.getText());matrix[2][2] = Integer.parseInt(jTextField17.getText());matrix[2][3] = Integer.parseInt(jTextField18.getText());matrix[2][4] = Integer.parseInt(jTextField19.getText());matrix[2][5] = Integer.parseInt(jTextField20.getText());matrix[2][6] = Integer.parseInt(jTextField21.getText());
                matrix[3][0] = Integer.parseInt(jTextField22.getText());matrix[3][1] = Integer.parseInt(jTextField23.getText());matrix[3][2] = Integer.parseInt(jTextField24.getText());matrix[3][3] = Integer.parseInt(jTextField25.getText());matrix[3][4] = Integer.parseInt(jTextField26.getText());matrix[3][5] = Integer.parseInt(jTextField27.getText());matrix[3][6] = Integer.parseInt(jTextField28.getText());
                matrix[4][0] = Integer.parseInt(jTextField28.getText());matrix[4][1] = Integer.parseInt(jTextField30.getText());matrix[4][2] = Integer.parseInt(jTextField31.getText());matrix[4][3] = Integer.parseInt(jTextField32.getText());matrix[4][4] = Integer.parseInt(jTextField33.getText());matrix[4][5] = Integer.parseInt(jTextField34.getText());matrix[4][6] = Integer.parseInt(jTextField35.getText());
                matrix[5][0] = Integer.parseInt(jTextField36.getText());matrix[5][1] = Integer.parseInt(jTextField37.getText());matrix[5][2] = Integer.parseInt(jTextField38.getText());matrix[5][3] = Integer.parseInt(jTextField39.getText());matrix[5][4] = Integer.parseInt(jTextField40.getText());matrix[5][5] = Integer.parseInt(jTextField41.getText());matrix[5][6] = Integer.parseInt(jTextField42.getText());
            }
            example = matrix;

            System.out.println("\nEquation Form:");
            for (int i = 0; i < n; i++) {
                int coeff = 97;
                for (int j = 0; j < n + 1; j++) {
                    if (j == n) {
                        System.out.print(" = ");
                        a[i].append(" = ");
                        a[i].setVisible(true);
                    } else if (j > 0) {
                        System.out.print(matrix[i][j] > 0 ? " + " : " - ");
                        a[i].append(String.valueOf(matrix[i][j] > 0 ? " + " : " - "));
                    }
                    if (matrix[i][j] % 1 == 0) {
                        int val = (int) (matrix[i][j]);
                        if (j > 0 && j < n) {
                            System.out.print(val > 0 ? val : -val);
                            a[i].append(String.valueOf(val > 0 ? val : -val));
                        } else {
                            a[i].append(String.valueOf(val));
                            System.out.print(val);
                        }
                    } else {
                        double val = matrix[i][j];
                        if (j > 0 && j < n) {
                            System.out.printf("%.2f", val > 0 ? val : -val);
                            a[i].append(String.valueOf(String.format("%.2f ", val)));
                        } else {
                            System.out.printf("%.2f", val);
                            a[i].append(String.valueOf(String.format("%.2f ", val)));
                        }
                    }
                    if (j < n) {
                        System.out.print((char) (coeff));
                        a[i].append(String.valueOf((char) +coeff));
                    }
                    coeff++;
                }
                a[i].append("\n");
                System.out.println("");
                if (m == n){
                    jButton2.setEnabled(true);
                    m = 0;
                }
            }


        }else if (evt.getSource() == jButton2){
            jLabel1.setText("Matrix Form");
            jButton3.setEnabled(true);
            jButton2.setEnabled(false);
            jButton7.setEnabled(false);
            for (int i = 0; i < 6;i++ ){
                a[i].setText("");
                jTextArea7.setText("");
                jTextArea7.setVisible(false);
            }
            for (int i = 0; i < (int) example.length; i++) {
                for (int j = 0; j < (int) example[i].length; j++) {
                    if (example[i][j] % 1 == 0) {
                        System.out.print((int) (example[i][j]) + " ");
                        a[i].append(String.valueOf((int) (example[i][j]) + " "));
                    } else {
                        System.out.printf("%.2f ", example[i][j]);
                        a[i].append(String.valueOf(String.format("%.2f ", example[i][j])));
                    }
                }
                System.out.println("");
                a[i].append("\n");
            }
        }else if (evt.getSource() == jButton3) {
            jButton2.setEnabled(false);
            jTextArea7.setVisible(true);
            jLabel1.setText("Row Operation");
            for (int i = 0; i < 6; i++) {
                a[i].setText("");
                jTextArea7.setText("");
            }
            double[] solutions = new double[n];
            for (int i = n - 1; i >= 0; i--) {
                double res = 0;
                for (int j = i + 1; j < n; j++) {
                    res += (example[i][j] * solutions[j]);
                }
                solutions[i] = (example[i][n] - res) / example[i][i];
            }

            // solving part (for upper triangular matrix)
            Vector<Vector<Vector<Double>>> v = new Vector<Vector<Vector<Double>>>();
            int step = 1;
            Vector<String> operations = new Vector<String>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double quotient = example[j][i] / example[i][i];
                    operations.add(String.valueOf("R" + (j + 1) + " + " + -quotient + "R" + (i + 1)));
                    for (int k = 0; k < n + 1; k++) {
                        example[j][k] = example[j][k] - (example[i][k] * quotient);
                    }
                    // store tables in 3D vector (for simulation)
                    v.add(GetMatrix(example));
                }
            }
            System.out.println("\nSimulation");
            if (count < (int) v.size()) {
                System.out.print("\nRow Operation: ");
                System.out.println(operations.get(count));
                jTextArea7.append(String.valueOf(operations.get(count)));
                for (int j = 0; j < (int) v.get(count).size(); j++) {
                    for (int k = 0; k < (int) v.get(count).get(j).size(); k++) {
                        double element = v.get(0).get(j).get(k);
                        if (element % 1 == 0) {
                            System.out.print((int) (element) + " ");
                            a[j].append(String.valueOf((int) (element) + " "));
                        } else {
                            System.out.printf("%.2f ", element);
                            a[j].append(String.valueOf(String.format("%.2f", element) + " "));
                        }
                    }
                    System.out.println("");
                    a[j].append("");

                }
                count++;
                if (count == n){
                    jButton3.setEnabled(false);
                    jButton4.setEnabled(true);
                }
            }

        } else if (evt.getSource() == jButton4)  {
            jButton5.setEnabled(true);
            jButton4.setEnabled(false);
            jTextArea7.setVisible(false);
            jLabel1.setText("Upper Triangular Matrix");

            for (int i = 0; i < 6;i++ ){
                a[i].setText("");
                jTextArea7.setText("");
            }
            System.out.println("\nUpper Triangular Matrix");
            for (int i = 0; i < (int) example.length; i++) {
                for (int j = 0; j < (int) example[i].length; j++) {
                    if (example[i][j] % 1 == 0) {
                        System.out.print((int) (example[i][j]) + " ");
                        a[i].append(String.valueOf((int) (example[i][j]) + " "));
                    } else {
                        System.out.printf("%.2f ", example[i][j]);
                        a[i].append(String.valueOf(String.format("%.2f",(example[i][j]))+ " "));
                    }
                }
                System.out.println("");
                a[i].append(" ");
            }

        } else if (evt.getSource() == jButton5){
            jLabel1.setText("Solutions");
            jButton5.setEnabled(false);
            double[] solutions = new double[n];
            for (int i = n - 1; i >= 0; i--) {
                double res = 0;
                for (int j = i + 1; j < n; j++) {
                    res += (example[i][j] * solutions[j]);
                }
                solutions[i] = (example[i][n] - res) / example[i][i];
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
                    a[i].append(String.valueOf((char) (coeff) + " = " + solutions[i]));
                    coeff++;
                }
            } else {
                System.out.println("Infinitely Many Solutions or No Solutions");
            }
            System.out.println("");
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Gaussian_GUI object = new Gaussian_GUI();
        object.show();
        object.setSize(725, 630);
        object.setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
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
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
