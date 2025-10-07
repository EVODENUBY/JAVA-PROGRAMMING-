package com.panels;

import com.utils.DB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class JobPanel extends JPanel {
    JLabel header = new JLabel("LIST OF ALL JOB POSTED");

    JTable usersTable = new JTable();
    JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
    DefaultTableModel model = new DefaultTableModel();

    public JobPanel() {
        setLayout(null);
        addComponents();
        createTable();
        setSizeToComponents();
        fetchUsers();
    }

    private void createTable() {
        String[] columnNames = {"Job Id", "Job Title", "Status", "Posted date && End date", "Salary", "Requirements"};
        model.addColumn(columnNames[0]);
        model.addColumn(columnNames[1]);
        model.addColumn(columnNames[2]);
        model.addColumn(columnNames[3]);
        model.addColumn(columnNames[4]);
        model.addColumn(columnNames[5]);

        usersTable.setModel(model);
        usersTable.setRowSelectionAllowed(true);
        usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        usersTable.setRowHeight(40);
        usersTableScrollPane.setAutoscrolls(true);
    }

    private void addComponents() {
        add(header);
        add(usersTableScrollPane);
    }

    private void setSizeToComponents() {
        header.setForeground(Color.BLUE);
        header.setBounds(300,80,500,30);
        header.setFont(new Font(new Font("TIMES NEW ROMAN", Font.BOLD, 26).getAttributes()));
        usersTableScrollPane.setBounds(10, 210, 1250, 400);
    }

    private void fetchUsers() {
        try (Connection con = DB.getConnection()) {
            var statement = con.createStatement();
            var result = statement.executeQuery("select * from job");

            if (!result.isBeforeFirst()) {
                model.setRowCount(0);
            }

            while (result.next()) {
                String jobid = result.getString("job_id");
                String titl = result.getString("title");
                String stat = result.getString("status");
                String postdate = result.getString("posted_date");
                String salary1 = result.getString("salary");
                String require = result.getString("requirements");

                model.addRow(new Object[]{jobid, titl, stat, postdate, salary1, require});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to Load Jobs", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}






