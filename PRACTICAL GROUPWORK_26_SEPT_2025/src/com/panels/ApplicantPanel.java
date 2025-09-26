package com.panels;
import com.utils.DB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class ApplicantPanel extends JPanel {
    JLabel header = new JLabel("LIST OF ALL JOB CANDIDATES/ JOB SEEKERS");

    JTable usersTable = new JTable();
    JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
    DefaultTableModel model = new DefaultTableModel();
    public ApplicantPanel() {
        setLayout(new GridBagLayout());
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
    }
    private void addComponents() {
        add(header);
    }
    private void setSizeToComponents() {
        header.setBounds(40,40,400,40);
        header.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        usersTableScrollPane.setBounds(10, 10 + 210, 1250, 400);
    }
    private void fetchUsers() {
        try(
                Connection con = DB.getConnection()
        ) {
            var statement = con.createStatement();
            var result = statement.executeQuery("select * from user WHERE role=`Candidate`");
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
            JOptionPane.showMessageDialog(this, "Failed to Load Users", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}