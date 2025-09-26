package com.form;
import com.utils.DB;
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
        userTxt.setBounds(50,30,150,25);
        passTxt.setBounds(50,70,150,25);
        loginBtn.setBounds(30,120,100,30);
        cancelBtn.setBounds(150,120,100,30);

        add(userTxt);add(passTxt); add(loginBtn); add(cancelBtn);
        loginBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //HASHING PASSWORD METHOD

    private String hashPassword(String password) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()){
            String sql = "SELECT * FROM user WHERE username = ? AND password_hash = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userTxt.getText());
            ps.setString(2, hashPassword(new String(passTxt.getPassword())));


            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String role = rs.getString("role");
                int userId = rs.getInt("user_id");
                JOptionPane.showMessageDialog(this,"Login successfully ! welcome "+ role);
                dispose();
                new RMS(role,rs.getInt("user_id"));
            }else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
