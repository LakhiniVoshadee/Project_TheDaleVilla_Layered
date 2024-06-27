package lk.ijse.dao;

import lk.ijse.db.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
     public static <T> T execute(String sql,Object... args) throws SQLException, ClassNotFoundException {
         Connection connection = Dbconnection.getInstance().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         for (int i = 0; i < args.length; i++) {
             preparedStatement.setObject(i + 1, args[i]);
         }
         if (sql.startsWith("SELECT")) {
             return (T) preparedStatement.executeQuery();
         }else {
             return (T) (Boolean)(preparedStatement.executeUpdate()>0);
         }
     }
}
