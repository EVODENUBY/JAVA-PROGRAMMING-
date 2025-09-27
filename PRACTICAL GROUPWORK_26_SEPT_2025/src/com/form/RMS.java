package com.form;
import com.panels.*;

import javax.swing.*;
import java.awt.*;

public class RMS extends JFrame {
    JTabbedPane tabs = new JTabbedPane();
    public RMS(String role, int userId) {

        setTitle("RECRUITMENT MANAGEMENT SYSTEM");
        setSize(900,600);
        setLayout(new BorderLayout(5,5));
        if (role.equalsIgnoreCase("Admin")){
            tabs.add("Users", new UsersPanel());
            tabs.add("Applicants", new CandidatePanel());
            tabs.add("Recruiters", new RecruiterPanel());
            tabs.add("Job posting", new JobPanel());

        } else if (role.equalsIgnoreCase("Candidate")) {
            tabs.add("Jobs", new JobPanel());

        } else if (role.equalsIgnoreCase("Recruiter")) {
            tabs.add("Post Job", new RecruiterJobPanel());
            tabs.add("Applicants", new RecruiterApplicantPanel());


        }
        add(tabs,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
