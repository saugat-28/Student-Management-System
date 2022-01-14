package com.miniproject;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    JMenuBar menuBar;
    JMenuItem home, student, faculty, addStudents, addFaculty, logOut;
    JMenu user;

    public Dashboard(){
        menuBar = new JMenuBar();
        add(menuBar);

        home = new JMenuItem("Home");
        menuBar.add(home);

        student = new JMenuItem("Student");
        menuBar.add(student);

        faculty = new JMenuItem("Faculty");
        menuBar.add(faculty);

        user = new JMenu("User");
        menuBar.add(user);

        addStudents = new JMenuItem("Add Student");
        user.add(addStudents);

        addFaculty = new JMenuItem("Add Faculty");
        user.add(addFaculty);

        logOut = new JMenuItem("Log Out");
        user.add(logOut);

        menuBar.setBounds(0,0,220, 30);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("com/miniproject/icons/jssateb.png"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(finalImage);
        imageLabel.setBounds(0,0, 1560, 800);
        add(imageLabel);

        JLabel welcomeLabel = new JLabel("JSS Academy of Technical Education Welcomes You");
        welcomeLabel.setBounds(400, 50, 800, 50);
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 30));
        imageLabel.add(welcomeLabel);

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Used to set JFrame to full screen
        // setUndecorated(true); /*Removes Window Navigation Buttons*/
        // setBounds(0,0,1910, 1000); /*Used if Extended State is not used */
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
