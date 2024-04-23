package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String[][] ques = new String[3][4];
    String[][] ans = new String[3][2];
    String[][] uans = new String[3][1];
    JLabel qno, qstn;
    JRadioButton op1, op2, op3;
    ButtonGroup group;
    JButton next, eo, sub;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int cnt = 0;
    public static int score = 0;
    String name1;
    
    Quiz(String name1){
        this.name1 = name1;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/header.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(130, 450, 50, 30);
        qno.setFont(new Font("Blackadder ITC", Font.BOLD, 24));
        add(qno);
        
        qstn = new JLabel();
        qstn.setBounds(150, 450, 900, 30);
        qstn.setFont(new Font("Blackadder ITC", Font.BOLD, 24));
        add(qstn);
        
        ques[0][0] = "Thala : ";
        ques[0][1] = "MSD";
        ques[0][2] = "Raina";
        ques[0][3] = "Jadeja";
        
        ques[1][0] = "Chinna Thala : ";
        ques[1][1] = "MSD";
        ques[1][2] = "Raina";
        ques[1][3] = "Jadeja";
        
        ques[2][0] = "Thalapathy : ";
        ques[2][1] = "MSD";
        ques[2][2] = "Raina";
        ques[2][3] = "Jadeja";
        
        ans[0][1] = "MSD";
        ans[1][1] = "Raina";
        ans[2][1] = "Jadeja";
        
        op1 = new JRadioButton();
        op1.setBounds(170, 520, 700, 30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Blackadder ITC", Font.PLAIN, 20));
        add(op1);
        
        op2 = new JRadioButton();
        op2.setBounds(170, 560, 700, 30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Blackadder ITC", Font.PLAIN, 20));
        add(op2);
        
        op3 = new JRadioButton();
        op3.setBounds(170, 600, 700, 30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Blackadder ITC", Font.PLAIN, 20));
        add(op3);
        
        group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.addActionListener(this);
        add(next);
        
        eo = new JButton("Eliminate Options");
        eo.setBounds(1100, 630, 200, 40);
        eo.addActionListener(this);
        add(eo);
        
        sub = new JButton("Submit");
        sub.setBounds(1100, 710, 200, 40);
        sub.addActionListener(this);
        sub.setEnabled(false);
        add(sub);
        
        start(cnt);
        
        setVisible(true);
    }
    
    public void start(int cnt){
        qno.setText("" + (cnt+1) + ")");
        qstn.setText(ques[cnt][0]);
        op1.setText(ques[cnt][1]);
        op1.setActionCommand(ques[cnt][1]);
        op2.setText(ques[cnt][2]);
        op2.setActionCommand(ques[cnt][2]);
        op3.setText(ques[cnt][3]);
        op3.setActionCommand(ques[cnt][3]);
        
        group.clearSelection();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left : " + timer + " sec";
        g.setColor(Color.RED);
        g.setFont(new Font("Blackadder ITC", Font.BOLD, 25));
        
        if(timer > 0){
            g.drawString(time, 1100, 500);
        }
        else{
            g.drawString("Time Up", 1100, 500);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }
        else if(timer < 0){
            timer = 15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            
            if(cnt == 1){
                next.setEnabled(false);
                sub.setEnabled(true);
            }
            
            if(cnt == 2){ //submit Button
                if(group.getSelection() == null){
                    uans[cnt][0] = "";
                }
                else{
                    uans[cnt][0] = group.getSelection().getActionCommand();
                }
                
                for(int i=0; i<uans.length; i++){
                    if(uans[i][0].equals(ans[i][1])){
                        score++;
                    }
                }
                setVisible(false);
                new Marks(name1, score);
            }
            else{ //Next Button
                if(group.getSelection() == null){
                    uans[cnt][0] = "";
                }
                else{
                    uans[cnt][0] = group.getSelection().getActionCommand();
                }
                cnt++;
                start(cnt);
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == next){
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            
            ans_given = 1;
            if(group.getSelection() == null){
                uans[cnt][0] = "";
            }
            else{
                uans[cnt][0] = group.getSelection().getActionCommand();
            }
            
            if(cnt == 1){
                next.setEnabled(false);
                sub.setEnabled(true);
            }
            cnt++;
            start(cnt);
        }
        else if(ae.getSource() == eo){
            if(cnt == 1 || cnt == 2){
                op3.setEnabled(false);
            }
            else{
                op1.setEnabled(false);
            }
            eo.setEnabled(false);
        }
        else if(ae.getSource() == sub){
            ans_given = 1;
            if(group.getSelection() == null){
                uans[cnt][0] = "";
            }
            else{
                uans[cnt][0] = group.getSelection().getActionCommand();
            }
                
            for(int i=0; i<uans.length; i++){
                if(uans[i][0].equals(ans[i][1])){
                    score++;
                }
            }
            setVisible(false);
            new Marks(name1, score);
        }
    }
    
    public static void main(String[] args){
        new Quiz("user");
    }
}
