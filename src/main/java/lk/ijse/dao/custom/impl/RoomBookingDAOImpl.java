package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RoomBookingDAO;
import lk.ijse.entity.RoomBooking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBookingDAOImpl implements RoomBookingDAO {
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(RoomBooking entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Select RoomBookingID from RoomBooking order by RoomBookingID desc limit 1");
    }

    @Override
    public boolean save(RoomBooking entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public RoomBooking search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RoomBooking> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
