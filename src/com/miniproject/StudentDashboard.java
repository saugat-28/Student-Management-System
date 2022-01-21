package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDashboard extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenuItem home, scores, attendance, credits, logOut;
    JMenu user;

    StudentDashboard() {
        menuBar = new JMenuBar();
        add(menuBar);

        home = new JMenuItem("Home");
        home.addActionListener(this);
        menuBar.add(home);

        scores = new JMenuItem("Scores");
        scores.addActionListener(this);
        menuBar.add(scores);

        attendance = new JMenuItem("Attendance");
        attendance.addActionListener(this);
        menuBar.add(attendance);

        user = new JMenu("User");
        menuBar.add(user);

        credits = new JMenuItem("Credits");
        credits.addActionListener(this);
        user.add(credits);

        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
        user.add(logOut);

        menuBar.setBounds(0, 0, 220, 30);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("com/miniproject/icons/jssateb.png"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(finalImage);
        imageLabel.setBounds(0, 0, 1560, 800);
        add(imageLabel);

        JLabel welcomeLabel = new JLabel("JSS Academy of Technical Education Welcomes You");
        welcomeLabel.setBounds(400, 50, 800, 50);
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 30));
        imageLabel.add(welcomeLabel);

        fetchUsn();

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Used to set JFrame to full screen
        /* setUndecorated(true); Removes Window Navigation Buttons
        setBounds(0,0,1910, 1000); Used if Extended State is not used */
        setVisible(true);
    }

    void fetchUsn() {
        String query = "SELECT USN FROM STUDENT WHERE USERID = '" + UserDetails.userId + "'";
        Conn conn = new Conn();
        try {
            ResultSet resultSet = conn.statement.executeQuery(query);
            if (resultSet.next()) {
                UserDetails.usn = resultSet.getString(1);
            }
            System.out.println(UserDetails.usn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Scores")) {
            new StudentScoreInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Attendance")) {
            new StudentAttendanceInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Credits")) {
            new Credits();
        } else if (e.getActionCommand().equals("Log Out")) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDashboard();
    }
}
