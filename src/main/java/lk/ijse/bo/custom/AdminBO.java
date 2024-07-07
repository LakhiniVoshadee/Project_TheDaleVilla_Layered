package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.sql.SQLException;

public interface AdminBO extends SuperBO {
    boolean verifyCredentials(String UserName, String Password) throws SQLException, ClassNotFoundException;
}
