package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.RoomDetails;
import lk.ijse.model.RoomDetailsDTO;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room> {

    boolean updateRoomQty(List<RoomDetails> roomDetails) throws ClassNotFoundException, SQLException;
}
