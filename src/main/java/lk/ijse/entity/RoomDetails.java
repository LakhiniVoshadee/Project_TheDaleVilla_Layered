package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoomDetails {
    private String RoomBookingID;
    private String RoomID;
    private int Qty;
    private double UnitPrice;
    private String Type;
}
