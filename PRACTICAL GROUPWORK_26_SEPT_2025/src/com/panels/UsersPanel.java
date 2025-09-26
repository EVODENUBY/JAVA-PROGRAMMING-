package com.panels;
import com.utils.DB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class UsersPanel extends JPanel {
    JLabel usernameLabel = new JLabel("Username"); JTextField username = new JTextField();
    JLabel passwordLabel = new JLabel("Password"); JPasswordField password = new JPasswordField();
    JLabel emailLabel = new JLabel("Email"); JTextField email = new JTextField();
    JLabel roleLabel = new JLabel("Role");
    String[] roles = { "Admin", "Candidate", "Recruiter" };
    JComboBox<String> roleDropdown = new JComboBox<>(roles);
    String role = (String) roleDropdown.getSelectedItem();

    JButton createUser = new JButton("Create"); JButton updateUser = new JButton("Update");
    JButton deleteUser = new JButton("Delete");


    JTable usersTable = new JTable();
    JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
    DefaultTableModel model = new DefaultTableModel();
    public UsersPanel() {
        setLayout(null);
        addComponents();
        createTable();
        setSizeToComponents();
        fetchUsers();
        createUser.addActionListener(_ -> addUser());
        deleteUser.addActionListener((_) -> removeUser());
        updateUser.addActionListener((_) -> updateUserById());

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
        add(usernameLabel); add(username); add(deleteUser);
        add(passwordLabel); add(password);  add(updateUser);
        add(emailLabel); add(email); add(createUser);
        add(usersTableScrollPane);
        add(roleLabel); add(roleDropdown);
    }
    private void setSizeToComponents() {
        usernameLabel.setBounds(10, 10, 100, 30);
        username.setBounds(10 + 110, 10, 100, 30);
        createUser.setBounds(10 + 220, 10, 100, 30);
        passwordLabel.setBounds(10, 10 + 50, 100, 30);
        password.setBounds(10 + 110, 10 + 50, 100, 30);
        updateUser.setBounds(10+ 220, 10 + 50, 100, 30 );
        emailLabel.setBounds(10, 10 + 90, 100, 30);
        email.setBounds(10 + 110, 10 + 90, 100, 30);
        deleteUser.setBounds(10 + 220, 10 + 90, 100, 30 );
        roleLabel.setBounds(10, 10 + 130, 100, 30);
        roleDropdown.setBounds(10 + 110, 10 + 130, 100, 30);
        usersTableScrollPane.setBounds(10, 10 + 210, 1250, 400);
    }
    private void fetchUsers() {
        try(
                Connection con = DB.getConnection()
        ) {
            var statement = con.createStatement();
            var result = statement.executeQuery("select * from user");
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

    private void addUser(){
        if (username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Username is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (new String(password.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email is Required", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            String emailInput = email.getText();
            String roleInput = Objects.requireNonNull(roleDropdown.getSelectedItem()).toString();
            try(var conn = DB.getConnection()){
                var statement = conn.prepareStatement( "INSERT INTO user (username, email, password_hash, role) VALUES (?, ?, ?, ?)");
                statement.setString(1, usernameInput);
                statement.setString(2, emailInput);
                statement.setString(3, hashPassword(passwordInput));
                statement.setString(4, roleInput);
                statement.executeUpdate();
                model.setRowCount(0);
                username.setText(""); password.setText("");
                email.setText(""); Objects.requireNonNull(roleDropdown.getSelectedItem()).toString();
                fetchUsers();
                JOptionPane.showConfirmDialog(this, "User Added Successfully", "Success", JOptionPane.YES_NO_CANCEL_OPTION);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    private void removeUser() {
        try (var conn = DB.getConnection()) {
            var userId = getUserById();
            if ( userId!=0) {
                var statement =  conn.prepareStatement("DELETE FROM user WHERE user_id = ?");
                statement.setInt(1, userId);
                int result = statement.executeUpdate();
                if (result < 1) {
                    JOptionPane.showMessageDialog(this, "Failed To Delete", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.setRowCount(0);
                    fetchUsers();
                    JOptionPane.showMessageDialog(this, "User Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private int getUserById() throws Exception {
        int selectedRow = usersTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please Select a Row", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        String selectedData =  model.getValueAt(selectedRow, 0).toString();
        int userId = Integer.parseInt(selectedData);
        var conn = DB.getConnection();
        var checkUser = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
        checkUser.setInt(1, userId);
        var result1 = checkUser.executeQuery();
        if (!result1.next()) {
            JOptionPane.showMessageDialog(this, "User does not exist", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return userId;
    }
    private void updateUserById() {
        try(var conn = DB.getConnection()) {
            var userId = getUserById();
            if (userId ==0) return;
            var fetchUser = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            fetchUser.setInt(1, userId);
            var result1 = fetchUser.executeQuery();
            if (result1.next()) {
                var statement = conn.prepareStatement("UPDATE user set username = ?, password_hash = ?, email = ?, role = ? where user_id = ?");
                statement.setString(1, !username.getText().isEmpty() ? username.getText() : result1.getString(1));
                statement.setString(2, (new String(password.getPassword()).isEmpty()
                        ? result1.getString("password_hash")
                        : hashPassword(new String(password.getPassword()))));
                statement.setString(3, email.getText().isEmpty() ? result1.getString(3) : email.getText());
                statement.setString(4, Objects.requireNonNull(roleDropdown.getSelectedItem()).toString().isEmpty() ? result1.getString(4) : Objects.requireNonNull(roleDropdown.getSelectedItem()).toString());
                statement.setInt(5, userId);
                int result = statement.executeUpdate();
                if (result < 1) {
                    JOptionPane.showMessageDialog(this, "Failed To Update", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.setRowCount(0);
                    fetchUsers();
                }
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}