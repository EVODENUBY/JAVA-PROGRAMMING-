package com.assignment_23_sept_2025;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm implements ActionListener {
    JFrame frame;
    JLabel names = new JLabel("Names");
    JLabel userName = new JLabel("User Name");
    JLabel password = new JLabel("Password");
    JTextField namesTxt = new JTextField();
    JTextField uTxt = new JTextField();
    JTextField passTxt = new JTextField();
    JButton register = new JButton(" Register ");
    JButton reset = new JButton(" Reset ");

    public LoginForm(){
        createFrame();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();

    }
    private void addActionEvent() {
        register.addActionListener(this);
        reset.addActionListener(this);
    }
    private void addComponentsToFrame() {
        frame.add(names);
        frame.add(namesTxt);
        frame.add(userName);
        frame.add(uTxt);
        frame.add(passTxt);
        frame.add(password);
        frame.add(register);
        frame.add(reset);
    }

    private void setLocationAndSize() {
        //create border
        Border border = BorderFactory.createLineBorder(Color.darkGray,2);
        Border margin = BorderFactory.createEmptyBorder(0,20, 0,0);
        Border compound = BorderFactory.createCompoundBorder(border, margin);

        names.setBounds(10,20,150,50);
        names.setBorder(compound);

        names.setForeground(Color.white);
        namesTxt.setBounds(180,20,150,40);
        userName.setBounds(10,80,150,50);
        userName.setBorder(compound);
        userName.setForeground(Color.white);
        uTxt.setBounds(180,80,150,40);
        password.setBounds(10,140,150,50);
        password.setBorder(compound);
        password.setForeground(Color.white);
        passTxt.setBounds(180,140,150,40);
        reset.setBounds(180,200,150,40);
        reset.setForeground(Color.white);
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.setBackground(new Color(0,100,235));
        register.setBounds(10,200,150,40);
        register.setForeground(Color.white);
        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        register.setBackground(new Color(0,100,235));
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setTitle("    LOGIN FORM    ");
        frame.setBounds(350,220,400,300);
        frame.getContentPane().setBackground(new Color(0,100,235));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
