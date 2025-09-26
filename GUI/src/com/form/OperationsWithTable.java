package com.form;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationsWithTable implements ActionListener {
    JFrame frm;
    //Labels
    JLabel firstN = new JLabel("First Number");
    JLabel secondN = new JLabel("Second Number");
    JLabel result = new JLabel("Results");

    //TextFields
    JTextField firstNtxt = new JTextField();
    JTextField secondNtxt = new JTextField();
    JTextField resultTxt = new JTextField();

    //buttons
    JButton add = new JButton("+");
    JButton subs = new JButton("-");
    JButton multiply = new JButton("x");
    JButton div = new JButton("/");
    JButton mod = new JButton("%");
    JButton clear = new JButton("Reset History");

    //Add table for History
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    //constructor
    public  OperationsWithTable(){
        createFrame();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
    }

    private void addActionEvent() {
        add.addActionListener(this);
        subs.addActionListener(this);
        multiply.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);
        clear.addActionListener(this);
    }

    private void addComponentsToFrame() {
        frm.add(firstN);     frm.add(secondN);
        frm.add(result);     frm.add(firstNtxt);
        frm.add(secondNtxt); frm.add(resultTxt);
        frm.add(add);        frm.add(subs);
        frm.add(multiply);   frm.add(div);
        frm.add(mod);          frm.add(scrollPane);
        frm.add(clear);          frm.add(scrollPane);

    }

    private void setLocationAndSize() {
        firstN.setBounds(10,10,100,30);
        secondN.setBounds(10,50,100,30);
        result.setBounds(10,90,100,30);
        firstNtxt.setBounds(120,10,100,30);
        secondNtxt.setBounds(120,50,100,30);
        resultTxt.setBounds(120,90,100,30);

        int x=10, y=130, w=50, h=30;
        add.setBounds(x,y,w,h);
        add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        x+=50;
        subs.setBounds(x,y,w,h);
        subs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        x+=50;
        multiply.setBounds(x,y,w,h);
        multiply.setCursor(new Cursor(Cursor.HAND_CURSOR));
        x+=50;
        div.setBounds(x,y,w,h);
        div.setCursor(new Cursor(Cursor.HAND_CURSOR));
        x+=50;
        mod.setBounds(x,y,w,h);
        mod.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //clear History
        clear.setBounds(10,170, 200,30);
        //table
        scrollPane.setBounds(10,180,260,200);

    }

    private void createFrame() {
        frm = new JFrame("OPERATIONS");
        frm.setBounds(300,250,350,300);
        frm.getContentPane().setBackground(new Color(255,255,240));
        frm.getContentPane().setLayout(null);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        //Table
        String[] columns = {"First","Operation","Second","Result"};
        tableModel = new DefaultTableModel(columns,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int first = Integer.parseInt(firstNtxt.getText());
            int second = Integer.parseInt(secondNtxt.getText());
            int results =0;
            String operator ="";

            if(e.getSource()==add){
                results = first + second; operator ="+";
            } else if (e.getSource()==subs) {
                results = first - second; operator ="-";

            } else if (e.getSource()==multiply) {
                results = first * second; operator ="x";

            } else if (e.getSource()==div) {
                results = first / second; operator ="/";

            }else if (e.getSource()==mod) {
                results = first % second; operator ="%";

            }
            resultTxt.setText(String.valueOf(results));
            //add to table history
            tableModel.addRow(new Object[]{first,operator,second,results});

        }catch (Exception ex){
            JOptionPane.showMessageDialog(frm,"Please enter Valid Number");
        }

    }
    public static  void main(String[]args){
        OperationsWithTable opnew = new OperationsWithTable();
    }
}
