package com.form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operations implements ActionListener {
    JFrame frame;
    JLabel fnumber = new JLabel("First Number");
    JLabel lnumber = new JLabel("Last Number");
    JLabel results = new JLabel("Results");
    JTextField fnText = new JTextField();
    JTextField lnText = new JTextField();
    JTextField resultText = new JTextField();
    JButton add = new JButton(" + ");
    JButton subst = new JButton(" - ");
    JButton div = new JButton("/");
    JButton multiply = new JButton(" x ");
    JButton mod = new JButton(" % ");
    
    //constructor
    public Operations(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
        
    }
    private void addActionEvent() {
        add.addActionListener(this);
        subst.addActionListener(this);
        multiply.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);

    }

    private void addComponentsToFrame() {
        frame.add(fnumber);
        frame.add(lnumber);
        frame.add(fnText);
        frame.add(resultText);
        frame.add(results);
        frame.add(subst);
        frame.add(multiply);
        frame.add(div);
        frame.add(mod);
        frame.add(add);
        frame.add(lnText);
    }

    private void setLocationAndSize() {
        //first number
        fnumber.setBounds(10,10,100,30);
        fnText.setBounds(120,10,100,30);
        //field for 2nd number
        lnumber.setBounds(10,50,100,30);
        lnText.setBounds(120,50,100,30);
        //field for results
        results.setBounds(10,90,100,30);
        resultText.setBounds(120,90,100,30);

        //buttons
        add.setBounds(10,130,50,30);
        subst.setBounds(70,130,50,30);
        multiply.setBounds(130,130,50,30);
        div.setBounds(190,130,50,30);
        mod.setBounds(250,130,50,30);

    }

    private void createWindow() {
        frame = new JFrame();
        frame.setTitle("=====Operations=====");
        frame.setBounds(10,10,300,250);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            int firstNumber = Integer.parseInt(fnText.getText());
            int secondNumber = Integer.parseInt(lnText.getText());
            int result = firstNumber + secondNumber;
            resultText.setText(String.valueOf(result));

        } else if (e.getSource()==subst) {
            int firstNumber = Integer.parseInt(fnText.getText());
            int secondNumber = Integer.parseInt(lnText.getText());
            int result = firstNumber - secondNumber;
            resultText.setText(String.valueOf(result));


        }else if (e.getSource()==multiply) {
            int firstNumber = Integer.parseInt(fnText.getText());
            int secondNumber = Integer.parseInt(lnText.getText());
            int result = firstNumber * secondNumber;
            resultText.setText(String.valueOf(result));


        }else if (e.getSource()==div) {
            int firstNumber = Integer.parseInt(fnText.getText());
            int secondNumber = Integer.parseInt(lnText.getText());
            int result = firstNumber / secondNumber;
            resultText.setText(String.valueOf(result));


        } else if (e.getSource()==mod) {
            int firstNumber = Integer.parseInt(fnText.getText());
            int secondNumber = Integer.parseInt(lnText.getText());
            int result = firstNumber % secondNumber;
            resultText.setText(String.valueOf(result));


        }else {
            System.out.println("Unknown operation");
        }

    }
}
