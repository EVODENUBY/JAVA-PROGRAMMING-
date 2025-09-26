package com.assignment_23_sept_2025;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculations implements ActionListener {
    JFrame frame;
    JLabel amountRequested = new JLabel("Amount Requested");
    JLabel duration = new JLabel("Duration(Year)");
    JLabel total = new JLabel("Total to return");
    JTextField amountTxt = new JTextField();
    JTextField durationTxt = new JTextField();
    JTextField totalTxt = new JTextField();
    JButton calculate = new JButton(" Calculate ");

    public Calculations(){
        createFrame();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();

    }
    private void addActionEvent() {
        calculate.addActionListener(this);
    }
    private void addComponentsToFrame() {
        frame.add(amountRequested);
        frame.add(duration);
        frame.add(total);
        frame.add(amountTxt);
        frame.add(durationTxt);
        frame.add(totalTxt);
        frame.add(calculate);
    }

    private void setLocationAndSize() {
        //create border
        Border border = BorderFactory.createLineBorder(Color.darkGray,2);
        Border margin = BorderFactory.createEmptyBorder(0,20, 0,0);
        Border compound = BorderFactory.createCompoundBorder(border, margin);

        amountRequested.setBounds(10,20,150,50);
        amountRequested.setBorder(compound);

        amountRequested.setForeground(Color.white);
        amountTxt.setBounds(180,20,150,40);
        duration.setBounds(10,80,150,50);
        duration.setBorder(compound);
        duration.setForeground(Color.white);
        durationTxt.setBounds(180,80,150,40);
        total.setBounds(10,140,150,50);
        total.setBorder(compound);
        total.setForeground(Color.white);
        totalTxt.setBounds(180,140,150,40);
        calculate.setBounds(90,200,150,40);
        calculate.setForeground(Color.white);
        calculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculate.setBackground(new Color(0,100,235));
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setTitle("    CALCULATIONS PROGRAM   ");
        frame.setBounds(350,220,400,300);
        frame.getContentPane().setBackground(new Color(0,100,235));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calculate){
            double amountRequested = Integer.parseInt(amountTxt.getText());
            int duration = Integer.parseInt(durationTxt.getText());
            double rate = 0;
            if(duration==1){
                rate =0.05;
            } else if (duration==2) {
                rate =0.075;
            } else if (duration>3) {
                rate = 0.3;
            }else {
                System.out.println("Invalid Duration");
            }
            double interest = amountRequested * rate;
            double total = amountRequested + interest;
            totalTxt.setText(String.valueOf(total));

        }else {
            System.out.println("No calculation");
        }


    }
}
