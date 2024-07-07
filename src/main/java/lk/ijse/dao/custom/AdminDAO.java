package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDAO extends CrudDAO<Admin> {
    ResultSet verifyCredentials(String UserName, String Password) throws SQLException, ClassNotFoundException;
}
