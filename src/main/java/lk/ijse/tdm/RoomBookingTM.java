package lk.ijse.tdm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomBookingTM {
    private String RoomID;
    private String Type;
    private double UnitPrice;
    private String QtyOnHand;
    private int Qty;
    private double Total;
    private JFXButton btnRemove;
}
