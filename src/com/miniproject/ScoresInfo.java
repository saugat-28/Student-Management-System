package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScoresInfo extends JFrame implements ActionListener {
    JTable attendanceTable;
    JLabel sem, semVal;
    JButton applyFilter, close;
    JComboBox subject, sec;
    JCheckBox useFilter;
    ArrayList subjects, sections;

    ScoresInfo(){
        subjects = new ArrayList();
        sections = new ArrayList();
        subjects.add("All");
        sections.add("All");

        attendanceTable = new JTable();
        attendanceTable.setBounds(20, 35, 1000, 490);
        add(attendanceTable);

        useFilter = new JCheckBox("Use Filter");
        useFilter.setBounds(100, 520, 80, 40);
        useFilter.setBackground(Color.WHITE);
        useFilter.addActionListener(this);
        add(useFilter);

        subject = new JComboBox(subjects.toArray());
        subject.setBounds(200, 530, 280, 20);
        add(subject);

        sem = new JLabel("SEM: ");
        sem.setBounds(500, 530, 50, 20);
        sem.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(sem);

        semVal = new JLabel();
        semVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        semVal.setBounds(550, 530, 50, 20);
        add(semVal);

        sec = new JComboBox(sections.toArray());
        sec.setBounds(600, 530, 50, 20);
        add(sec);

        applyFilter = new JButton("Apply Filter");
        applyFilter.setBounds(100, 560, 150, 30);
        applyFilter.setForeground(Color.WHITE);
        applyFilter.setBackground(Color.BLACK);
        applyFilter.addActionListener(this);
        add(applyFilter);

        close = new JButton("Close");
        close.setBounds(800, 560, 150, 30);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.addActionListener(this);
        add(close);

        subject.setEnabled(false);
//        sem.setEnabled(false);
        sec.setEnabled(false);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 1055, 640);
        setVisible(true);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 1055, 640);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == useFilter) {
            if (useFilter.isSelected()) {
                subject.setEnabled(true);
//                sem.setEnabled(true);
                sec.setEnabled(true);
            } else {
                subject.setEnabled(false);
//                sem.setEnabled(false);
                sec.setEnabled(false);
            }
        } else if(e.getSource() == applyFilter){
//            String newQuery = getQuery();
//            loadStudents(newQuery);
        } else if(e.getSource() == close){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ScoresInfo();
    }
}
