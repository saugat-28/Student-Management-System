package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentScoreInfo extends JFrame implements ActionListener {
    JLabel subCodeLabel, subTitleLabel, ia1MarksLabel,ia2MarksLabel, seMarksLabel;
    JTable scoresTable;
    JButton saveBtn;

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
        scoresTable.setBounds(20, 35, 1000, 200);
        add(scoresTable);

        loadScores();

        JLabel saveCSV = new JLabel("SAVE CSV:");
        saveCSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        saveCSV.setBounds(920, 240, 80, 30);
        add(saveCSV);

        ImageIcon saveIcon = new ImageIcon(ClassLoader.getSystemResource("com/miniproject/icons/download_icon_white.png"));
        Image scaledImage = saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(scaledImage);

        saveBtn = new JButton(icon);
        saveBtn.setBounds(1000, 240, 30, 30);
        saveBtn.setBackground(Color.BLACK);
        saveBtn.addActionListener(this);
        add(saveBtn);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 210, 1055, 310);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveBtn){
            new SaveCSV();
        }
    }

    public static void main(String[] args) {
        new StudentScoreInfo();
    }


}
