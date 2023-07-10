package employee.management.system;
import java.sql.*;

public class ConnectionDB {
    
    Connection c;
    Statement s;
    public ConnectionDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "Slq@#321");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
}
