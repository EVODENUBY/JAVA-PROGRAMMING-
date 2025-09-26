package com.form;
import com.panel.*;
import javax.swing.*;
import java.awt.*;

public class Smis extends JFrame{
    JTabbedPane tabs = new JTabbedPane();
    //Constructor
    public Smis(String role, int userid){
        setTitle("SCHOOL MANAGEMENT SYSTEM");
        setSize(900,600);
        setLayout(new BorderLayout());
        if (role.equalsIgnoreCase("admin")){
            tabs.add("Users", new UserPanel());
            tabs.add("Teachers", new TeacherPanel());
            tabs.add("Courses", new CoursePanel());
            tabs.add("Students", new StudentPanel());
            tabs.add("Marks", new MarkPanel());

        } else if (role.equalsIgnoreCase("teacher")) {
            tabs.add("Courses", new CoursePanel());
            tabs.add("Marks", new MarkPanel());

        } else if (role.equalsIgnoreCase("student")) {
            tabs.add("My Marks", new MarkPanel());

        }
        add(tabs,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
