package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.RoomBooking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBookingBO extends SuperBO {

    public boolean deleteRoomBooking(String id) throws SQLException, ClassNotFoundException ;


    public boolean updateRoomBooking(RoomBooking entity) throws SQLException, ClassNotFoundException ;


    public ResultSet generateNextRoomBookingId() throws SQLException, ClassNotFoundException ;


    public boolean saveRoomBooking(RoomBooking entity) throws SQLException, ClassNotFoundException ;


    public List<String> getRoomBookingIds() throws SQLException, ClassNotFoundException ;


    public RoomBooking searchRoomBooking(String id) throws SQLException, ClassNotFoundException ;


    public ArrayList<RoomBooking> getAllRoomBooking() throws SQLException, ClassNotFoundException ;


    public int countRoomBooking() throws SQLException, ClassNotFoundException ;
}
