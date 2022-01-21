package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAttendanceInfo extends JFrame {
    JLabel subCodeLabel, subTitleLabel, ia1MarksLabel,ia2MarksLabel, seMarksLabel;
    JTable scoresTable;

    StudentAttendanceInfo(){
        subCodeLabel = new JLabel("SUBCODE");
        subCodeLabel.setBounds(95, 6, 80, 30);
        add(subCodeLabel);

        subTitleLabel = new JLabel("SUBJECT TITLE");
        subTitleLabel.setBounds(275, 6, 100, 30);
        add(subTitleLabel);

        ia1MarksLabel = new JLabel("ATTENDED");
        ia1MarksLabel.setBounds(485, 6, 100, 30);
        add(ia1MarksLabel);

        ia2MarksLabel = new JLabel("TOTAL");
        ia2MarksLabel.setBounds(690, 6, 100, 30);
        add(ia2MarksLabel);


        scoresTable = new JTable();
        scoresTable.setBounds(20, 35, 800, 260);
        add(scoresTable);

        fetchAttendance();

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 840, 280);
        setVisible(true);
    }

    void fetchAttendance(){
        String query = "SELECT S.SUBCODE, S.NAME, A.ATTENDED, A.TOTAL FROM SUBJECT S, ATTENDANCE A WHERE S.SUBCODE = A.SUBCODE AND A.USN = '" + UserDetails.usn + "'";
        Conn conn = new Conn();
        try {
            ResultSet scores = conn.statement.executeQuery(query);
            scoresTable.setModel(DbUtils.resultSetToTableModel(scores));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentAttendanceInfo();
    }
}
