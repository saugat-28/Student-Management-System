package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddMarks extends JFrame implements ActionListener {
    JLabel heading, semLabel, semVal, subLabel, secLabel;
    JLabel usnLabel, nameLabel, nameValLabel, mark1Label, mark2Label, seMarkLabel;
    JTextField mark1TF, mark2TF, seMarkTF;
    JComboBox secCB, subjectCB, usnCB;
    JButton update, close, fetchUSNBtn;
    String subCode, sem, sec, usn, ia1Marks, ia2Marks, seMarks;
    Boolean subFetched = false, usnFetched = false;
    ArrayList usnAL, nameAL, subjects, sections;

    AddMarks() {
        heading = new JLabel("ENTER MARKS FOR STUDENTS");
        heading.setBounds(135, 5, 300, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 17));
        heading.setForeground(Color.BLUE);
        add(heading);

        subjects = new ArrayList();
        sections = new ArrayList();
        sections.add("All");

        subLabel = new JLabel("SUBJECT: ");
        subLabel.setBounds(40, 50, 80, 20);
        subLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(subLabel);

        subjectCB = new JComboBox();
        subjectCB.setBounds(120, 50, 280, 20);
        subjectCB.addActionListener(this);
        add(subjectCB);

        semLabel = new JLabel("SEM: ");
        semLabel.setBounds(40, 90, 50, 20);
        semLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(semLabel);

        semVal = new JLabel();
        semVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        semVal.setBounds(90, 90, 50, 20);
        add(semVal);

        secLabel = new JLabel("SEC: ");
        secLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        secLabel.setBounds(120, 90, 50, 20);
        add(secLabel);

        secCB = new JComboBox();
        secCB.setBounds(160, 90, 50, 20);
        add(secCB);

        fetchUSNBtn = new JButton("Fetch USNs");
        fetchUSNBtn.setBounds(290, 85, 150, 30);
        fetchUSNBtn.setBackground(Color.BLACK);
        fetchUSNBtn.setForeground(Color.WHITE);
        fetchUSNBtn.addActionListener(this);
        add(fetchUSNBtn);

        usnLabel = new JLabel("USN: ");
        usnLabel.setBounds(40, 130, 50, 20);
        usnLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(usnLabel);

        usnCB = new JComboBox();
        usnCB.setBounds(90, 130, 120, 20);
        usnCB.addActionListener(this);
        add(usnCB);

        nameLabel = new JLabel("NAME: ");
        nameLabel.setBounds(230, 130, 90, 20);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(nameLabel);

        nameValLabel = new JLabel();
        nameValLabel.setBounds(290, 130, 200, 20);
        nameValLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(nameValLabel);

        mark1Label = new JLabel("IA1 MARKS: ");
        mark1Label.setBounds(40, 170, 100, 30);
        mark1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(mark1Label);

        mark1TF = new JTextField();
        mark1TF.setBounds(140, 170, 100, 30);
        add(mark1TF);

        mark2Label = new JLabel("IA2 MARKS: ");
        mark2Label.setBounds(40, 210, 100, 30);
        mark2Label.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(mark2Label);

        mark2TF = new JTextField();
        mark2TF.setBounds(140, 210, 100, 30);
        add(mark2TF);

        seMarkLabel = new JLabel("SE MARKS");
        seMarkLabel.setBounds(40, 250, 100, 30);
        seMarkLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(seMarkLabel);

        seMarkTF = new JTextField();
        seMarkTF.setBounds(140, 250, 100, 30);
        seMarkTF.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(seMarkTF);

        update = new JButton("UPDATE");
        update.setBounds(40, 300, 150, 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        close = new JButton("CLOSE");
        close.setBounds(295, 300, 150, 30);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.addActionListener(this);
        add(close);

        loadSubjects();

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 500, 400);
        setVisible(true);
    }

    void loadSubjects() {
        String subQuery = "SELECT DISTINCT(SUBCODE) FROM ASSIGNED WHERE FACTID = '" + UserDetails.factId + "'";
        String subQuery1 = "SELECT DISTINCT(SUBCODE) FROM ASSIGNED WHERE FACTID = '" + "ISE/001" + "'";
        Conn conn = new Conn();
        try {
            ResultSet subcodeResult = conn.statement.executeQuery(subQuery1);
            while (subcodeResult.next()) {
                subjects.add(subcodeResult.getString(1));
            }
            System.out.println(subjects);
            DefaultComboBoxModel model = new DefaultComboBoxModel(subjects.toArray());
            subjectCB.setModel(model);
            subFetched = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (subFetched) {
            loadSection();
        }
    }

    void loadSection() {
        subCode = String.valueOf(subjectCB.getSelectedItem());
        String secQuery = "SELECT SEC, SEM FROM ASSIGNED WHERE FACTID='" + UserDetails.factId + "' AND SUBCODE = '" + subCode + "'";
        String secQuery1 = "SELECT SEC, SEM FROM ASSIGNED WHERE FACTID='ISE/001' AND SUBCODE = '18CS51'";
        String secQuery2 = "SELECT SEC, SEM FROM ASSIGNED WHERE FACTID='ISE/001' AND SUBCODE = '" + subCode + "'";
        ArrayList sectionsAL = new ArrayList();
        Conn conn = new Conn();
        try {
            ResultSet subcodeResult = conn.statement.executeQuery(secQuery2);
            while (subcodeResult.next()) {
                sectionsAL.add(subcodeResult.getString(1));
                semVal.setText(subcodeResult.getString(2));
            }
            System.out.println(sectionsAL);
            DefaultComboBoxModel model = new DefaultComboBoxModel(sectionsAL.toArray());
            secCB.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void fetchUSN() {
        if (subFetched) {
            this.sem = semVal.getText();
            this.sec = String.valueOf(secCB.getSelectedItem());
            String query = "SELECT USN, NAME FROM STUDENT WHERE SEM = '" + sem + "' AND SEC = '" + sec + "'";
            Conn conn = new Conn();
            String usn, name;
            usnAL = new ArrayList<>();
            nameAL = new ArrayList<>();
            try {
                ResultSet usnRS = conn.statement.executeQuery(query);
                while (usnRS.next()) {
                    usn = usnRS.getString(1);
                    usnAL.add(usn);
                    name = usnRS.getString(2);
                    nameAL.add(name);
                }
                DefaultComboBoxModel model = new DefaultComboBoxModel(usnAL.toArray());
                usnCB.setModel(model);
                usnFetched = true;
                setName();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void setName() {
        if (usnFetched) {
            int index = usnAL.indexOf(usnCB.getSelectedItem());
            nameValLabel.setText(String.valueOf(nameAL.get(index)));
        }
    }

    void updateMarks() {
        if (usnFetched) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchUSNBtn) {
            fetchUSN();
        } else if (e.getSource() == subjectCB) {
            loadSection();
        } else if (e.getSource() == close) {
            this.setVisible(false);
        } else if (e.getSource() == usnCB) {
            setName();
        } else if (e.getSource() == update) {
            updateMarks();
        }
    }

    public static void main(String[] args) {
        new AddMarks();
    }
}