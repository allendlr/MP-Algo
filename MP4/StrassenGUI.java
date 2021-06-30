import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;


public class StrassenGUI implements ActionListener{
    //Input Window Components
    private JFrame frame;
    private JButton simulate_button;
    private JButton randomize_button;
    private JButton confirm_button;
    private JComboBox<String> table_size;
    private JTextField[] table_input;
    private JLabel tableSize_label;
    private JLabel valid_label;
    private JLabel table1_valid_label;
    private JLabel table2_valid_label;
    private JLabel tableInput_label;
    private JPanel table_panel;
    private JPanel commands_panel;
    private JOptionPane popup;
    private Boolean Table1 = false;
    private Boolean Table2 = false;
    private Vector<Integer> t1 = new Vector<Integer>();
    private Vector<Integer> t2 = new Vector<Integer>();
    private int table_gap = 0;
    // Simulation Window Components
    private JFrame Sframe;
    private JPanel table1_panel;
    private JPanel table2_panel;
    private JPanel final_panel;
    private JPanel logs_panel;
    private JButton[] submatrix_button = new JButton[8];
    private JButton[] p_button = new JButton[7];
    private JLabel submatrix_label;
    private JLabel p_label;
    private JButton reset;
    private JLabel log_label;
    private JLabel tb1_label;
    private JLabel tb2_label;
    private JLabel tb3label;
    private JLabel[][] table1_values;
    private JLabel[][] table2_values;
    private JLabel[] final_table_values;
    private JLabel p_values;

    //Input Window
    StrassenGUI(){
        frame = new JFrame("Strassen Input Window");
        table_input = new JTextField[64];
        //commands_panel
        commands_panel = new JPanel();
        commands_panel.setLayout(null);
        commands_panel.setBackground(new Color(104, 143, 173));
        commands_panel.setBounds(10 , 10, 212, 170);
        //table_panel
        table_panel = new JPanel();
        table_panel.setLayout(null);
        table_panel.setBackground(new Color(104, 143, 173));
        table_panel.setBounds(240, 60, 605, 605);
        //tableInput_label
        tableInput_label = new JLabel("TABLE: NA", JLabel.CENTER);
        tableInput_label.setFont(new Font("ARIAL", Font.BOLD, 22));
        tableInput_label.setBounds(460, 10, 150, 40);
        tableInput_label.setBackground(new Color(104, 143, 173));
        tableInput_label.setForeground(Color.WHITE);
        tableInput_label.setOpaque(true);
        //valid_label
        valid_label = new JLabel("Table 1 or Table 2 must be valid.");
        valid_label.setFont(new Font("ARIAL", Font.PLAIN, 22));
        //table1_valid_label
        table1_valid_label = new JLabel("Table 1 must be valid.");
        table1_valid_label.setFont(new Font("ARIAL", Font.PLAIN, 22));
        //table2_valid_label
        table2_valid_label = new JLabel("Table 2 must be valid.");
        table2_valid_label.setFont(new Font("ARIAL", Font.PLAIN, 22));
        //tableSize_label
        tableSize_label = new JLabel("TABLE SIZE");
        tableSize_label.setFont(new Font("ARIAL", Font.BOLD, 22));
        tableSize_label.setBounds(10, 0, 150, 40);
        tableSize_label.setForeground(Color.WHITE);
        //table_size
        String t_size[] = {"Select Size", "2x2", "4x4", "8x8"};
        table_size = new JComboBox<>(t_size);
        table_size.setBounds(5, 35, 200, 30);
        table_size.setFocusable(false);
        table_size.addActionListener(this);
        //randomize_button
        randomize_button = new JButton("RANDOMIZE");
        randomize_button.setFont(new Font("ARIAL", Font.PLAIN, 12));
        randomize_button.setBounds(5, 75, 200, 25);
        randomize_button.addActionListener(this);
        randomize_button.setEnabled(false);
        randomize_button.setFocusable(false);
        //simulate_button
        simulate_button = new JButton("SIMULATE");
        simulate_button.setFont(new Font("ARIAL", Font.PLAIN, 12));
        simulate_button.setBounds(5, 105, 200, 25);
        simulate_button.addActionListener(this);
        simulate_button.setEnabled(false);
        simulate_button.setFocusable(false);
        //confirm_button
        confirm_button = new JButton("CONFIRM TABLE");
        confirm_button.setFont(new Font("ARIAL", Font.PLAIN, 12));
        confirm_button.setBounds(5, 135, 200, 25);
        confirm_button.addActionListener(this);
        confirm_button.setEnabled(false);
        confirm_button.setFocusable(false);
        //add components to command_panel
        commands_panel.add(tableSize_label);
        commands_panel.add(table_size);
        commands_panel.add(randomize_button);
        commands_panel.add(simulate_button);
        commands_panel.add(confirm_button);
        //add components to frame
        frame.add(tableInput_label);
        frame.add(commands_panel);
        frame.add(table_panel);
        //frame configs
        frame.setSize(1024, 720);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }




    //Simulation Window 1024 x 720
    StrassenGUI(int[][] x, int[][] y, int n){
        // divide the ('n' x 'n') matrix into 4 ('n' / 2) submatrices ('x' 2D array)
        Vector<Vector<Vector<Integer>>> v1 = DivideMatrix(x, n);
        // divide the ('n' x 'n') matrix into 4 ('n' / 2) submatrices ('y' 2D array)
        Vector<Vector<Vector<Integer>>> v2 = DivideMatrix(y, n);
        int layout_size = (int) v1.get(0).get(0).size() * 2;
        table_gap = n/2;
        GridLayout layout_grid = new GridLayout(layout_size, layout_size);
        char letter = (char) (97);
        //GUI
        Sframe = new JFrame("Strassen Simulation");
        //table1_panel
        table1_panel = new JPanel();
        table1_panel.setLayout(layout_grid);
        table1_panel.setBackground(new Color(104, 143, 173));
        table1_panel.setBounds(10, 70, 320, 320);
        tb1_label = new JLabel("Table 1", JLabel.CENTER);
        tb1_label.setFont(new Font("ARIAL", Font.BOLD, 24));
        tb1_label.setForeground(Color.WHITE);
        tb1_label.setBackground(new Color(104, 143, 173));
        tb1_label.setBounds(10, 10, 200, 50);
        tb1_label.setBorder(BorderFactory.createLineBorder(Color.black));
        tb1_label.setOpaque(true);
        // table1_values
        table1_values = new JLabel[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String t1_val = Integer.toString(x[i][j]);
                table1_values[i][j] = new JLabel(t1_val, JLabel.CENTER);
                table1_values[i][j].setBounds(0, 0, 30, 30);
                table1_values[i][j].setBackground(Color.GREEN);
                table1_values[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                table1_panel.add(table1_values[i][j]);
            }
        }
        //table2_panel
        table2_panel = new JPanel();
        table2_panel.setLayout(layout_grid);
        table2_panel.setBackground(new Color(104, 143, 173));
        table2_panel.setBounds(343, 70, 320, 320);
        tb2_label = new JLabel("Table 2", JLabel.CENTER);
        tb2_label.setFont(new Font("ARIAL", Font.BOLD, 24));
        tb2_label.setForeground(Color.WHITE);
        tb2_label.setBackground(new Color(104, 143, 173));
        tb2_label.setBounds(343, 10, 200, 50);
        tb2_label.setBorder(BorderFactory.createLineBorder(Color.black));
        tb2_label.setOpaque(true);
        // table2_values
        table2_values = new JLabel[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String t1_val = Integer.toString(y[i][j]);
                table2_values[i][j] = new JLabel(t1_val, JLabel.CENTER);
                table2_values[i][j].setBounds(0, 0, 30, 30);
                table2_values[i][j].setBackground(Color.GREEN);
                table2_values[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                table2_panel.add(table2_values[i][j]);
            }
        }

        //final_panel
        final_panel = new JPanel();
        final_panel.setLayout(layout_grid);
        final_panel.setBackground(new Color(104, 143, 173));
        final_panel.setBounds(675, 70, 320, 320);
        tb3label = new JLabel("Final Table", JLabel.CENTER);
        tb3label.setFont(new Font("ARIAL", Font.BOLD, 24));
        tb3label.setForeground(Color.WHITE);
        tb3label.setBackground(new Color(104, 143, 173));
        tb3label.setBounds(675, 10, 200, 50);
        tb3label.setBorder(BorderFactory.createLineBorder(Color.black));
        tb3label.setOpaque(true);
        //submatrix_label
        submatrix_label = new JLabel("SUBMATRICES", JLabel.CENTER);
        submatrix_label.setFont(new Font("ARIAL", Font.BOLD, 24));
        submatrix_label.setForeground(Color.WHITE);
        submatrix_label.setBackground(new Color(104, 143, 173));
        submatrix_label.setBounds(10, 400, 200, 50);
        submatrix_label.setBorder(BorderFactory.createLineBorder(Color.black));
        submatrix_label.setOpaque(true);
        //logs_panel
        logs_panel = new JPanel();
        logs_panel.setLayout(layout_grid);
        logs_panel.setBackground(new Color(104, 143, 173));
        logs_panel.setBounds(675, 460, 320, 250);



        //log_label
        log_label = new JLabel("LOGS", JLabel.CENTER);
        log_label.setFont(new Font("ARIAL", Font.BOLD, 24));
        log_label.setForeground(Color.WHITE);
        log_label.setBackground(new Color(104, 143, 173));
        log_label.setBounds(675, 400, 200, 50);
        log_label.setBorder(BorderFactory.createLineBorder(Color.black));
        log_label.setOpaque(true);

        //submatrix_button (a-h)
        int xSbutton = 10;
        for(int i = 0; i < 8; i++){
            String sbutton = Character.toString(letter);
            submatrix_button[i] = new JButton(sbutton);
            submatrix_button[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
            submatrix_button[i].setBounds(xSbutton, 460, 60, 60);
            submatrix_button[i].setFocusable(false);
            submatrix_button[i].addActionListener(this);
            Sframe.add(submatrix_button[i]);
            letter = (char) (letter + 1);
            xSbutton += 70;
        }
        //p_label
        p_label = new JLabel("P1 - P7", JLabel.CENTER);
        p_label.setFont(new Font("ARIAL", Font.BOLD, 24));
        p_label.setBounds(10, 530, 200, 50);
        p_label.setForeground(Color.WHITE);
        p_label.setBackground(new Color(104, 143, 173));
        p_label.setBorder(BorderFactory.createLineBorder(Color.black));
        p_label.setOpaque(true);
        //p_button
        xSbutton = 10;
        for(int i = 0; i < 7; i++){
            p_button[i] = new JButton("P" + (i + 1));
            p_button[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
            p_button[i].addActionListener(this);
            p_button[i].setBounds(xSbutton, 590, 60, 60);
            p_button[i].setFocusable(false);
            Sframe.add(p_button[i]);
            xSbutton += 70;
        }
        //reset
        reset = new JButton("RESET");
        reset.setFont(new Font("ARIAL", Font.PLAIN, 20));
        reset.addActionListener(this);
        reset.setBounds(10, 660, 100, 60);
        reset.setFocusable(false);
        // ALGO
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
        final_table_values = new JLabel[n * n];
        int ftable_count = 0;
        for (int i = 0; i < (int) ans.size(); i++) {
            for (int j = 0; j < (int) ans.get(i).size(); j++) {
                for (int k = 0; k < (int) ans.get(i).get(j).size(); k++) {
                    String fvalue = Integer.toString(ans.get(i).get(j).get(k));
                    System.out.print(ans.get(i).get(j).get(k) + " ");
                    final_table_values[ftable_count] = new JLabel(fvalue);
                    final_table_values[ftable_count].setBounds(0, 0, 30, 30);
                    final_table_values[ftable_count].setBackground(Color.GREEN);
                    final_table_values[ftable_count].setBorder(BorderFactory.createLineBorder(Color.black));
                    final_panel.add(final_table_values[ftable_count]);
                    ftable_count++;
                }
                System.out.println("");
            }
            if (i == (int) ans.size() - 1) {
                System.out.println("");
            }
        }
        //formula
        p_values = new JLabel(" ", JLabel.CENTER);
        p_values.setFont(new Font("ARIAL", Font.BOLD, 24));
        p_values.setForeground(Color.WHITE);
        p_values.setBackground(new Color(104, 143, 173));
        p_values.setBounds(10, 400, 200, 50);
        p_values.setBorder(BorderFactory.createLineBorder(Color.black));
        p_values.setOpaque(true);
        logs_panel.add(p_values);
        //Sframe add components
        Sframe.add(table1_panel);
        Sframe.add(table2_panel);
        Sframe.add(final_panel);
        Sframe.add(logs_panel);
        Sframe.add(log_label);
        Sframe.add(reset);
        Sframe.add(submatrix_label);
        Sframe.add(p_label);
        Sframe.add(tb1_label);
        Sframe.add(tb2_label);
        Sframe.add(tb3label);
        //Sframe Configs
        Sframe.setSize(1024, 800);
        Sframe.setResizable(false);
        Sframe.setLayout(null);
        Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sframe.setVisible(true);
    }

    //Action Buttons
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == table_size){
            int x = 5, y = 5, gap = 75;
            if(table_size.getSelectedItem().toString() == "2x2"){
                table_panel.removeAll();
                randomize_button.setEnabled(true);
                confirm_button.setEnabled(true);
                for(int i = 0; i < 4; i++){
                    if (i % 2 == 0 && i != 0){
                        y += gap;
                        x = 5;
                    }

                    table_input[i] = new JTextField();
                    table_input[i].setBounds(x, y, 70, 70);
                    table_input[i].setHorizontalAlignment(JTextField.CENTER);
                    table_input[i].setFont(new Font("ARIAL", Font.PLAIN, 20));

                    x += gap;
                    table_panel.add(table_input[i]);
                }
                tableInput_label.setText("TABLE: 1");
                frame.revalidate();
                frame.repaint();
                table_panel.revalidate();
                table_panel.repaint();
                System.out.println("2x2 TABLE CREATED FOR INPUT");
            } else if (table_size.getSelectedItem().toString() == "4x4"){
                table_panel.removeAll();
                randomize_button.setEnabled(true);
                confirm_button.setEnabled(true);
                for (int i = 0; i < 16; i++) {
                    if (i % 4 == 0 && i != 0) {
                        y += gap;
                        x = 5;
                    }

                    table_input[i] = new JTextField();
                    table_input[i].setBounds(x, y, 70, 70);
                    table_input[i].setHorizontalAlignment(JTextField.CENTER);
                    table_input[i].setFont(new Font("ARIAL", Font.PLAIN, 20));

                    x += gap;
                    table_panel.add(table_input[i]);
                }
                tableInput_label.setText("TABLE: 1");
                frame.revalidate();
                frame.repaint();
                table_panel.revalidate();
                table_panel.repaint();
                System.out.println("4x4 TABLE CREATED FOR INPUT");
            } else if (table_size.getSelectedItem().toString() == "8x8"){
                table_panel.removeAll();
                randomize_button.setEnabled(true);
                confirm_button.setEnabled(true);
                for (int i = 0; i < 64; i++) {
                    if (i % 8 == 0 && i != 0) {
                        y += gap;
                        x = 5;
                    }

                    table_input[i] = new JTextField();
                    table_input[i].setBounds(x, y, 70, 70);
                    table_input[i].setHorizontalAlignment(JTextField.CENTER);
                    table_input[i].setFont(new Font("ARIAL", Font.PLAIN, 20));

                    x += gap;
                    table_panel.add(table_input[i]);
                }
                tableInput_label.setText("TABLE: 1");
                frame.revalidate();
                frame.repaint();
                table_panel.revalidate();
                table_panel.repaint();
                System.out.println("8x8 TABLE CREATED FOR INPUT");
            } else{
                tableInput_label.setText("TABLE: NA");
                table_panel.removeAll();
                randomize_button.setEnabled(false);
                confirm_button.setEnabled(false);
                frame.revalidate();
                frame.repaint();
                table_panel.revalidate();
                table_panel.repaint();
            }

        } else if(e.getSource() == randomize_button){
            Random rand = new Random();
            String random_val = "";
            int temp = 0;
            int n = 0;
            if(table_size.getSelectedItem() == "2x2"){
                n = 4;
            } else if(table_size.getSelectedItem() == "4x4"){
                n = 16;
            } else if(table_size.getSelectedItem() == "8x8"){
                n = 64;
            }
            for(int i = 0; i < n; i++){
                temp = rand.nextInt(98) + 1;
                random_val = Integer.toString(temp);
                table_input[i].setText(random_val);
            }
            table_panel.revalidate();
            table_panel.repaint();
            System.out.println("Produced Random Value.");
        } else if( e.getSource() == confirm_button){
            int n = 0;
            if (table_size.getSelectedItem() == "2x2") {
                n = 4;
            } else if (table_size.getSelectedItem() == "4x4") {
                n = 16;
            } else if (table_size.getSelectedItem() == "8x8") {
                n = 64;
            }
            if(!Table1){
                if(valid(n)){
                    Table1 = true;
                    t1.clear();
                    for(int i = 0; i < n; i++){
                        t1.add(Integer.parseInt(table_input[i].getText()));
                        table_input[i].setText("");
                    }
                    tableInput_label.setText("TABLE: 2");
                    table_size.setEnabled(false);
                } else {
                    popup.showMessageDialog(null, table1_valid_label, "Not Valid", JOptionPane.ERROR_MESSAGE);
                }
            } else if(Table1 && !Table2){
                if(valid(n)){
                    Table2 = true;
                    confirm_button.setEnabled(false);
                    randomize_button.setEnabled(false);
                    simulate_button.setEnabled(true);
                    t2.clear();
                    for(int i = 0; i < n; i++){
                        t2.add(Integer.parseInt(table_input[i].getText()));
                        table_input[i].setEditable(false);
                    }
                } else{
                    popup.showMessageDialog(null, table2_valid_label, "Not Valid", JOptionPane.ERROR_MESSAGE);
                }
            }
            frame.validate();
            frame.repaint();
            table_panel.revalidate();
            table_panel.repaint();
        } else if (e.getSource() == simulate_button){ //SIMULATE
            //t1 and t2 vector holds the table values
            //you should set frame visibility to false and create a new frame
            //with the StrassenGUI(int[]x , int[] y, int n) constructor
            //and set it visible
            //you can convert t1 and t2 to 2d array for the divideMatrix from
            //JasonMatrixAlgorithm.java
            int n = 0;
            if (table_size.getSelectedItem() == "2x2") {
                n = 2;
            } else if (table_size.getSelectedItem() == "4x4") {
                n = 4;
            } else if (table_size.getSelectedItem() == "8x8") {
                n = 8;
            }
            int[][] x = convert2d(t1, n);
            int[][] y = convert2d(t2, n);


            frame.setVisible(false);
            new StrassenGUI(x, y, n);
        } else if (e.getSource() == reset){
            clearTable();
            table1_panel.revalidate();
            table2_panel.revalidate();
            table1_panel.repaint();
            table2_panel.repaint();
            p_values.setText(" ");


        }
        String text = "";
        for(int i = 0; i < 8; i++){
            if(e.getSource() == submatrix_button[i]){
                text = submatrix_button[i].getText();
                sbuttonFunction(text);
            }
        }
        for(int i = 0; i < 7; i ++){
            if (e.getSource() == p_button[i]) {
                text = p_button[i].getText();
                sbuttonFunction(text);
            }
        }

    }
    public void sbuttonFunction(String x){
        if (x.equals("a")){
            clearTable();
            for(int i = 0; i < table_gap; i++){
                for(int j = 0; j < table_gap; j++){
                    table1_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("b")){
            clearTable();
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap*2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("c")) {
            clearTable();
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("d")) {
            clearTable();
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("e")) {
            clearTable();
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();

        } else if (x.equals("f")) {
            clearTable();
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("g")){
            clearTable();
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("h")) {
            clearTable();
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P1")){
            // a(f-h)
            clearTable();
            //a
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //f
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            //h
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P1: Formula = a(f-h)");



            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P2")) {

            // (a+b)h
            clearTable();
            // a
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //b
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //h
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P2: Formula = (a+b)h");

            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P3")) {
            // (c+d)e
            clearTable();
            //c
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //d
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //e
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P3: Formula = (c+d)e");

            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P4")) {
            // d(g-e)
            //d
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //g
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            //e
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P4: Formula = d(g-e)");

            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P5")) {
            // (a+d)(e+f)
            clearTable();
            //a
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //d
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //e
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            //f
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P5: Formula = (a+d)(e+h)");

            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P6")) {
            // (b-d)(g+f)
            clearTable();
            //b
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //d
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //g
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            //f
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            p_values.setText("P6: Formula = (b-d)(g+h)");

            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        } else if (x.equals("P7")) {
            // (a-c)(e+f)
            clearTable();
            //a
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //c
            for (int i = table_gap; i < table_gap * 2; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table1_values[i][j].setOpaque(true);
                }
            }
            //e
            for (int i = 0; i < table_gap; i++) {
                for (int j = 0; j < table_gap; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }
            //f
            for (int i = 0; i < table_gap; i++) {
                for (int j = table_gap; j < table_gap * 2; j++) {
                    table2_values[i][j].setOpaque(true);
                }
            }

            p_values.setText("P7: Formula = (a-e)(e+f)");
            table1_panel.revalidate();
            table1_panel.repaint();
            table2_panel.revalidate();
            table2_panel.repaint();
        }
    }
    public void clearTable(){
        for(int i = 0; i < table_gap*2; i++){
            for (int j = 0; j < table_gap * 2; j++) {
                table1_values[i][j].setOpaque(false);
                table2_values[i][j].setOpaque(false);
            }
        }
    }
    public Boolean valid(int n){
        int tempChecker;
        Boolean check = true;
        for(int i = 0; i < n; i++){
            tempChecker = 0;
            try{
                tempChecker = Integer.parseInt(table_input[i].getText());
            } catch(Exception e){
                check = false;
                break;
            }
        }
        return check;
    }
    public int[][] convert2d(Vector<Integer> c1, int n){
        int x = 0, y = 0;
        int temp[][] = new int[n][n];
        for(int i = 0; i < n*n; i++){
            if (i % n == 0 && i != 0){
                x++;
                y = 0;
            }
            temp[x][y] = c1.get(i);
            y++;
        }
        return temp;
    }

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
    // 2 3 2 1
    // 2 3 2 1
    // 1 2 3 4

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
    static Vector<Vector<Integer>> GetValuesForP(int id, Vector<Vector<Vector<Integer>>> v1,
                                                 Vector<Vector<Vector<Integer>>> v2) {
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
    public static void main(String[] args){
        new StrassenGUI();
    }
}