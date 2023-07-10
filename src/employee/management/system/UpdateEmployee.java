package employee.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfname, tsalary, tphoneno, temail, taddress, tdesignation, teducation;
    JLabel tempid, lbname, lbdob;
    JButton update, back;
    String emplid;

    public UpdateEmployee(String emplid) {
        this.emplid = emplid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(265, 30, 1200, 100);
        heading.setFont(new Font("serif", Font.PLAIN, 35));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel lname = new JLabel("Name :");
        lname.setBounds(270, 150, 50, 20);
        lname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lname);

        JLabel lbname = new JLabel();
        lbname.setBounds(360, 150, 200, 20);
        add(lbname);

        JLabel fname = new JLabel("Father Name :");
        fname.setBounds(270, 180, 100, 20);
        fname.setFont(new Font("serif", Font.PLAIN, 15));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(360, 180, 200, 20);
        add(tfname);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setBounds(270, 210, 100, 20);
        dob.setFont(new Font("serif", Font.PLAIN, 15));
        add(dob);

        JLabel lbdob = new JLabel();
        lbdob.setBounds(360, 210, 220, 20);
        add(lbdob);

        JLabel salary = new JLabel("Salary :");
        salary.setBounds(270, 235, 60, 30);
        salary.setFont(new Font("serif", Font.PLAIN, 15));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(360, 240, 200, 20);
        add(tsalary);

        JLabel address = new JLabel("Address :");
        address.setBounds(270, 265, 60, 30);
        address.setFont(new Font("serif", Font.PLAIN, 15));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(360, 270, 200, 40);
        add(taddress);

        JLabel phoneno = new JLabel("Phone No :");
        phoneno.setBounds(270, 320, 100, 20);
        phoneno.setFont(new Font("serif", Font.PLAIN, 15));
        add(phoneno);

        tphoneno = new JTextField();
        tphoneno.setBounds(360, 320, 200, 20);
        add(tphoneno);

        JLabel email = new JLabel("Email :");
        email.setBounds(270, 350, 100, 20);
        email.setFont(new Font("serif", Font.PLAIN, 15));
        add(email);

        temail = new JTextField();
        temail.setBounds(360, 350, 200, 20);
        add(temail);

        JLabel education = new JLabel("Education :");
        education.setBounds(270, 380, 100, 20);
        education.setFont(new Font("serif", Font.PLAIN, 15));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(360, 380, 200, 20);
        teducation.setFont(new Font("serif", Font.PLAIN, 13));
        teducation.setBackground(Color.WHITE);
        add(teducation);

        JLabel designation = new JLabel("Designation :");
        designation.setBounds(270, 410, 100, 20);
        designation.setFont(new Font("serif", Font.PLAIN, 15));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(360, 415, 200, 20);
        add(tdesignation);

        JLabel empid = new JLabel("Employee Id :");
        empid.setBounds(270, 445, 100, 20);
        empid.setFont(new Font("serif", Font.PLAIN, 15));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(360, 445, 200, 20);
        tempid.setFont(new Font("serif", Font.PLAIN, 15));
        add(tempid);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM employee where EmployeeID = '" + emplid + "'";
            ResultSet r = c.s.executeQuery(query);

            while (r.next()) {
                lbname.setText(r.getString("Name"));
                tfname.setText(r.getString("Fathername"));
                lbdob.setText(r.getString("DOB"));
                tsalary.setText(r.getString("Salary"));
                tphoneno.setText(r.getString("Phonenumber"));
                temail.setText(r.getString("Email"));
                teducation.setText(r.getString("Education"));
                taddress.setText(r.getString("Address"));
                tdesignation.setText(r.getString("Designation"));
                tempid.setText(r.getString("EmployeeID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(300, 500, 100, 30);
        update.setFont(new Font("serif", Font.PLAIN, 15));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(450, 500, 100, 30);
        back.setFont(new Font("serif", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(320, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
//            String name = lbname.getText(); 
            String fname = tfname.getText();
//            String dob = lbdob.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phoneno = tphoneno.getText();
            String email = temail.getText();
            String designation = tdesignation.getText(); 
            String education = teducation.getText();
            String empid = tempid.getText();

            try {
                ConnectionDB con = new ConnectionDB();
                String query = "UPDATE employee SET Fathername = '" + fname + "', Salary = '" + salary + "', Phonenumber ='" + phoneno
                        + "',Email = '" + email + "', Education = '" + education + "', Address = '" + address + "',"
                        + " Designation = '" + designation + "' WHERE EmployeeID = '" + empid + "'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details Updated successfully!!");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");

    }

}
