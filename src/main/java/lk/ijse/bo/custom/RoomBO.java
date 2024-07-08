package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Room;
import lk.ijse.model.RoomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {

    public boolean deleteRoom(String id) throws SQLException, ClassNotFoundException ;


    public boolean updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;


    public ResultSet generateNextRoomId() throws SQLException, ClassNotFoundException;


    public boolean saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException ;


    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException ;


    public int countRoom() throws SQLException, ClassNotFoundException ;
}
