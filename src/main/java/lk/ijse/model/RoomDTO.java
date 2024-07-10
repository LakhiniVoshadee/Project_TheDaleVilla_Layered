package lk.ijse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO implements Serializable {
    private String RoomID;
    private String Type;
    private String Date;
    private String customerId;
    private double UnitPrice;
    private String Qty;
}
