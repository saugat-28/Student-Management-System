package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentScoreInfo extends JFrame {
    JLabel subCodeLabel, subTitleLabel, ia1MarksLabel,ia2MarksLabel, seMarksLabel;
    JTable scoresTable;

    StudentScoreInfo(){
        subCodeLabel = new JLabel("SUBCODE");
        subCodeLabel.setBounds(90, 6, 80, 30);
        add(subCodeLabel);

        subTitleLabel = new JLabel("SUBJECT TITLE");
        subTitleLabel.setBounds(270, 6, 100, 30);
        add(subTitleLabel);

        ia1MarksLabel = new JLabel("IA1 MARKS");
        ia1MarksLabel.setBounds(485, 6, 100, 30);
        add(ia1MarksLabel);

        ia2MarksLabel = new JLabel("IA2 MARKS");
        ia2MarksLabel.setBounds(685, 6, 100, 30);
        add(ia2MarksLabel);

        seMarksLabel = new JLabel("SEMARKS");
        seMarksLabel.setBounds(885, 6, 100, 30);
        add(seMarksLabel);

        scoresTable = new JTable();
        scoresTable.setBounds(20, 35, 1000, 260);
        add(scoresTable);

        loadScores();

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 1055, 280);
        setVisible(true);
    }

    void loadScores(){
        String query = "SELECT S.SUBCODE, S.NAME, M.IA1MARKS, M.IA2MARKS, M.SEMARKS FROM SUBJECT S, MARKS M WHERE S.SUBCODE = M.SUBCODE AND M.USN = '" + UserDetails.usn + "'";
        UserDetails.recentQuery = query;
        Conn conn = new Conn();
        try {
            ResultSet scores = conn.statement.executeQuery(query);
            scoresTable.setModel(DbUtils.resultSetToTableModel(scores));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentScoreInfo();
    }
}
