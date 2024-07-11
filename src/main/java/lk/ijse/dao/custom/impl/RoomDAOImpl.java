
package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM room WHERE RoomID = ?", id);
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE room Set Type = ?, Date = ?  , UnitPrice = ?, Qty = ? , CusID = ? where RoomID = ?",
                entity.getType(),
                entity.getDate(),
                entity.getUnitPrice(),
                entity.getQty(),
                entity.getCustomerId(),
                entity.getRoomID()
                );
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT RoomID from room order by RoomID desc limit 1");
    }

    @Override
    public boolean save(Room entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT into room values(?,?,?,?,?,?)",
                entity.getRoomID(),
                entity.getType(),
                entity.getDate(),
                entity.getUnitPrice(),
                entity.getQty(),
                entity.getCustomerId()
                );
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT RoomID FROM room");
        List<String> ids = new ArrayList<>();
        while (rst.next()) {
            ids.add(rst.getString(1));
        }
        return ids;
    }

    @Override
    public Room search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * from room where RoomID=?",id);
        Room room = null;
        if (rst.next()) {
            String RoomID = rst.getString(1);
            String Type = rst.getString(2);
            String Date = rst.getString(3);
            Double UnitPrice = Double.valueOf(rst.getString(4));
            String Qty = rst.getString(5);
            String CustomerId = rst.getString(6);
            room = new Room(RoomID,Type,Date,UnitPrice,Qty,CustomerId);
        }
        return room;
    }

   /* @Override
    public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("select RoomID from room");
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM room WHERE RoomID = ?", id);
    }*/

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
       ResultSet rs = SQLUtil.execute("SELECT * from room");
       ArrayList<Room> rooms = new ArrayList<>();

       while (rs.next()) {
           Room room = new Room(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                   rs.getDouble(4),
                   rs.getString(5),
                rs.getString(6)
           );
           rooms.add(room);
       }
       return rooms;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        ResultSet resultSet  = SQLUtil.execute("SELECT count(RoomID) as room_count from room");

        if (resultSet.next()) {
            int roomCount = Integer.parseInt(resultSet.getString("room_count"));
            return roomCount;
        }

        return Integer.parseInt(null);
    }
}

