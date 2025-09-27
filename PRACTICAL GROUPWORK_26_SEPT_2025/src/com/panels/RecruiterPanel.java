package com.panels;
import com.utils.DB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class RecruiterPanel extends JPanel {
    JLabel header = new JLabel("LIST OF ALL JOB RECRUITERS/ EMPLOYERS");
    JTable usersTable = new JTable();
    JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
    DefaultTableModel model = new DefaultTableModel();
    public RecruiterPanel() {
        setLayout(null);
        addComponents();
        createTable();
        setSizeToComponents();
        fetchUsers();

    }
    private void createTable() {
        String[] columnNames = {"user_id", "username", "email","password_hash", "role", "created_at"};
        model.addColumn(columnNames[0]); model.addColumn(columnNames[1]); model.addColumn(columnNames[2]);
        model.addColumn(columnNames[3]); model.addColumn(columnNames[4]); model.addColumn(columnNames[5]);
        usersTable.setModel(model);
        usersTable.setRowSelectionAllowed(true);
        usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        usersTable.setRowHeight(40);
        usersTableScrollPane.setAutoscrolls(true);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setBounds(40, 20, 600, 20);
        header.setForeground(new Color(0, 0, 255));

    }
    private void addComponents() {
        add(usersTableScrollPane);
        add(header);
    }
    private void setSizeToComponents() {

        usersTableScrollPane.setBounds(10, 10 + 210, 1250, 400);
    }
    private void fetchUsers() {
        try(
                Connection con = DB.getConnection()
        ) {
            var statement = con.createStatement();
            var result = statement.executeQuery("select * from user WHERE role = 'Recruiter'");
            while (result.next()) {
                String userid = result.getString("user_id");
                String username = result.getString("username");
                String email = result.getString("email");
                String password = result.getString("password_hash");
                String role = result.getString("role");
                String createdAt = result.getString("created_at");

                model.addRow(new Object[]{userid, username, email, password, role, createdAt});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to Load Recruiters", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
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



}












