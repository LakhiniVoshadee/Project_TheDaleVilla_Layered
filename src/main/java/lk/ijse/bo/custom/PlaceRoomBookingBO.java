package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.PlacedRoomBookingDTO;

import java.sql.SQLException;

public interface PlaceRoomBookingBO extends SuperBO {

    boolean orderPlaced(PlacedRoomBookingDTO placedRoomBooking) throws SQLException, ClassNotFoundException;

}
