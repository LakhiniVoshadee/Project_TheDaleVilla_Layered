package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Room;
import lk.ijse.model.RoomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);


    @Override
    public boolean deleteRoom(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }

    @Override
    public boolean updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.update(new Room(dto.getRoomID(),dto.getType(),dto.getDate(),dto.getCustomerId(),dto.getUnitPrice(),dto.getQty()));
    }

    @Override
    public ResultSet generateNextRoomId() throws SQLException, ClassNotFoundException {
        return roomDAO.generateNextId();
    }

    @Override
    public boolean saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoomID(),dto.getType(),dto.getDate(),dto.getCustomerId(),dto.getUnitPrice(),dto.getQty()));
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<RoomDTO> allRooms = new ArrayList<>();
        ArrayList<Room> all = roomDAO.getAll();
        for (Room room : all) {
            allRooms.add(new RoomDTO(room.getRoomID(),room.getType(),room.getDate(),room.getCustomerId(),room.getUnitPrice(),room.getQty()));
        }
        return allRooms;
    }

    @Override
    public int countRoom() throws SQLException, ClassNotFoundException {
        return roomDAO.count();
    }
}
