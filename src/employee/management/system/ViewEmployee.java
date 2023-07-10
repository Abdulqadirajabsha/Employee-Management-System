package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    JLabel search;
    Choice tempid;
    JButton bsearch, update, tprint, back;

    public ViewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search by Employee ID :");
        search.setBounds(10, 20, 140, 20);
        add(search);

        tempid = new Choice();
        tempid.setBounds(150, 20, 150, 20);
        add(tempid);

        table = new JTable();
        try {

            ConnectionDB con = new ConnectionDB();
            ResultSet r = con.s.executeQuery("SELECT * FROM employee");
            while (r.next()) {
                tempid.add(r.getString("EmployeeID"));
            }

        } catch (Exception e) {
        }

        try {

            ConnectionDB con = new ConnectionDB();
            ResultSet r = con.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(r));

            while (r.next()) {
                tempid.add(r.getString("EmployeeID"));
            }

        } catch (Exception e) {
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(Color.WHITE);
        scroll.setBounds(0, 100, 1120, 630);
        add(scroll);

        bsearch = new JButton("Search");
        bsearch.setBounds(30, 60, 80, 25);
        bsearch.setFont(new Font("serif", Font.PLAIN, 15));
        bsearch.addActionListener(this);
        add(bsearch);

        update = new JButton("Update");
        update.setBounds(130, 60, 80, 25);
        update.setFont(new Font("serif", Font.PLAIN, 15));
        update.addActionListener(this);
        add(update);

        tprint = new JButton("Print");
        tprint.setBounds(230, 60, 80, 25);
        tprint.setFont(new Font("serif", Font.PLAIN, 15));
        tprint.addActionListener(this);
        add(tprint);

        back = new JButton("Back");
        back.setBounds(330, 60, 80, 25);
        back.setFont(new Font("serif", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        setSize(1120, 630);
        setLocation(200, 100);
        setVisible(true);
    }

    public static void main(String args[]) {
        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == bsearch) {
                String query = "SELECT * from employee WHERE EmployeeID = '"+tempid.getSelectedItem()+"'"; 
                try {
                     ConnectionDB con = new ConnectionDB();
            ResultSet r = con.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(r));
                } catch (Exception aa) {
                }
            } else if (e.getSource() == tprint) {
                try {
                    table.print();
                } catch (Exception aa) {
                }
            } else if (e.getSource() == update) {
                 setVisible(false);
                 new UpdateEmployee(tempid.getSelectedItem());
                
            } else if (e.getSource() == back) {
                setVisible(false);
                new Home();
            }
            else
            {
                
            }
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
}
