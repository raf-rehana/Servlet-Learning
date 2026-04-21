package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/jsp";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load once
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}