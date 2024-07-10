package lk.ijse.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTM {
    private String RoomID;
    private String Type;
    private String Date;
    private Double UnitPrice;
    private String Qty;
    private String customerId;
}
