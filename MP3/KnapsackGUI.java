import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class KnapsackGUI implements ActionListener{
    private ArrayList<String> comboStates = new ArrayList<String>();
    private ArrayList<String> bestStates = new ArrayList<String>();
    private ArrayList<Integer> V = new ArrayList<Integer>();
    private ArrayList<Integer> W = new ArrayList<Integer>();
    int C = 0;
    int current = -1;
    int totalN = 0;
    int elements = 5;
    //Input Menu Frame Components
    private JFrame frame;
    private JButton simulate;
    private JButton help;
    private JTextArea values;
    private JTextArea weights;
    private JTextArea capacity; 
    private JLabel capacity_label;
    private JLabel value_label;
    private JLabel weight_label;
    private JLabel help_message;
    private JLabel mismatch_message;
    private JLabel capacity_error;
    private JLabel empty_message;
    private JLabel singleValue_message;
    private JLabel int_message;
    private JOptionPane popup;
    //Simulation Frame Components
    private JFrame Sframe;
    private JPanel values_panel;
    private JButton next;
    private JButton prev;
    private JButton start;
    private JButton finish;
    private JLabel step_indicator;
    private JLabel capacity_indicator;
    private JLabel feasible;
    private JLabel not_feasible;
    private JLabel best_Choice;
    private JLabel total;
    private JLabel bestTotal;
    private JLabel[] best_ChoiceValues;
    private JLabel[] value_display;
    KnapsackGUI(){
        frame = new JFrame("Knapsack Simulation");
        //Values Label
        value_label = new JLabel("ENTER VALUE: ");
        value_label.setBounds(320, 5, 200,40);
        value_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //Weights Label
        weight_label = new JLabel("ENTER WEIGHT: ");
        weight_label.setBounds(320, 90, 200, 40);
        weight_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //Capacity Label
        capacity_label = new JLabel("ENTER CAPACITY: ");
        capacity_label.setBounds(310, 175, 200, 40);
        capacity_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //Weights TextArea
        weights = new JTextArea();
        weights.setBounds(200, 130, 400, 40);
        weights.setFont(new Font("ARIAL", Font.PLAIN, 28));
        //Values TextArea
        values = new JTextArea();
        values.setBounds(200,45, 400, 40);
        values.setFont(new Font("ARIAL", Font.PLAIN, 28));
        //Capacity TextArea
        capacity = new JTextArea();
        capacity.setBounds(200, 215, 400, 40);
        capacity.setFont(new Font("ARIAL", Font.PLAIN, 28));
        //Simulate Button
        simulate = new JButton("SIMULATE");
        simulate.setFocusable(false);
        simulate.setBounds(290, 290, 200,50);
        simulate.setFont(new Font("ARIAL", Font.PLAIN, 15));
        simulate.addActionListener(this);
        //Help Button
        help = new JButton("HELP");
        help.setFocusable(false);
        help.setBounds(20, 290, 100, 50);
        help.setFont(new Font("ARIAL", Font.PLAIN, 15));
        help.addActionListener(this);
        //Help Message
        help_message = new JLabel("Value and Weight take 2-5 maximum elements.  Capacity Only takes 1.", JLabel.CENTER);
        help_message.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Mismatch Message
        mismatch_message = new JLabel("The number of elements of Values and Weights are not matched.");
        mismatch_message.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Capacity Error Message
        capacity_error = new JLabel("Capacity only accept 1 element");
        capacity_error.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Empty Message
        empty_message = new JLabel("Some sections are empty.");
        empty_message.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Single Value Message
        singleValue_message = new JLabel("Values and Weight must be (1 < n >= 5) elements");
        singleValue_message.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Int Message
        int_message = new JLabel("Elements must be Integer");
        int_message.setFont(new Font("ARIAL", Font.PLAIN, 12));
        //Frame
        Image icon = Toolkit.getDefaultToolkit().getImage("bag.png");
        frame.add(capacity);
        frame.add(capacity_label);
        frame.add(weight_label);
        frame.add(value_label);
        frame.add(weights);
        frame.add(values);
        frame.add(simulate);
        frame.add(help);
        frame.setResizable(false);
        frame.setIconImage(icon);
        frame.getContentPane().setBackground(new Color(168, 222, 250));
        frame.setLayout(null);
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    KnapsackGUI(int v[], int w[], int c, int n){
        // first initialize the values to global
        for (int i = 0; i < n; i++) {
            V.add(v[i]);
            W.add(w[i]);
        }
        C = c;
        // codes for algorithm
        int[] tempList = { 0, 0, 0, 0 };
        int N = (int) Math.pow(2, n);
        totalN = N;
        elements = n;
        int bestValue = 0;
        int bestIndex = 0;
        String bestCombo = "";
        for (int i = 0; i < n; i++) {
            bestCombo.concat("0");
        }
        String combo;
        for (int i = 1; i < N; i++) {
            int tempValue = 0;
            int tempWeight = 0;
            combo = Integer.toBinaryString(N | i).substring(1);
            comboStates.add(combo);
            for (int j = 0; j < n; j++) {
                if (combo.charAt(j) == '1') {
                    tempValue += v[j];
                    tempWeight += w[j];
                }
            }
            if ((tempValue > bestValue) && (tempWeight <= c)) {
                bestValue = tempValue;
                bestIndex = i;
                bestCombo = combo;
            }
            System.out.println("COMBO: " + combo);
            System.out.println("BEST: " + bestCombo);
            bestStates.add(bestCombo);
        }

        //Components
        Sframe = new JFrame("Knapsack Simulation");
        //Value Panel
        //150 70
        values_panel = new JPanel();
        values_panel.setBounds(10, 70, 480, 250);
        values_panel.setBackground(new Color(168, 222, 250));
        values_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        //Next Button
        next = new JButton("NEXT");
        next.setFocusable(false);
        next.setBounds(110, 10, 90, 50);
        next.setFont(new Font("ARIAL", Font.BOLD, 15));
        next.addActionListener(this);
        //Previous Button
        prev = new JButton("PREV");
        prev.setFocusable(false);
        prev.setBounds(10, 10, 90, 50);
        prev.setFont(new Font("ARIAL", Font.BOLD, 15));
        prev.addActionListener(this);
        //Start Button
        start = new JButton("START");
        start.setFocusable(false);
        start.setBounds(210, 10, 90, 50);
        start.setFont(new Font("ARIAL", Font.BOLD, 15));
        start.addActionListener(this);
        //Finish Button
        finish = new JButton("END");
        finish.setFocusable(false);
        finish.setBounds(310, 10, 90, 50);
        finish.setFont(new Font("ARIAL", Font.BOLD, 15));
        finish.addActionListener(this);
        //Step Indicator
        step_indicator = new JLabel("STEP: NA", JLabel.CENTER);
        step_indicator.setBounds(530, 10, 200, 50);
        step_indicator.setFont(new Font("ARIAL", Font.PLAIN, 18));
        step_indicator.setBorder(BorderFactory.createLineBorder(Color.black));
        //Capacity Indicator
        capacity_indicator = new JLabel("CAPACITY: " + c, JLabel.CENTER);
        capacity_indicator.setBounds(530, 70, 200, 50);
        capacity_indicator.setFont(new Font("ARIAL", Font.PLAIN, 18));
        capacity_indicator.setBorder(BorderFactory.createLineBorder(Color.black));
        //Feasible Indicator
        feasible = new JLabel("FEASIBLE", JLabel.CENTER);
        feasible.setBounds(530, 130, 200, 50);
        feasible.setFont(new Font("ARIAL", Font.PLAIN, 18));
        feasible.setBorder(BorderFactory.createLineBorder(Color.black));
        feasible.setBackground(Color.green);
        feasible.setOpaque(false);
        //Not Feasible Indicator
        not_feasible = new JLabel("NOT FEASIBLE", JLabel.CENTER);
        not_feasible.setBounds(530, 190, 200, 50);
        not_feasible.setFont(new Font("ARIAL", Font.PLAIN, 18));
        not_feasible.setBorder(BorderFactory.createLineBorder(Color.black));
        not_feasible.setBackground(Color.red);
        not_feasible.setOpaque(false);
        //Best Weight Choice
        best_Choice = new JLabel("BEST CHOICE: ");
        best_Choice.setBounds(10, 320, 200, 60);
        best_Choice.setFont(new Font("ARIAL", Font.BOLD, 24));
        //Total Indicator
        total = new JLabel("", JLabel.CENTER);
        total.setBounds(170, 250, 440, 50);
        total.setFont(new Font("ARIAL", Font.PLAIN, 18));
        //Value Display
        value_display = new JLabel[n];
        int x = 30;
        for(int i = 0; i < elements; i++){
            value_display[i] = new JLabel("<html>V: " + V.get(i) + "<br>W: " + W.get(i) + "</html>", JLabel.CENTER);
            value_display[i].setBounds(x, 80, 80, 100);
            value_display[i].setBorder(BorderFactory.createLineBorder(Color.black));
            Sframe.add(value_display[i]);
            x += 90;
        }
        //Best Choice
        x = 20;
        best_ChoiceValues = new JLabel[n];
        for (int i = 0; i < elements; i++) {
            best_ChoiceValues[i] = new JLabel("<html>V: " + V.get(i) + "<br>W: " + W.get(i) + "</html>", JLabel.CENTER);
            best_ChoiceValues[i].setBounds(x, 400, 80, 100);
            best_ChoiceValues[i].setBorder(BorderFactory.createLineBorder(Color.black));
            best_ChoiceValues[i].setBackground(Color.green);
            best_ChoiceValues[i].setOpaque(false);
            Sframe.add(best_ChoiceValues[i]);
            x += 90;
        }
        //Best Total
        bestTotal = new JLabel("<html>BEST TOTAL: <br><br>" + "WEIGHT: " + 0 + "<br><br>VALUE: " + 0, JLabel.CENTER);
        bestTotal.setBounds(410, 300, 300,300);
        bestTotal.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //Sframe
        Image icon = Toolkit.getDefaultToolkit().getImage("bag.png");
        Sframe.add(bestTotal);
        Sframe.add(capacity_indicator);
        Sframe.add(total);
        Sframe.add(not_feasible);
        Sframe.add(best_Choice);
        Sframe.add(feasible);
        Sframe.add(step_indicator);
        Sframe.add(start);
        Sframe.add(finish);
        Sframe.add(next);
        Sframe.add(prev);
        Sframe.add(values_panel);
        Sframe.setResizable(false);
        Sframe.setIconImage(icon);
        Sframe.setLayout(null);
        Sframe.setSize(800, 600);
        Sframe.setVisible(true);
        Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == simulate){
            Boolean FinalChecks = true;
            int cap = 0;
            String val = values.getText().strip();
            String w = weights.getText().strip();
            String c = capacity.getText().strip();
            String tempVal[] = val.split(" ");
            String tempW[] = w.split(" ");
            String tempC[] = c.split(" ");
            int valSize = tempVal.length;
            int wSize = tempW.length;
            int cSize = tempC.length;
            int nElements = valSize;
            int FinalV[] = new int[nElements];
            int FinalW[] = new int[nElements];
            System.out.println("true");
            //Value checks happen in this section
            //capacity must be size 1 only
            //values and weights must be the same size
            //all section must not be empty
            try{
                cap = Integer.parseInt(tempC[0]);
            }catch(Exception error){
                FinalChecks = false;
                popup.showMessageDialog(null, int_message, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (valSize != wSize){
                FinalChecks = false;
                popup.showMessageDialog(null, mismatch_message, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (cSize > 1){
                FinalChecks = false;
                popup.showMessageDialog(null, capacity_error, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (c == "" || w == "" || val == ""){
                FinalChecks = false;
                popup.showMessageDialog(null, empty_message, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (valSize == 1 || wSize == 1 || valSize > 5){
                FinalChecks = false;
                popup.showMessageDialog(null, singleValue_message, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else{
                for(int i = 0; i < nElements; i++){
                    int intCheck = 0;
                    try{
                        intCheck = Integer.parseInt(tempVal[i]);
                        FinalV[i] = intCheck;
                        intCheck = Integer.parseInt(tempW[i]);
                        FinalW[i] = intCheck;
                    }catch(Exception error){
                        FinalChecks = false;
                        popup.showMessageDialog(null, int_message, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }

            if(FinalChecks){
                new KnapsackGUI(FinalV, FinalW, cap, nElements);
                frame.setVisible(false);
            }
            
        } 
        else if (e.getSource() == help){
            popup.showMessageDialog(null, help_message, "HELP", JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == next){
            if(!(current >= totalN - 2)){
                current++;
                reval();
                
            }
        } else if(e.getSource() == prev){
            if(!(current == 0)){
                current--;
                reval();
            }
        } else if(e.getSource() == start){
            current = 0;
            reval();
        } else if(e.getSource() == finish){
            current = totalN - 2;
            reval();
        }
    }
    public void reval(){
        System.out.println("true");
        int totalValue = 0;
        int totalWeight = 0;
        int bestV = 0;
        int bestW = 0;
        System.out.println(comboStates.get(current));
        step_indicator.setText("STEP: " + (current + 1));
        step_indicator.revalidate();
        for (int i = 0; i < elements; i++) {
            if (comboStates.get(current).charAt(i) == '1') {
                totalValue += V.get(i);
                totalWeight += W.get(i);
                value_display[i].setBackground(Color.green);
                value_display[i].setOpaque(true);
            } else {
                value_display[i].setBackground(Color.green);
                value_display[i].setOpaque(false);
            }
            if (totalWeight <= C) {
                not_feasible.setOpaque(false);
                feasible.setOpaque(true);
            } else {
                not_feasible.setOpaque(true);
                feasible.setOpaque(false);
            }
            total.setText("Value: " + totalValue + "    " + "Weight: " + totalWeight);
            if (bestStates.get(current).charAt(i) == '1') {
                best_ChoiceValues[i].setBackground(Color.green);
                best_ChoiceValues[i].setOpaque(true);
                bestV += V.get(i);
                bestW += W.get(i);
            } else {
                best_ChoiceValues[i].setOpaque(false);
            }
            bestTotal.setText("<html>BEST TOTAL: <br><br>" + "WEIGHT: " + bestW + "<br><br>VALUE: " + bestV);
            Sframe.revalidate();
            Sframe.repaint();
        }
    }
    public static void main(String[] args){
        new KnapsackGUI();
    }
}
