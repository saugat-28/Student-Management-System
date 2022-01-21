package com.miniproject;

import javax.swing.*;

public class Credits extends JFrame {
    static String subCode = "                           18CSL58";
    static String subject = "\nDBMS LABORATORY WITH MINI PROJECT";
    static String title = "\n     STUDENT MANAGEMENT SYSTEM";
    static String madeBy = "\n                           MADE BY:\n        1JS19IS088 - Saugat Shrivastava\n        1JS19IS092 - Shreya Prasad";

    Credits() {
        JOptionPane.showMessageDialog(null, subCode+subject + title + madeBy);
    }
}
