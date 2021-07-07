import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.plaf.ColorUIResource;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
public class iSearchGUI implements ActionListener{
    //Component Declaration
    private JFrame frame;
    private JOptionPane popup;
    //simulation panel components
    private JPanel simulation_panel;
    private JPanel value_monitor;
    private JPanel index_monitor;
    private JProgressBar simulation_progress;
    //input components
    private JPanel input_panel;
    private JLabel[] values = new JLabel[20];
    private JLabel input_label;
    private JLabel keyInput_label;
    private JTextField value_input;
    private JTextField key_input;
    private JButton reset;
    private JButton simulate;
    private JButton next;
    private JButton prev;
    private JButton auto;
    private JButton generateRand;
    private JComboBox speed_input;
    //legend componends
    private JLabel hCursor;
    private JLabel lCursor;
    private JLabel pCursor;
    private JLabel foundCur;
    private JLabel key_label;
    private Vector<Vector<Integer>> simulation_state = new Vector<Vector<Integer>>();
    private JPanel cursor_panel;
    private int cursorPos = -1;
    private int cursorMax = 0;
    private int nElements = 0;
    private Boolean foundGUI = false;
    iSearchGUI(){
        frame = new JFrame("Interpolation Search Simulation");
        //input_label
        input_label = new JLabel("INPUT VALUES  :");
        input_label.setFont(new Font("ARIAL", Font.BOLD, 20));
        input_label.setForeground(Color.WHITE);
        input_label.setBounds(10, 10, 170, 50);
        //keyInput_label
        keyInput_label = new JLabel("INPUT KEY        :");
        keyInput_label.setFont(new Font("ARIAL", Font.BOLD, 20));
        keyInput_label.setForeground(Color.WHITE);
        keyInput_label.setBounds(10, 60, 170, 50);
        //value_input
        value_input = new JTextField();
        value_input.setFont(new Font("ARIAL", Font.BOLD, 20));
        value_input.setBounds(180, 22, 200, 30);
        //key_input
        key_input = new JTextField();
        key_input.setFont(new Font("ARIAL", Font.BOLD, 20));
        key_input.setBounds(180, 72, 200, 30);
        //reset button
        reset = new JButton("RESET");
        reset.setFocusable(false);
        reset.setEnabled(false);
        reset.setBounds(180, 130, 150, 40);
        reset.setBackground(Color.WHITE);
        reset.setFont(new Font("ARIAL", Font.BOLD, 15));
        reset.addActionListener(this);
        //simulate button
        simulate = new JButton("SIMULATE");
        simulate.setFocusable(false);
        simulate.setEnabled(true);
        simulate.setBounds(10, 130, 150, 40);
        simulate.setBackground(Color.WHITE);
        simulate.setFont(new Font("ARIAL", Font.BOLD, 15));
        simulate.addActionListener(this);
        //generateRand
        generateRand = new JButton("Random");
        generateRand.setFocusable(false);
        generateRand.setEnabled(true);
        generateRand.setBounds(350, 130, 150, 40);
        generateRand.setBackground(Color.WHITE);
        generateRand.setFont(new Font("ARIAL", Font.BOLD, 15));
        generateRand.addActionListener(this);
        //prev button
        prev = new JButton("<<");
        prev.setFocusable(false);
        prev.setEnabled(false);
        prev.setBounds(470, 55, 150, 40);
        prev.setBackground(Color.WHITE);
        prev.setFont(new Font("ARIAL", Font.BOLD, 15));
        prev.addActionListener(this);
        //auto button
        auto = new JButton("AUTO");
        auto.setFocusable(false);
        auto.setEnabled(false);
        auto.setBounds(630, 55, 150, 40);
        auto.setBackground(Color.WHITE);
        auto.setFont(new Font("ARIAL", Font.BOLD, 15));
        auto.addActionListener(this);
        //next button
        next = new JButton(">>");
        next.setFocusable(false);
        next.setEnabled(false);
        next.setBounds(790, 55, 150, 40);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("ARIAL", Font.BOLD, 15));
        next.addActionListener(this);
        //speed_input
        String speed_values[] = {"0.25", "0.5", "0.75","normal", "1.25", "1.5", "1.75", "2"};
        speed_input = new JComboBox<>(speed_values);
        speed_input.setFont(new Font("ARIAL", Font.BOLD, 15));
        speed_input.setBounds(630, 105, 150, 40);
        speed_input.setFocusable(false);
        speed_input.setEnabled(false);
        //foundCur
        foundCur = new JLabel("",JLabel.CENTER);
        foundCur.setBounds(50, 380, 150, 50);
        foundCur.setFont(new Font("ARIAL", Font.PLAIN, 20));
        foundCur.setOpaque(true);
        foundCur.setBorder(BorderFactory.createLineBorder(Color.black));
        //value_monitor
        value_monitor = new JPanel();
        value_monitor.setLayout(new FlowLayout(FlowLayout.CENTER));
        value_monitor.setBounds(12, 200, 985, 45);
        //cursor_panel
        cursor_panel = new JPanel();
        cursor_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        cursor_panel.setBounds(12, 255, 985, 45);
        //simulation_panel
        simulation_panel = new JPanel();
        simulation_panel.setLayout(null);
        simulation_panel.setBounds(0,0,1024,500);
        //input_panel
        input_panel = new JPanel();
        input_panel.setLayout(null);
        input_panel.setBounds(0,500,1024, 220);
        input_panel.setBackground(new Color(104, 143, 173));
        input_panel.add(generateRand);
        input_panel.add(reset);
        input_panel.add(key_input);
        input_panel.add(value_input);
        input_panel.add(input_label);
        input_panel.add(keyInput_label);
        input_panel.add(simulate);
        input_panel.add(auto);
        input_panel.add(prev);
        input_panel.add(next);
        input_panel.add(speed_input);
        //add components
        frame.add(simulation_panel);
        frame.add(input_panel);
        //frame configs
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 720);
        frame.setVisible(true);
    }
    
    
    
    
    public void simulate(int arr[], int n, int key) {
        int stateCount = 0;
        int high = n - 1;
        int low = 0;
        Boolean found = false;
        int pos = 0;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            // pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));
            pos = low + (((high - low) / (arr[high] - arr[low])) * (key - arr[low]));
            Vector<Integer> tempVec = new Vector<>();
            tempVec.add(pos);
            tempVec.add(low);
            tempVec.add(high);
            System.out.println(tempVec);
            simulation_state.add(tempVec);
            System.out.println(simulation_state);
            if (arr[pos] == key) {
                found = true;
            }
            if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
            stateCount++;
        }
        cursorMax = stateCount;
        for(int i = 0; i < stateCount; i++){
                System.out.println(simulation_state.get(i));
        }
        if (found) {
            System.out.println("FOUND @: " + pos);
            foundCur.setText("Found at: " + pos);
            foundCur.setBackground(Color.green);
        } else{
            System.out.println("NOT FOUND");
            foundCur.setText("Key not Found");
            foundCur.setBackground(Color.red);
        }

        //change simulation_panel contents
        for(int i =0; i <n; i++){
            values[i] = new JLabel("  " + Integer.toString(arr[i]) + "  ");
            values[i].setSize(45, 45);
            values[i].setFont(new Font("ARIAL", Font.BOLD, 22));
            values[i].setOpaque(false);
            values[i].setBorder(BorderFactory.createLineBorder(Color.black));
            value_monitor.add(values[i]);
        }
        //lCursor
        lCursor = new JLabel("LOW: " + 0, JLabel.CENTER);
        lCursor.setBounds(50, 440, 150, 50);
        lCursor.setFont(new Font("ARIAL", Font.PLAIN, 20));
        lCursor.setOpaque(true);
        lCursor.setBackground(new ColorUIResource(102, 178, 255));
        lCursor.setBorder(BorderFactory.createLineBorder(Color.black));
        //hCursor
        hCursor = new JLabel("HIGH: " + (n - 1), JLabel.CENTER);
        hCursor.setBounds(250, 440, 150, 50);
        hCursor.setFont(new Font("ARIAL", Font.PLAIN, 20));
        hCursor.setOpaque(true);
        hCursor.setBackground(new ColorUIResource(255, 102, 102));
        hCursor.setBorder(BorderFactory.createLineBorder(Color.black));
        //pCursor
        pCursor = new JLabel("POSITION: N/A", JLabel.CENTER);
        pCursor.setBounds(450, 440, 450, 50);
        pCursor.setFont(new Font("ARIAL", Font.PLAIN, 16));
        pCursor.setOpaque(true);
        pCursor.setBackground(new ColorUIResource(102, 255, 178));
        pCursor.setBorder(BorderFactory.createLineBorder(Color.black));
        //value colors
        values[0].setBackground(new ColorUIResource(102, 178, 255));
        values[0].setOpaque(true);
        values[n - 1].setBackground(new ColorUIResource(255, 102, 102));
        values[n - 1].setOpaque(true);
        //add components to simulation panel
        simulation_panel.add(foundCur);
        simulation_panel.add(pCursor);
        simulation_panel.add(hCursor);
        simulation_panel.add(lCursor);
        simulation_panel.add(value_monitor);
        simulation_panel.revalidate();
        simulation_panel.repaint();
    }
    public void reset_contents(){
        cursorPos = -1;
        cursorMax = 0;
        nElements = 0;
        simulate.setEnabled(true);
        value_input.setEnabled(true);
        key_input.setEnabled(true);
        reset.setEnabled(false);
        next.setEnabled(false);
        prev.setEnabled(false);
        auto.setEnabled(false);
        speed_input.setEnabled(false);
        generateRand.setEnabled(true);
        value_monitor.removeAll();
        simulation_panel.removeAll();
        simulation_panel.revalidate();
        simulation_panel.repaint();
        simulation_state.clear();
    }
    public void simulation_check(){
        String temp[] = value_input.getText().split(" ");
        int key = 0;
        int vInput[] = new int[temp.length];
        Boolean check = true;
        Boolean finalCheck = true;
        int gap = 0;
        // check if key input is integer
        try {
            key = Integer.parseInt(key_input.getText());
        } catch (Exception error) {
            check = false;
            popup.showMessageDialog(null, "Please input valid key value.", "KEY ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // check if values are integer
        for (int i = 0; i < temp.length; i++) {
            try {
                vInput[i] = Integer.parseInt(temp[i]);
            } catch (Exception error) {
                check = false;
                popup.showMessageDialog(null, "Please input valid values.", "VALUE ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        // length max is 20
        if (vInput.length > 20) {
            check = false;
            popup.showMessageDialog(null, "N Values must be 0 < N > 21 ", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (vInput.length <= 1) {
            check = false;
            popup.showMessageDialog(null, "N Values must be 0 < N > 21 ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // sort the list (bubble sort)
        int tempSort = 0;
        if (vInput.length > 1) {
            for (int i = 0; i < vInput.length; i++) {
                for (int j = 1; j < (vInput.length); j++) {
                    if (vInput[j - 1] > vInput[j]) {
                        tempSort = vInput[j - 1];
                        vInput[j - 1] = vInput[j];
                        vInput[j] = tempSort;
                    }
                }
            }
            System.out.print("Sorted List");
            for (int i = 0; i < vInput.length; i++) {
                System.out.print(vInput[i] + " ");
            }
            System.out.println();
        }
        // check the list if it is uniformly distributed.
        if (check) {
            // get the gap
            for (int i = 0; i < vInput.length - 1; i++) {
                if ((vInput[i + 1] - vInput[i]) != 0) {
                    gap = (vInput[i + 1] - vInput[i]);
                    break;
                }
            }
            System.out.println("GAP: " + gap);
            // check if uniformly distributed
            for (int i = 0; i < vInput.length - 1; i++) {
                if (((vInput[i + 1] - vInput[i]) != gap) && ((vInput[i + 1] - vInput[i]) != 0)) {
                    finalCheck = false;
                    popup.showMessageDialog(null, "Values are not uniformly distributed", "Value Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            // final check passed
            if (finalCheck) {
                nElements = vInput.length;
                simulate(vInput, vInput.length, key);
                generateRand.setEnabled(false);
                value_input.setEnabled(false);
                key_input.setEnabled(false);
                simulate.setEnabled(false);
                next.setEnabled(true);
                auto.setEnabled(true);
                speed_input.setEnabled(true);
                reset.setEnabled(true);
            }
        } 
    }
    
    public void auto_simulate(int speed) {
        cursorPos = -1;
        auto.setEnabled(false);
        prev.setEnabled(false);
        next.setEnabled(false);
        speed_input.setEnabled(false);
        reset.setEnabled(false);
        simulation_panel.revalidate();
        simulation_panel.repaint();

        SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){
            
            @Override
            protected Void doInBackground() throws Exception{
                while (true) {
                    cursorPos++;
                    for (int i = 0; i < nElements; i++) {
                        values[i].setOpaque(false);
                    }
                    if (cursorPos == cursorMax) {
                        auto.setEnabled(true);
                        prev.setEnabled(true);
                        next.setEnabled(false);
                        speed_input.setEnabled(true);
                        reset.setEnabled(true);
                        break;
                    } else {
                        int pos = simulation_state.get(cursorPos).get(0);
                        int low = simulation_state.get(cursorPos).get(1);
                        int high = simulation_state.get(cursorPos).get(2);
                        String key = key_input.getText();
                        String h = values[high].getText();
                        String l = values[low].getText();
                        // LOW
                        lCursor.setText("LOW: " + low);
                        values[low].setBackground(new ColorUIResource(102, 178, 255));
                        values[low].setOpaque(true);
                        // HIGH
                        hCursor.setText("HIGH: " + high);
                        values[high].setBackground(new ColorUIResource(255, 102, 102));
                        values[high].setOpaque(true);
                        // Position pos = low + ((high - low)/ ((arr[high] - arr[low] * (key
                        // -arr[low]))));
                        pCursor.setText("POSITION: " + low + " + ((" + high + "-" + low + ") / (" + h + "-" + l + ")) *"
                                + "(" + key + "-" + l + ") = " + pos);
                        values[pos].setBackground(new ColorUIResource(102, 255, 178));
                        values[pos].setOpaque(true);
                        frame.revalidate();
                        frame.repaint();
                    }

                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        reset_contents();
                        break;
                    }

                }
                return null;
            }
        };
        Worker.execute();

    }
    public void randomize(){
        Random rand = new Random();
        int randGap = rand.nextInt(9) + 1;
        int randSize = rand.nextInt(18) + 2;
        int randStart = rand.nextInt(10) + 1;
        int randKey = rand.nextInt(randSize) + randStart;
        String randValue = "";
        int temp = randStart;
        for(int i = 0; i < randSize; i++){
            randValue += Integer.toString(temp) + " ";
            temp += randGap;
        }

        value_input.setText(randValue);
        key_input.setText(Integer.toString(randKey));
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == simulate){
            simulation_check();
        } else if (e.getSource() == reset) {
            reset_contents();
        } else if (e.getSource() == next){
            cursorPos++;
            if(cursorPos < cursorMax){
                prev.setEnabled(true);
                int pos = simulation_state.get(cursorPos).get(0);
                int low = simulation_state.get(cursorPos).get(1);
                int high = simulation_state.get(cursorPos).get(2);
                String key = key_input.getText();
                String h = values[high].getText();
                String l = values[low].getText();
                for(int i = 0; i < nElements; i++){
                    values[i].setOpaque(false);
                }
                
                //LOW
                lCursor.setText("LOW: " + low);
                values[low].setBackground(new ColorUIResource(102, 178, 255));
                values[low].setOpaque(true);
                //HIGH
                hCursor.setText("HIGH: " + high);
                values[high].setBackground(new ColorUIResource(255, 102, 102));
                values[high].setOpaque(true);
                // Position pos = low + ((high - low)/ ((arr[high] - arr[low] * (key -arr[low]))));
                pCursor.setText("POSITION: " + low + " + ((" + high + "-" + low + ") / (" + h + "-" + l + ")) *" + "("
                        + key + "-" + l + ") = " + pos);
                values[pos].setBackground(new ColorUIResource(102, 255, 178));
                values[pos].setOpaque(true);
                simulation_panel.revalidate();
                simulation_panel.repaint();
            } else{
                next.setEnabled(false);
            }
        }else if(e.getSource() == prev){
            cursorPos--;
            next.setEnabled(true);
            if (cursorPos > -1) {
                prev.setEnabled(true);
                int pos = simulation_state.get(cursorPos).get(0);
                int low = simulation_state.get(cursorPos).get(1);
                int high = simulation_state.get(cursorPos).get(2);
                String key = key_input.getText();
                String h = values[high].getText();
                String l = values[low].getText();
                for (int i = 0; i < nElements; i++) {
                    values[i].setOpaque(false);
                }

                // LOW
                lCursor.setText("LOW: " + low);
                values[low].setBackground(new ColorUIResource(102, 178, 255));
                values[low].setOpaque(true);
                // HIGH
                hCursor.setText("HIGH: " + high);
                values[high].setBackground(new ColorUIResource(255, 102, 102));
                values[high].setOpaque(true);
                // pos = low + (((high - low) / (arr[high] - arr[low])) * (key - arr[low]));
                pCursor.setText("POSITION: " + low + " + ((" + high + "-" + low + ") / (" + h + "-" + l + ")) *" + "("+ key + "-" + l + ") = " + pos);
                values[pos].setBackground(new ColorUIResource(102, 255, 178));
                values[pos].setOpaque(true);
                simulation_panel.revalidate();
                simulation_panel.repaint();
            } else {
                prev.setEnabled(false);
            }
        } else if(e.getSource() == auto){
            String tempSpeed = speed_input.getSelectedItem().toString();
            int speed = 0;
            if (tempSpeed == "0.25"){
                speed = 1750;
            } else if(tempSpeed == "0.5"){
                speed = 1500;
            } else if(tempSpeed == "0.75"){
                speed = 1250;
            } else if(tempSpeed == "1.25"){
                speed = 750;
            } else if (tempSpeed == "1.5") {
                speed = 500;
            } else if (tempSpeed == "1.75") {
                speed = 250;
            } else if (tempSpeed == "2") {
                speed = 200;
            } else{
                speed =1000;
            }

            auto_simulate(speed);
        } else if(e.getSource() == generateRand){
            randomize();
        }
    }
    public static void main(String[] args){
        new iSearchGUI();
    }
}
