package com.miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends JFrame implements ActionListener {

    StudentManagementSystem(){
        setBounds(200, 200, 1030, 480);
//        setSize(400, 400);
//        setLocation(300, 300);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("com/miniproject/icons/jss.jpg"));
        JLabel label1= new JLabel(icon1);
        label1.setBounds(0,0,1024,451);
        add(label1);

        JLabel label2 = new JLabel("Student Management System");
        label2.setBounds(30, 5,1000, 70);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("serif", Font.PLAIN,55));
        label1.add(label2);

        JButton button1 = new JButton("Next");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(900, 10, 100, 30);
        button1.addActionListener(this);
        label1.add(button1);

        setLayout(null);
        setVisible(true);

//        while (true){
//            label2.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            label2.setVisible(true);
//            try{
//                Thread.sleep(500);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }


}
