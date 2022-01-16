package com.miniproject;

import java.sql.ResultSet;
import java.sql.SQLException;


// TO BE DELETED: Temporary Class for Testing and Debugging throughout Development
public class SQLQueryTest {

    public static void main(String[] args) {
        Conn conn = new Conn();
        String query = "SELECT * FROM STUDENT";

        try {
            ResultSet rs = conn.statement.executeQuery(query);
            rs.next();
            rs.next();
            String val = rs.getString(3);
            System.out.println("Value: " + val);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
