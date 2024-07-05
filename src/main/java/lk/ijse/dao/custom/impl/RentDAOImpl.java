
package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDAOImpl implements RentDAO {


    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Rent entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Rent entity) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Rent> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
}




