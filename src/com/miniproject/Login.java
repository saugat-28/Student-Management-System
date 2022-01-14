package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2;

    Login(){
        label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        add(label1);

        label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        add(label2);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        button1= new JButton("Login");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(40, 120, 120, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Cancel");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(180, 120, 120, 30);
        button2.addActionListener(this);
        add(button2);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/miniproject/icons/login.png"));
        Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel label3 = new JLabel(scaledIcon);
        label3.setBounds(350, 5, 200, 200);
        add(label3);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 300, 600, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            String username = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            Conn conn = new Conn();

            String query = "select * from users where username = '" + username + "' and password = '" + password + "'";
            try {
                ResultSet resultSet = conn.statement.executeQuery(query);

                if(resultSet.next()){
                    new AdminDashboard().setVisible(true);
                    this.setVisible(false);
//                    JOptionPane.showMessageDialog(null, "Username and Password found!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if(e.getSource() == button2){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
