package com.panel;
import com.util.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPanel extends JPanel implements ActionListener {
        JTextField idTxt = new JTextField();
        JTextField nameTxt= new JTextField();
        JTextField phoneTxt= new JTextField();
        JTextField roleTxt= new JTextField();
        JTextField emailTxt= new JTextField();

        JPasswordField passTxt= new JPasswordField();

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");
        JButton loadBtn = new JButton("Load");
        JButton updateBtn = new JButton("Update");

        JTable table;
        DefaultTableModel model;

    //constructor
    public UserPanel() {
        setLayout(null);
        String [] labels = {"ID","USERNAME","PASSWORD","PHONE","EMAIL","ROLE"};
        String[] cols = {"userid","username","password","phone","email","role"};
        model = new DefaultTableModel(labels,0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,200,800,300);

        int y=20;
        addField("ID",idTxt,y);
        y+=30;
        addField("Username",nameTxt,y);
        y+=30;
        addField("Password",passTxt,y);
        y+=30;
        addField("Phone",phoneTxt,y);
        y+=30;
        addField("Email",emailTxt,y);
        y+=30;
        addField("Role",roleTxt,y);

        addButtons();
        add(sp);

    }

    private void addButtons() {
        addBtn.setBounds(300,20,100,30);
        updateBtn.setBounds(300,60,100,30);
        deleteBtn.setBounds(300,100,100,30);
        loadBtn.setBounds(300,140,100,30);
        add(addBtn);
        add(updateBtn);
        add(deleteBtn);
        add(loadBtn);

        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        loadBtn.addActionListener(this);
    }

    private void addField(String lbl, JComponent txt, int y) {
        JLabel l = new JLabel(lbl);
        l.setBounds(20,y,80,25);
        txt.setBounds(100,y,150,25);
        add(l);
        add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try(Connection con = DB.getConnection()){
            if (e.getSource()==addBtn){
                PreparedStatement ps = con.prepareStatement("INSERT INTO user (username,password,phone,email,role) VALUES(?,?,?,?,?)");
                ps.setString(1,nameTxt.getText());
                ps.setString(2,new String(passTxt.getPassword()));
                ps.setString(3,phoneTxt.getText());
                ps.setString(4,emailTxt.getText());
                ps.setString(5,roleTxt.getText());
                ps.executeUpdate();
            } else if (e.getSource()==updateBtn) {
                PreparedStatement ps = con.prepareStatement("UPDATE user SET username=?,phone=?,email=?,role=? WHERE userid=?");
                ps.setString(1,nameTxt.getText());
                ps.setString(2,phoneTxt.getText());
                ps.setString(3,emailTxt.getText());
                ps.setString(4,roleTxt.getText());
                ps.setInt(5, Integer.parseInt((idTxt.getText())));
                ps.executeUpdate();
            }else if (e.getSource()==deleteBtn) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM  user WHERE  userid=?");
                ps.setInt(1,Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
            } else if (e.getSource()==loadBtn) {
                model.setRowCount(0);
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user");
                while (rs.next()){
                    model.addRow(new Object[]{
                            rs.getInt("userid"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("role"),
                    });
                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
