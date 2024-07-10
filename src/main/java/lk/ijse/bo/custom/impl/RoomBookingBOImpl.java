package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RoomBookingBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RoomBookingDAO;
import lk.ijse.entity.RoomBooking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBookingBOImpl implements RoomBookingBO {

    RoomBookingDAO roomBookingDAO = (RoomBookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_BOOKING);
    @Override
    public boolean deleteRoomBooking(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateRoomBooking(RoomBooking entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateNextRoomBookingId() throws SQLException, ClassNotFoundException {
        return roomBookingDAO.generateNextId();
    }

    @Override
    public boolean saveRoomBooking(RoomBooking entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<String> getRoomBookingIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public RoomBooking searchRoomBooking(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RoomBooking> getAllRoomBooking() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int countRoomBooking() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
