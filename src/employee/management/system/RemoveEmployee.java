package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    JLabel lempid, lblname, lname, lbldesignation, ldesignation, lblemail, lemail;
    Choice cempid;
    JButton remove, back;

    public RemoveEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        lempid = new JLabel("Employee ID :");
        lempid.setBounds(50, 50, 80, 20);
        add(lempid);

        cempid = new Choice();
        cempid.setBounds(140, 50, 150, 20);
        add(cempid);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM employee";
            ResultSet r = c.s.executeQuery(query);

            while (r.next()) {
                cempid.add(r.getString("EmployeeID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblname = new JLabel("Name :");
        lblname.setBounds(50, 100, 100, 20);
        lblname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblname);

        lname = new JLabel();
        lname.setBounds(140, 100, 100, 20);
        lname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lname);

        lbldesignation = new JLabel("Designation :");
        lbldesignation.setBounds(50, 130, 100, 20);
        lbldesignation.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbldesignation);

        ldesignation = new JLabel();
        ldesignation.setBounds(140, 130, 200, 20);
        ldesignation.setFont(new Font("serif", Font.PLAIN, 15));
        add(ldesignation);

        lblemail = new JLabel("Email :");
        lblemail.setBounds(50, 160, 100, 20);
        lblemail.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblemail);

        lemail = new JLabel();
        lemail.setBounds(140, 160, 200, 20);
        lemail.setFont(new Font("serif", Font.PLAIN, 15));
        add(lemail);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM employee where EmployeeID = '" + cempid.getSelectedItem() + "'";
            ResultSet r = c.s.executeQuery(query);

            while (r.next()) {
                lname.setText(r.getString("Name"));
                ldesignation.setText(r.getString("Designation"));
                lemail.setText(r.getString("Email"));

            }
        } catch (SQLException ae) {
        }

        cempid.addItemListener((ItemEvent e) -> {
            try {
                ConnectionDB c = new ConnectionDB();
                String query = "SELECT * FROM employee where EmployeeID = '" + cempid.getSelectedItem() + "'";
                ResultSet r = c.s.executeQuery(query);

                while (r.next()) {
                    lname.setText(r.getString("Name"));
                    ldesignation.setText(r.getString("Designation"));
                    lemail.setText(r.getString("Email"));

                }
            } catch (SQLException ae) {
            }
        });

        remove = new JButton("Delete");
        remove.setBounds(50, 230, 90, 25);
        remove.setFont(new Font("serif", Font.PLAIN, 15));
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        add(remove);

        back = new JButton("Back");
        back.setBounds(200, 230, 80, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel frontimage = new JLabel(i3);
        frontimage.setBounds(290, -70, 500, 500);
        add(frontimage);

        setSize(800, 450);
        setLocation(400, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            try {
                ConnectionDB c = new ConnectionDB();
                String query = "DELETE FROM employee where EmployeeID = '" + cempid.getSelectedItem() + "'";
               c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details has been deleted successfully");
                setVisible(false);
                new Home();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

}
