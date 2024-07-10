package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Room {
    private String RoomID;
    private String Type;
    private String Date;
    private String customerId;
    private double UnitPrice;
    private String Qty;

}
