package com.form;
import com.util.DB;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;

public class LoginForm extends JFrame implements ActionListener {
    JTextField userTxt = new JTextField("Enter username");
    JPasswordField passTxt = new JPasswordField("password");
    JButton loginBtn = new JButton("Login");
    JButton cancelBtn = new JButton("Cancel");

    //constructor
    public LoginForm(){
            setTitle("LOGIN FORM");
            setBounds(300,300,300,200);
            setLayout(null);
            userTxt.setBounds(50,30,120,25);
            passTxt.setBounds(50,70,120,25);
            loginBtn.setBounds(30,120,100,30);
            cancelBtn.setBounds(150,120,100,30);

            add(userTxt);add(passTxt); add(loginBtn); add(cancelBtn);
            loginBtn.addActionListener(this);
            cancelBtn.addActionListener(this);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()){
            String sql = "Select * FROM user WHERE username =? "+ "AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,userTxt.getText());
            ps.setString(2,new String(passTxt.getPassword()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String role = rs.getString("role");
                int userId = rs.getInt("userid");
                JOptionPane.showMessageDialog(this,"Login successfull ! welcome "+ role);
                dispose();
                new Smis(role,rs.getInt("userid"));
            }else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
