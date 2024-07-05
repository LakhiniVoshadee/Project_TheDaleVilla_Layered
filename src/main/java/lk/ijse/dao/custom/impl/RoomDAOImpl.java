package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Room entity) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
