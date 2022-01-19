package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyDashboard extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenuItem home, scores, attendance, logOut;
    JMenu user, view;

    FacultyDashboard() {

        menuBar = new JMenuBar();
        add(menuBar);

        home = new JMenuItem("Home");
        home.addActionListener(this);
        menuBar.add(home);

        view = new JMenu("View");
        menuBar.add(view);

        scores = new JMenuItem("Scores");
        scores.addActionListener(this);
        view.add(scores);

        attendance = new JMenuItem("Attendance");
        attendance.addActionListener(this);
        view.add(attendance);

        user = new JMenu("User");
        menuBar.add(user);

        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
        user.add(logOut);

        menuBar.setBounds(0, 0, 120, 30);

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

        fetchFactId();

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Used to set JFrame to full screen
        // setUndecorated(true); /*Removes Window Navigation Buttons*/
        // setBounds(0,0,1910, 1000); /*Used if Extended State is not used */
        setVisible(true);
    }

    void fetchFactId(){
        String query = "SELECT FACTID FROM FACULTY WHERE USERID = '" + UserDetails.userId + "'";
        Conn conn = new Conn();
        try {
            ResultSet resultSet = conn.statement.executeQuery(query);
            if(resultSet.next()){
                UserDetails.factId = resultSet.getString(1);
            }
            System.out.println(UserDetails.factId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Faculty")) {
            new AddFaculty().setVisible(true);
        } else if (e.getActionCommand().equals("Add Student")) {
            new AddStudents().setVisible(true);
        } else if (e.getActionCommand().equals("Scores")) {
            new ScoresInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Attendance")) {
            new AttendanceInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Log Out")) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FacultyDashboard();
    }
}
