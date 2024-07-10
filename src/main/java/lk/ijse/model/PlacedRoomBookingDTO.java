package lk.ijse.model;


import lk.ijse.entity.RoomBooking;
import lk.ijse.entity.RoomDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlacedRoomBookingDTO {
    private RoomBooking roomBooking;
    private List<RoomDetails>roomDetails;

}
