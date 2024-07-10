package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlacedRoomBooking {
    private RoomBooking roomBooking;
    private List<RoomDetails>roomDetails;

}
