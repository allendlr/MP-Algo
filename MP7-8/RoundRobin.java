import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class RoundRobin implements ActionListener{
    private JFrame frame;
    private JPanel side_panel;
    private JPanel input_panel;
    private JPanel simulation_panel;
    private JPanel ready_panel;
    private JPanel wait_panel;
    private JLabel wait_panel_label;
    private JLabel ready_panel_label;
    private JScrollPane ready_pane;
    private JScrollPane wait_pane;
    private JScrollPane screen_pane;
    private JTable screen_table;
    private DefaultTableModel screen_tmodel;
    private JScrollPane pane;
    private JButton input_button;
    private JButton simulation_button;
    private JTextField burstTime_input;
    private JTextField arrivalTime_input;
    private JTextField timeQuantum_input;
    private JLabel TimeIndicator;
    private JLabel CurrentIndicator;
    private JLabel[] ready_label = new JLabel[100];
    private JLabel[] wait_label = new JLabel[100];
    private JLabel burstTime_label;
    private JLabel arrivalTime_label;
    private JLabel timeQuantum_label;
    private JButton simulate_button;
    private JButton randomize_button;
    private JOptionPane popup;
    private Vector<Vector<Integer>> readyQState = new Vector<Vector<Integer>>();
    private Vector<Vector<Integer>> waitQState = new Vector<Vector<Integer>>();
    private Vector<Vector<Integer>> remQState = new Vector<Vector<Integer>>();
    private JButton next;
    private JButton prev;
    private JButton reset;
    private JTable cpu_table;
    private DefaultTableModel cpu_tmodel;
    private JScrollPane cpu_pane;
    private int elements = 0;
    private int cursor = -1;
    private int global_time = 0;
    //global variables
    RoundRobin(){
        frame = new JFrame("CPU Scheduling Simulation");
        //input_button
        input_button = new JButton("INPUT");
        input_button.setBounds(175, 20, 200, 50);
        input_button.setEnabled(false);
        input_button.setFocusable(false);
        input_button.setForeground(Color.white);
        input_button.setBackground(new Color(54, 54, 54));
        input_button.addActionListener(this);
        input_button.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //simulation_button
        simulation_button = new JButton("SIMULATION");
        simulation_button.setBounds(425, 20, 200, 50);
        simulation_button.setFocusable(false);
        simulation_button.setForeground(Color.white);
        simulation_button.setBackground(new Color(54, 54, 54));
        simulation_button.addActionListener(this);
        simulation_button.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //arrivalTime_label
        arrivalTime_label = new JLabel("ARRIVAL TIME :");
        arrivalTime_label.setForeground(Color.white);
        arrivalTime_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        arrivalTime_label.setBounds(40, 125, 200, 50);
        //arrivalTime_input
        arrivalTime_input = new JTextField();
        arrivalTime_input.setFont(new Font("ARIAL", Font.PLAIN, 20));
        arrivalTime_input.setBounds(250, 130, 400, 40);
        //burstTime_label
        burstTime_label = new JLabel("BURST TIME :");
        burstTime_label.setForeground(Color.white);
        burstTime_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        burstTime_label.setBounds(40, 200, 200, 50);
        //burstTime_input
        burstTime_input = new JTextField();
        burstTime_input.setFont(new Font("ARIAL", Font.PLAIN, 20));
        burstTime_input.setBounds(250, 205, 400, 40);
        //timeQuantum_label
        timeQuantum_label = new JLabel("TIME QUANTUM :");
        timeQuantum_label.setForeground(Color.white);
        timeQuantum_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        timeQuantum_label.setBounds(40, 270, 200, 50);
        //timeQuantum_input
        timeQuantum_input = new JTextField();
        timeQuantum_input.setFont(new Font("ARIAL", Font.PLAIN, 20));
        timeQuantum_input.setBounds(250, 275, 400, 40);
        //side_panel
        side_panel = new JPanel();
        side_panel.setLayout(null);
        side_panel.setBounds(0, 0, 800, 100);
        side_panel.setBackground(new Color(40,40,40));
        side_panel.add(input_button);
        side_panel.add(simulation_button);
        //simulate_button
        simulate_button = new JButton("SIMULATE");
        simulate_button.setBounds(250, 350, 180, 50);
        simulate_button.setFocusable(false);
        simulate_button.setForeground(Color.white);
        simulate_button.setBackground(new Color(54, 54, 54));
        simulate_button.addActionListener(this);
        simulate_button.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //randomize_button
        randomize_button = new JButton("RANDOMIZE");
        randomize_button.setBounds(470, 350, 180, 50);
        randomize_button.setFocusable(false);
        randomize_button.setForeground(Color.white);
        randomize_button.setBackground(new Color(54, 54, 54));
        randomize_button.addActionListener(this);
        randomize_button.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //input_panel
        input_panel = new JPanel();
        input_panel.setBounds(0, 100, 800, 700);
        input_panel.setLayout(null);
        input_panel.setBackground(new Color(54,54,54));
        input_panel.setVisible(true);
        input_panel.add(arrivalTime_label);
        input_panel.add(arrivalTime_input);
        input_panel.add(burstTime_label);
        input_panel.add(burstTime_input);
        input_panel.add(timeQuantum_label);
        input_panel.add(timeQuantum_input);
        input_panel.add(simulate_button);
        input_panel.add(randomize_button);
        //next button
        next = new JButton("NEXT");
        next.setBounds(583, 20, 200, 50);
        next.setFocusable(false);
        next.setForeground(Color.white);
        next.setBackground(new Color(54, 54, 54));
        next.addActionListener(this);
        next.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //prev button
        prev = new JButton("PREVIOUS");
        prev.setBounds(0, 20, 200, 50);
        prev.setFocusable(false);
        prev.setForeground(Color.white);
        prev.setBackground(new Color(54, 54, 54));
        prev.addActionListener(this);
        prev.setFont(new Font("ARIAL", Font.PLAIN, 20));
        //ready_panel
        ready_panel = new JPanel();
        ready_panel.setBackground(new Color(40, 40, 40));
        ready_panel.setLayout(null);
        //ready_pane
        ready_pane = new JScrollPane(ready_panel);
        ready_pane.setBounds(150, 320, 600, 70);
        ready_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //wait_panel
        wait_panel = new JPanel();
        wait_panel.setBackground(new Color(40, 40, 40));
        wait_panel.setLayout(null);
        //wait_pane
        wait_pane = new JScrollPane(wait_panel);
        wait_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        wait_pane.setBounds(150, 390, 600, 70);
        //wait_panel_label
        wait_panel_label = new JLabel("   WAIT");
        wait_panel_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        wait_panel_label.setBounds(10, 390, 100, 50);
        wait_panel_label.setForeground(Color.WHITE);
        //ready_panel_label
        ready_panel_label = new JLabel("   READY");
        ready_panel_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        ready_panel_label.setBounds(10, 320, 100, 50);
        ready_panel_label.setForeground(Color.WHITE);
        //TimeIndicator
        TimeIndicator = new JLabel("TIME : N/A");
        TimeIndicator.setFont(new Font("ARIAL", Font.PLAIN, 20));
        TimeIndicator.setBounds(300, 100, 200, 50);
        TimeIndicator.setForeground(Color.WHITE);
        //CurrentIndicator
        CurrentIndicator = new JLabel("Current Process: N/A");
        CurrentIndicator.setFont(new Font("ARIAL", Font.PLAIN, 20));
        CurrentIndicator.setBounds(300, 170, 300, 50);
        CurrentIndicator.setForeground(Color.WHITE);
        //simulation_panel
        simulation_panel = new JPanel();
        simulation_panel.setLayout(null);
        simulation_panel.setBounds(0, 100, 800, 700);
        simulation_panel.setBackground(new Color(54, 54, 54));
        simulation_panel.setVisible(false);
        simulation_panel.add(TimeIndicator);
        simulation_panel.add(CurrentIndicator);
        simulation_panel.add(ready_panel_label);
        simulation_panel.add(wait_panel_label);
        simulation_panel.add(wait_pane);
        simulation_panel.add(ready_pane);
        simulation_panel.add(next);
        simulation_panel.add(prev);
        //add frame components
        frame.add(side_panel);
        frame.add(input_panel);
        frame.add(simulation_panel);
        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void getRState(Queue<Integer> a, int remTime[], Boolean waitState[], int size){
        Vector<Integer> ready = new Vector<Integer>();
        Vector<Integer> burst = new Vector<Integer>();
        Vector<Integer> wait = new Vector<Integer>();
        for(Integer i: a){
            ready.add(i);
        }
        System.out.println(ready);
        for(int i = 0; i < size; i++){
            burst.add(remTime[i]);
            if(waitState[i] == false){
                wait.add(1);
            } else{
                wait.add(0);
            }
        }
        waitQState.add(wait);
        remQState.add(burst);
        readyQState.add(ready);
    }
    public void printSimulation(int a[], int b[], int ft[], int tt[], int wt[], int size, int time){
        
        //create table
        String[] col = {"Job","Arrival Time","Burst Time", "Finish Time", "Turnaround Time", "Waiting Time"};
        String[] screenCol = { "Job", "Remaining BT"};
        String data[] = new String[6];
        String screen_data[] = new String[2];
        //Screen Table
        screen_tmodel = new DefaultTableModel(0,0);
        screen_tmodel.setColumnIdentifiers(screenCol);
        screen_table = new JTable();
        screen_table.setBounds(0, 300, 800, 400);
        screen_table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        screen_table.setModel(screen_tmodel);
        screen_table.setEnabled(false);
        //add data to screen table
        for(int i = 0; i < size; i ++){
            screen_data[0] = "JOB " + (i + 1);
            screen_data[1] = Integer.toString(b[i]);
            screen_tmodel.addRow(screen_data);
        }
        //Final Table
        cpu_tmodel = new DefaultTableModel(0,0);
        cpu_tmodel.setColumnIdentifiers(col);
        cpu_table = new JTable();
        cpu_table.setBounds(0, 300, 800, 400);
        cpu_table.setPreferredScrollableViewportSize(new Dimension(800, 400));
        cpu_table.setModel(cpu_tmodel);
        cpu_table.setEnabled(false);
        //add data to Final Table
        for(int i = 0; i < size; i++){
            data[0] = "JOB " + (i + 1);
            data[1] = Integer.toString(a[i]);
            data[2] = Integer.toString(b[i]);
            data[3] = Integer.toString(ft[i]);
            data[4] = Integer.toString(tt[i]);
            data[5] = Integer.toString(wt[i]);

            cpu_tmodel.addRow(data);
        }
        //Scroll panes
        screen_pane = new JScrollPane(screen_table);
        screen_pane.setBounds(0, 100, 200, 200);
        pane = new JScrollPane(cpu_table);
        pane.setBounds(0, 500, 800, 200);
        simulation_panel.add(screen_pane);
        simulation_panel.add(pane);
        input_panel.setVisible(false);
        input_button.setEnabled(true);
        simulation_button.setEnabled(false);
        simulation_panel.setVisible(true);
        simulation_panel.revalidate();
        simulation_panel.repaint();

    }
    public void simulate(int a[], int b[], int q, int size){
        //check which job arrive
        //add to process queue
        //use quantum time
        //check if process ended then find another process
        //if not check again for process arrival
        //add all arrived process then add the current process again
        //tt = ft - a
        //wt = tt - b
        readyQState.clear();
        waitQState.clear();
        remQState.clear();
        elements = size;
        Queue<Integer> rQueue = new LinkedList<Integer>();
        Boolean jobs[] = new Boolean[size];
        int jobtime[] = new int[size];
        int tt[] = new int[size]; //turnaround time
        int wt[] = new int[size]; //waiting time
        int ft[] = new int[size]; //finish time
        int time = 0;
        int end = 0;
        for(int i = 0; i < size; i++){
            jobtime[i] = b[i];
            jobs[i] = false;
            tt[i] = 0;
            wt[i] = 0;
            ft[i] = 0;
        }
        Boolean ended = true;
        while(end != size){
            //check which job arrive and add process to the queue
            for(int i = 0; i < size; i++){
                if(a[i] <= time && jobs[i] == false){
                    rQueue.add(i);
                    jobs[i] = true;
                }
            }
            // check if process ended then find another process
            if (!ended) {
                int x = rQueue.poll();
                rQueue.add(x);
            }
            //use the quantum time
            if(!rQueue.isEmpty()){
                for (int i = 0; i < q; i++) {
                    int index = rQueue.peek();
                    if (jobtime[index] != 0) {
                        jobtime[index]--;
                        time++;
                    }
                    getRState(rQueue, jobtime, jobs, size);
                    if(jobtime[index] == 0) {
                        int x = rQueue.poll();
                        ft[x] = time;
                        end++;
                        ended = true;
                        break;
                    }
                    ended = false;
                }
            }else{
                getRState(rQueue, jobtime, jobs, size);
                time++;
            }
            
        }
        for(int i = 0; i < time; i++){
            //System.out.println(readyQState.get(i));
        }
        for(int i = 0; i < size; i++){
            tt[i] = ft[i] - a[i];
            wt[i] = tt[i] - b[i];
        }
        printSimulation(a, b, ft, tt, wt, size, time);
        System.out.println(readyQState);
        global_time = time;
        System.out.println("PROCESS TIME: " + (time));
    }
    @Override
    public  void actionPerformed(ActionEvent e){
        if(e.getSource() == simulate_button){
            //Value Declaration/Initialization
            Boolean check = true;
            String tempArrival[] = arrivalTime_input.getText().strip().split(" ");
            String tempBurst[] = burstTime_input.getText().strip().split(" ");
            String tempQuantum = timeQuantum_input.getText().strip();
            int bSize = tempBurst.length;
            int aSize = tempArrival.length;
            int quantum = 0;
            int burst[] = new int[bSize];
            int arrive[] = new int[aSize];
            //convert quantum input to int, otherwise set check to false 
            try{
                quantum = Integer.parseInt(tempQuantum);
            }catch (Exception error) {
                check = false; 
                System.out.println(error.getLocalizedMessage());
            }
            //check if both inputs has the same size (Burst & Arrival)
            if (bSize == aSize){
                //convert string to int
                for(int i = 0; i < bSize; i++){
                    try{
                        burst[i] = Integer.parseInt(tempBurst[i]);
                        arrive[i] = Integer.parseInt(tempArrival[i]);
                    }catch (Exception error) {
                        check = false;
                        System.out.println(error.getLocalizedMessage());
                        break;
                    }
                }
            } else {
                check = false; 
                System.out.println("INPUT DONT MATCH");
            }
            //final checks if values are valid then call simulate(), otherwise show error popup
            if (check){
                simulate(arrive, burst, quantum, aSize);
            } else{
                popup.showMessageDialog(null, "Please Check the value inputs.", "VALUE ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println(false);
            }
        } else if(e.getSource() == randomize_button){
            //Variable Declaration/Initialization
            Random random = new Random();
            int RandSize = random.nextInt(7) + 3;
            String tempQuantum = Integer.toString(random.nextInt(4) + 1);
            String tempArrival = "";
            String tempBurst = "";

            //Generate random values
            for(int i = 0; i < RandSize; i++){
                tempBurst += Integer.toString(random.nextInt(9) + 1) + " ";
                tempArrival += Integer.toString(random.nextInt(10)) + " ";
            }

            //update components
            arrivalTime_input.setText(tempArrival);
            burstTime_input.setText(tempBurst);
            timeQuantum_input.setText(tempQuantum);
            input_panel.revalidate();
            input_panel.repaint();
        }else if(e.getSource() == next){
            ready_panel.removeAll();
            wait_panel.removeAll();
            screen_tmodel.setRowCount(0);
            if(cursor < global_time - 1){
                cursor++;
                String current_process;
                try {
                    current_process = Integer.toString(readyQState.get(cursor).get(0) + 1);
                } catch (Exception error) {
                    current_process = "N/A";
                }

                TimeIndicator.setText("TIME: " + cursor);
                CurrentIndicator.setText("Current Process: JOB " + (current_process));
                String data[] = new String[2];
                for (int i = 0; i < elements; i++) {
                    data[0] = "JOB " + (i + 1);
                    data[1] = Integer.toString(remQState.get(cursor).get(i));

                    screen_tmodel.addRow(data);
                }
                // add wait states
                int x = 0;
                for (int i = 0; i < elements; i++) {
                    if (waitQState.get(cursor).get(i) == 1) {
                        wait_label[i] = new JLabel("JOB" + (1 + i));
                        wait_label[i].setBounds(x, 0, 70, 50);
                        wait_label[i].setForeground(Color.WHITE);
                        wait_label[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
                        wait_label[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        wait_panel.add(wait_label[i]);
                        x += 70;
                    }
                }
                // add ready states
                x = 0;

                int rSize = readyQState.get(cursor).size();
                System.out.println("ADD LABEL: ");
                System.out.println(readyQState.get(cursor));
                for (int i = 0; i < rSize; i++) {
                    ready_label[i] = new JLabel("JOB" + (1 + readyQState.get(cursor).get(i)));
                    ready_label[i].setBounds(x, 0, 70, 50);
                    ready_label[i].setForeground(Color.WHITE);
                    ready_label[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
                    ready_label[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    ready_panel.add(ready_label[i]);
                    x += 70;
                }

                simulation_panel.revalidate();
                simulation_panel.repaint();
            } else{
                TimeIndicator.setText("TIME: ENDED");
                CurrentIndicator.setText("Current Process: ENDED");
                simulation_panel.revalidate();
                simulation_panel.repaint();
            }
        } else if(e.getSource() == prev){
            ready_panel.removeAll();
            wait_panel.removeAll();
            screen_tmodel.setRowCount(0);
            if (cursor > 0) {
                cursor--;
                String current_process;
                try {
                    current_process = Integer.toString(readyQState.get(cursor).get(0) + 1);
                } catch (Exception error) {
                    current_process = "N/A";
                }

                TimeIndicator.setText("TIME: " + cursor);
                CurrentIndicator.setText("Current Process: JOB " + (current_process));
                String data[] = new String[2];
                for (int i = 0; i < elements; i++) {
                    data[0] = "JOB " + (i + 1);
                    data[1] = Integer.toString(remQState.get(cursor).get(i));

                    screen_tmodel.addRow(data);
                }
                // add wait states
                int x = 0;
                for (int i = 0; i < elements; i++) {
                    if (waitQState.get(cursor).get(i) == 1) {
                        wait_label[i] = new JLabel("JOB" + (1 + i));
                        wait_label[i].setBounds(x, 0, 70, 50);
                        wait_label[i].setForeground(Color.WHITE);
                        wait_label[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
                        wait_label[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        wait_panel.add(wait_label[i]);
                        x += 70;
                    }
                }
                // add ready states
                x = 0;
                
                    int rSize = readyQState.get(cursor).size();
                    System.out.println("ADD LABEL: ");
                    System.out.println(readyQState.get(cursor));
                    for (int i = 0; i < rSize; i++) {
                        ready_label[i] = new JLabel("JOB" + (1 + readyQState.get(cursor).get(i)));
                        ready_label[i].setBounds(x, 0, 70, 50);
                        ready_label[i].setForeground(Color.WHITE);
                        ready_label[i].setFont(new Font("ARIAL", Font.PLAIN, 20));
                        ready_label[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        ready_panel.add(ready_label[i]);
                        x += 70;
                    }
                
                simulation_panel.revalidate();
                simulation_panel.repaint();
            } else {
                TimeIndicator.setText("TIME: N/A");
                CurrentIndicator.setText("Current Process: N/A");
                simulation_panel.revalidate();
                simulation_panel.repaint();
            }
        }
    }

    public static void main(String[] args){
        new RoundRobin();
    }
}
