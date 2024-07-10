package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoomDetailsDTO implements Serializable {
    private String RoomBookingID;
    private String RoomID;
    private int Qty;
    private double UnitPrice;
    private String Type;
}
