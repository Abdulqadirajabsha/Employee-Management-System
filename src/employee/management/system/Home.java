package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    
    JButton add, view, update, remove;
    
    public Home() {
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(200, 120, 1200, 100);
        heading.setFont(new Font("serif", Font.PLAIN, 45));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.blue);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel frontimage = new JLabel(i3);
        frontimage.setBounds(0, 0, 1120, 630);
        add(frontimage);
        
        add = new JButton("Add Employee");
        add.setBounds(350, 250, 200, 50);
        add.addActionListener(this);
        frontimage.add(add);
        
        view = new JButton("View Employee");
        view.setBounds(600, 250, 200, 50);
        view.addActionListener(this);
        frontimage.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(350, 350, 200, 50);
        update.addActionListener(this);
        frontimage.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(600, 350, 200, 50);
        remove.addActionListener(this);
        frontimage.add(remove);
        
        setSize(1120, 630);
        setLocation(200, 100);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
               setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
              setVisible(false);
            new UpdateEmployee("");
        } else if (ae.getSource() == remove){
             setVisible(false);
            new RemoveEmployee();
        }
        else
        {
        }
    }
}
}
