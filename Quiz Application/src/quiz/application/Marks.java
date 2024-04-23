package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Marks extends JFrame {
    
    Marks(String name1, int score){
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/header.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        JLabel qno = new JLabel(name1 + "Your Score is :- " + score);
        qno.setBounds(130, 450, 900, 50);
        qno.setFont(new Font("Blackadder ITC", Font.BOLD, 24));
        add(qno);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Marks("User", 0);
    }
}
