package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenuItem home, student, faculty, addStudents, addFaculty, logOut;
    JMenu user;

    public AdminDashboard(){
        menuBar = new JMenuBar();
        add(menuBar);

        home = new JMenuItem("Home");
        home.addActionListener(this);
        menuBar.add(home);

        student = new JMenuItem("Student");
        menuBar.add(student);

        faculty = new JMenuItem("Faculty");
        menuBar.add(faculty);

        user = new JMenu("User");
        menuBar.add(user);

        addStudents = new JMenuItem("Add Student");
        addStudents.addActionListener(this);
        user.add(addStudents);

        addFaculty = new JMenuItem("Add Faculty");
        addFaculty.addActionListener(this);
        user.add(addFaculty);

        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Faculty")){
            new AddFaculty().setVisible(true);
        } else if(e.getActionCommand().equals("Add Student")){
            new AddStudents().setVisible(true);
        } else if(e.getActionCommand().equals("Log Out")){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AdminDashboard().setVisible(true);
    }
}
