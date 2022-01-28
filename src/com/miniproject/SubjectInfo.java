package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectInfo extends JFrame {
    JTable subjectTable;

    SubjectInfo() {

        subjectTable = new JTable();
        subjectTable.setBounds(20, 35, 1000, 490);
        add(subjectTable);

        JLabel subCodeLabel = new JLabel("SUBJECT CODE");
        subCodeLabel.setBounds(140, 6, 150, 30);
        add(subCodeLabel);

        JLabel nameLabel = new JLabel("TITLE");
        nameLabel.setBounds(500, 6, 60, 30);
        add(nameLabel);

        JLabel creditLabel = new JLabel("CREDITS");
        creditLabel.setBounds(830, 6, 60, 30);
        add(creditLabel);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(450, 200, 1055, 600);
        setVisible(true);

        String query = getQuery();
        loadStudents(query);

    }

    String getQuery() {
        String query = "SELECT * FROM SUBJECT";
        // if filter is added, add selection query generation logic here
        return query;
    }

    void loadStudents(String query) {
        UserDetails.recentQuery = query;
        Conn conn = new Conn();
        try {
            ResultSet resultSet = conn.statement.executeQuery(query);
            subjectTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SubjectInfo();
    }
}
