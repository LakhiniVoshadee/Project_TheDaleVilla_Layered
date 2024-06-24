package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Dbconnection dbconnection;
    private final Connection connection;

    private Dbconnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "IJSE@123");

    }
    public static Dbconnection getDbconnection() throws SQLException, ClassNotFoundException {
        return dbconnection == null ? dbconnection = new Dbconnection() : dbconnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
