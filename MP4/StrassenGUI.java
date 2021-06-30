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
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;


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

    //Simulation Window Components

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

    //Simulation Window
    StrassenGUI(int[][] x, int[][] y, int n){
        
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
