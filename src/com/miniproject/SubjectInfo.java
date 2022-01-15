package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectInfo extends JFrame {
    JTable subjectTable;
    JButton applyFilter, back;

    SubjectInfo() {

        subjectTable = new JTable();
        subjectTable.setBounds(20, 20, 1000, 500);
        add(subjectTable);

        applyFilter = new JButton("Apply Filter");
        applyFilter.setBounds(100, 520, 150, 30);
        applyFilter.setForeground(Color.WHITE);
        applyFilter.setBackground(Color.BLACK);
        add(applyFilter);

        back = new JButton("Back");
        back.setBounds(800, 520, 150, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        add(back);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(450, 200, 1055, 600);
        setVisible(true);

        String query = getQuery();
        loadStudents(query);

    }

    String getQuery() {
        String query = "SELECT * FROM SUBJECT";
        // TODO: Add Query Selection Logic Here
        return query;
    }

    void loadStudents(String query) {
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
