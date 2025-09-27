package com.panels;

import com.utils.DB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;

public class RecruiterJobPanel extends JPanel {
    JLabel jobTitle = new JLabel("Job Title");
    JTextField jobTxt = new JTextField();
    JLabel status = new JLabel("Status");
    JTextField statusTxt = new JTextField();
    JLabel salary = new JLabel("Salary");
    JTextField salaryTxt = new JTextField();
    JLabel requirement = new JLabel("Requirements");
    JTextField requirementsTxt = new JTextField();
    JLabel date = new JLabel("posted_date");
    JTextField dateTxt = new JTextField();

    JButton createJob = new JButton("Create Job");
    JButton updateJob = new JButton("Update Job");
    JButton deleteJob = new JButton("Delete Job");

    JTable usersTable = new JTable();
    JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
    DefaultTableModel model = new DefaultTableModel();

    public RecruiterJobPanel() {
        setLayout(null);
        addComponents();
        createTable();
        setSizeToComponents();
        fetchUsers();

        createJob.addActionListener(_ -> addJob());
        deleteJob.addActionListener((_) -> removeJob());
        updateJob.addActionListener((_) -> updateJobById());
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
        add(jobTitle);
        add(status);
        add(statusTxt);
        add(salary);
        add(salaryTxt);
        add(jobTxt);
        add(date);
        add(requirement);
        add(requirementsTxt);
        add(dateTxt);
        add(createJob);
        add(deleteJob);
        add(updateJob);
        add(usersTableScrollPane);
    }

    private void setSizeToComponents() {
        jobTitle.setBounds(10, 10, 100, 30);
        jobTxt.setBounds(10, 50, 100, 30);
        status.setBounds(130 + 10, 10, 100, 30);
        statusTxt.setBounds(140, 50, 100, 30);
        salary.setBounds(370, 10, 100, 30);
        salaryTxt.setBounds(370, 50, 100, 30);
        date.setBounds(250 + 10, 10, 100, 30);
        dateTxt.setBounds(250, 50, 100, 30);
        requirement.setBounds(490 + 10, 10, 100, 30);
        requirementsTxt.setBounds(490, 50, 100, 30);
        createJob.setBounds(10, 100, 130, 30);
        updateJob.setBounds(120, 100, 130, 30);
        deleteJob.setBounds(220, 100, 130, 30);

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

    private void addJob() {
        String statusInput = statusTxt.getText().trim();
        if (jobTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Job Title is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (statusInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Status is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (salaryTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Salary is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (requirementsTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Requirements are Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try (Connection conn = DB.getConnection()) {
                var statement = conn.prepareStatement(
                        "INSERT INTO job (title, status, salary, posted_date, requirements) VALUES (?, ?, ?, ?, ?)");
                statement.setString(1, jobTxt.getText());
                statement.setString(2, statusInput);
                statement.setString(3, salaryTxt.getText());
                statement.setString(4, dateTxt.getText());
                statement.setString(5, requirementsTxt.getText());
                statement.executeUpdate();

                model.setRowCount(0);
                fetchUsers();
                JOptionPane.showMessageDialog(this, "Job Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removeJob() {
        try (Connection conn = DB.getConnection()) {
            int selectedRow = usersTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please Select a Job", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String jobId = model.getValueAt(selectedRow, 0).toString();
            var statement = conn.prepareStatement("DELETE FROM job WHERE job_id = ?");
            statement.setString(1, jobId);
            int result = statement.executeUpdate();
            if (result < 1) {
                JOptionPane.showMessageDialog(this, "Failed To Delete", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                model.setRowCount(0);
                fetchUsers();
                JOptionPane.showMessageDialog(this, "Job Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateJobById() {
        try (Connection conn = DB.getConnection()) {
            int selectedRow = usersTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please Select a Job", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String jobId = model.getValueAt(selectedRow, 0).toString();
            var fetchJob = conn.prepareStatement("SELECT * FROM job WHERE job_id = ?");
            fetchJob.setString(1, jobId);
            var result = fetchJob.executeQuery();
            if (result.next()) {
                var statement = conn.prepareStatement(
                        "UPDATE job SET title = ?, status = ?, salary = ?, posted_date = ?, requirements = ? WHERE job_id = ?");
                statement.setString(1, jobTxt.getText().isEmpty() ? result.getString("title") : jobTxt.getText());
                statement.setString(2, statusTxt.getText().isEmpty() ? result.getString("status") : statusTxt.getText());
                statement.setString(3, salaryTxt.getText().isEmpty() ? result.getString("salary") : salaryTxt.getText());
                statement.setString(4, dateTxt.getText().isEmpty() ? result.getString("posted_date") : dateTxt.getText());
                statement.setString(5, requirementsTxt.getText().isEmpty() ? result.getString("requirements") : requirementsTxt.getText());
                statement.setString(6, jobId);
                int updateResult = statement.executeUpdate();
                if (updateResult < 1) {
                    JOptionPane.showMessageDialog(this, "Failed To Update", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.setRowCount(0);
                    fetchUsers();
                    JOptionPane.showMessageDialog(this, "Job Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
