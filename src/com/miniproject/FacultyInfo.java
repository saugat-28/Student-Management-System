package com.miniproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyInfo extends JFrame {

    JTable facultyTable;
    JButton applyFilter, back;

    FacultyInfo() {

        facultyTable = new JTable();
        facultyTable.setBounds(20, 10, 800, 500);
        add(facultyTable);

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
        String query = "SELECT * FROM FACULTY";
        // TODO: Add Query Selection Logic Here
        return query;
    }

    void loadStudents(String query) {
        Conn conn = new Conn();
        try {
            ResultSet resultSet = conn.statement.executeQuery(query);
            facultyTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FacultyInfo();
    }
}
