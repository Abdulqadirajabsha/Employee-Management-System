package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadingPage extends JFrame implements ActionListener{
    
    LoadingPage() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(270,30,1200,100);
        heading.setFont(new Font("serif",Font.PLAIN, 45));
        heading.setForeground(Color.blue);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel frontimage = new JLabel(i3);
        frontimage.setBounds(10,30,1280,720);
        add(frontimage);
        
        JButton clickhere = new JButton("Continue to Login Page");
        clickhere.setBounds(550,500,200,50);
        clickhere.addActionListener(this);
        frontimage.add(clickhere);
        
        add(heading);
        setSize(1280,720);
        setLocation(100,50);
        setVisible(true);
        
        while(true)
        {
            heading.setVisible(false);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
            }
             heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        
    }

    public static void main(String args[]) {
        new LoadingPage();

    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        setVisible(false);
        new Login();
    }
}




