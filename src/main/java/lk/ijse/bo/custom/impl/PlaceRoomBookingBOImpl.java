package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PlaceRoomBookingBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.RoomBookingBO;
import lk.ijse.bo.custom.RoomDetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RoomBookingDAO;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.db.Dbconnection;
import lk.ijse.entity.RoomBooking;
import lk.ijse.entity.RoomDetails;
import lk.ijse.model.PlacedRoomBookingDTO;
import lk.ijse.model.RoomDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlaceRoomBookingBOImpl implements PlaceRoomBookingBO {

    RoomBookingDAO roomBookingDAO = (RoomBookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_BOOKING);
    RoomDetailsDAO roomDetailsDAO = (RoomDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_DETAILS);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    @Override
    public boolean orderPlaced(PlacedRoomBookingDTO placedRoomBooking) throws SQLException, ClassNotFoundException {

        RoomBooking roomBooking = new RoomBooking(placedRoomBooking.getRoomBooking().getRoomBookingID(),
                placedRoomBooking.getRoomBooking().getCusID(),
                placedRoomBooking.getRoomBooking().getDate());

        /*for (RoomDetailsDTO roomDetails : placedRoomBooking.getRoomDetails()){

        }*/

        List<RoomBooking> roomDetails = new ArrayList<>(
                (Collection) placedRoomBooking.getRoomDetails().stream().map(detail -> new RoomDetails(detail.getRoomBookingID(),detail.getRoomID(),
                        detail.getQty(),detail.getUnitPrice(),detail.getType())
                )
        );
        RoomBooking roomBooking1 =null;
        for (RoomBooking roomDetails1 : roomDetails){
            roomBooking1 = new RoomBooking(
                    roomDetails1.getRoomBookingID(),
                    roomDetails1.getCusID(),
                    roomDetails1.getDate()
            );
        }


        Connection connection = Dbconnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isOrderSaved = roomBookingDAO.save(roomBooking);
            if (isOrderSaved) {
                System.out.println("order saved");
                System.out.println(isOrderSaved);
                boolean isOrderDetailSaved = roomDetailsDAO.save(roomBooking1);
                System.out.println(isOrderDetailSaved);
                if(isOrderDetailSaved) {
                    System.out.println("orderdetailssaved");
                    boolean isRoomUpdated = roomDAO.updateRoomQty(placedRoomBooking.getRoomDetails());
                    if(isRoomUpdated) {
                        System.out.println("room update");
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;

        }catch (SQLException e){
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    }
}
