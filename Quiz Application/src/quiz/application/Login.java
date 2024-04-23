package quiz.application;

import javax.swing.*; // This includes Jframe
import java.awt.*; // for backgroundColour 
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    JButton butt, back;
    JTextField name;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(20, 20, 750, 750);
        add(image);
        
        JLabel head = new JLabel("Java Quiz");
        head.setBounds(1050, 100, 300, 45);
        head.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        head.setForeground(new Color(30, 144, 254));
        add(head);
        
        JLabel eName = new JLabel("Enter Your Name : ");
        eName.setBounds(1070, 200, 300, 45);
        eName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(eName);
        
        name = new JTextField();
        name.setBounds(1000, 250, 300, 35);
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name);
        
        JLabel eEmail = new JLabel("Enter Your Email : ");
        eEmail.setBounds(1070, 350, 300, 45);
        eEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(eEmail);
        
        JTextField mail = new JTextField();
        mail.setBounds(1000, 400, 300, 35);
        mail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(mail);
        
        butt = new JButton("Start Quiz");
        butt.setBounds(1000, 500, 300, 45);
        butt.addActionListener(this);
        add(butt);
        
        back = new JButton("Exit");
        back.setBounds(1000, 550, 300, 45);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        setSize(1700, 1000);
    }
    
    public void actionPerformed(ActionEvent ae){
        // in Action Listener implements it is abstract so we can declare this method;
        if(ae.getSource() == butt){
            String name1 = name.getText();
            setVisible(false);
            new Quiz(name1);
        }
        else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
