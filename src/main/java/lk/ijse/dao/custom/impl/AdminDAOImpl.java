/*
package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {


    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Admin entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Select UserId from Admin order by UserId desc limit 1 ");
    }

    @Override
    public boolean save(Admin entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Admin> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }

    public ResultSet verify(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("");
    }
}
*/
