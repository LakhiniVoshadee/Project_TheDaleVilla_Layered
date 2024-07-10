package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.RoomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBO extends SuperBO {

    public boolean deleteRoom(String id) throws SQLException, ClassNotFoundException ;


    public boolean updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;


    public ResultSet generateNextRoomId() throws SQLException, ClassNotFoundException;


    public boolean saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException ;


    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException ;


    public int countRoom() throws SQLException, ClassNotFoundException ;


    public List<String> getRoomIds() throws SQLException, ClassNotFoundException ;


    public RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException ;
}
