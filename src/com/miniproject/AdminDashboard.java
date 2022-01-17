package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu view, addNew, delete, user;
    JMenuItem home, student, faculty, subject; // For MenuBar
    JMenuItem addStudents, addFaculty, addSubject; // For AddNew Menu
    JMenuItem deleteStudent, deleteFaculty, deleteSubject; // For Edit Menu
    JMenuItem logOut; // For User Menu


    public AdminDashboard() {
        menuBar = new JMenuBar();
        add(menuBar);

        home = new JMenuItem("Home");
        home.addActionListener(this);
        menuBar.add(home);

        view = new JMenu("View");
        menuBar.add(view);

        student = new JMenuItem("Student");
        student.addActionListener(this);
        view.add(student);

        faculty = new JMenuItem("Faculty");
        faculty.addActionListener(this);
        view.add(faculty);

        subject = new JMenuItem("Subject");
        subject.addActionListener(this);
        view.add(subject);

        addNew = new JMenu("Add New");
        menuBar.add(addNew);

        addStudents = new JMenuItem("Add Student");
        addStudents.addActionListener(this);
        addNew.add(addStudents);

        addFaculty = new JMenuItem("Add Faculty");
        addFaculty.addActionListener(this);
        addNew.add(addFaculty);

        addSubject = new JMenuItem("Add Subject");
        addSubject.addActionListener(this);
        addNew.add(addSubject);


        delete = new JMenu("Edit");
        menuBar.add(delete);

        deleteStudent = new JMenuItem("Edit Student");
        deleteStudent.addActionListener(this);
        delete.add(deleteStudent);

        deleteFaculty = new JMenuItem("Edit Faculty");
        deleteFaculty.addActionListener(this);
        delete.add(deleteFaculty);

        deleteSubject = new JMenuItem("Edit Subject");
        deleteSubject.addActionListener(this);
        delete.add(deleteSubject);

        user = new JMenu("User");
        menuBar.add(user);

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

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Used to set JFrame to full screen
        // setUndecorated(true); /*Removes Window Navigation Buttons*/
        // setBounds(0,0,1910, 1000); /*Used if Extended State is not used */
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Faculty")) {
            new AddFaculty().setVisible(true);
        } else if (e.getActionCommand().equals("Add Student")) {
            new AddStudents().setVisible(true);
        } else if (e.getActionCommand().equals("Add Subject")) {
            new AddSubject().setVisible(true);
        } else if (e.getActionCommand().equals("Student")) {
            new StudentInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Faculty")) {
            new FacultyInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Subject")) {
            new SubjectInfo().setVisible(true);
        } else if (e.getActionCommand().equals("Edit Student")) {
            new EditStudent().setVisible(true);
        } else if (e.getActionCommand().equals("Edit Faculty")) {
            new EditFaculty().setVisible(true);
        } else if (e.getActionCommand().equals("Edit Subject")) {
            new EditSubject().setVisible(true);
        } else if (e.getActionCommand().equals("Log Out")) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AdminDashboard().setVisible(true);

    }
}
