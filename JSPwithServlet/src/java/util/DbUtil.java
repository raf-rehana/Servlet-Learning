package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String url = "jdbc:mysql://localhost:3306/jsp";
    private static final String user = "root";
    private static final String password = "1234";

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database connection failed!");
            ex.printStackTrace();
            return null;
        }
    }
}