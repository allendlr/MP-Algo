import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class RoundRobin implements ActionListener{
    private JFrame frame;
    private JPanel side_panel;
    private JPanel input_panel;
    private JPanel simulation_panel;
    private JButton input_button;
    private JButton simulation_button;
    private JTextField burstTime_input;
    private JTextField arrivalTime_input;
    private JTextField timeQuantum_input;
    private JLabel burstTime_label;
    private JLabel arrivalTime_label;
    private JLabel timeQuantum_label;
    private JButton simulate_button;
    private JButton randomize_button;

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
        //simulation_panel
        simulation_panel = new JPanel();
        simulation_panel.setBounds(0, 100, 800, 700);
        simulation_panel.setBackground(new Color(54, 54, 54));
        simulation_panel.setVisible(false);
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

    @Override
    public  void actionPerformed(ActionEvent e){
        if(e.getSource() == simulate_button){

        } else if(e.getSource() == randomize_button){
            Random random = new Random();
            int RandSize = random.nextInt(7) + 3;
            String tempQuantum = Integer.toString(random.nextInt(4) + 1);
            String tempArrival = "";
            String tempBurst = "";
            for(int i = 0; i < RandSize; i++){
                tempBurst += Integer.toString(random.nextInt(9) + 1) + " ";
                tempArrival += Integer.toString(random.nextInt(10)) + " ";
            }

            arrivalTime_input.setText(tempArrival);
            burstTime_input.setText(tempBurst);
            timeQuantum_input.setText(tempQuantum);
            input_panel.revalidate();
            input_panel.repaint();
        }
    }

    public static void main(String[] args){
        new RoundRobin();
    }
}