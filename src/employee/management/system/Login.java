package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tusername, tpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);

        JLabel lusername = new JLabel("Username :");
        lusername.setBounds(50, 100, 80, 20);
        add(lusername);
        JLabel lpassword = new JLabel("Password :");
        lpassword.setBounds(50, 135, 80, 20);
        add(lpassword);

        tusername = new JTextField();
        tusername.setBounds(140, 100, 150, 20);
        add(tusername);
        tpassword = new JTextField();
        tpassword.setBounds(140, 135, 150, 20);
        add(tpassword);

        JButton Login = new JButton("Login");
        Login.setBounds(160, 170, 100, 25);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel frontimage = new JLabel(i3);
        frontimage.setBounds(300, 30, 200, 200);
        add(frontimage);

        setLayout(null);
        setSize(550, 350);
        setLocation(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = tusername.getText();
            String password = tpassword.getText();
            ConnectionDB con = new ConnectionDB();
            String query= "SELECT * from Login where username = '"+username+"' AND password = '"+password+"'";
            ResultSet rs = con.s.executeQuery(query);
            
            if(rs.next())
            {
                setVisible(false);
                new Home();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid username or password!!");
                setVisible(false);
            }  
            
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
}
