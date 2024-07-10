package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.entity.RoomDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDetailsDAOImpl implements RoomDetailsDAO {
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(RoomDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(RoomDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public RoomDetails search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RoomDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
