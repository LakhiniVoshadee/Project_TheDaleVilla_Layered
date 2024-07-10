package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDTO implements Serializable {
    private String RentID;
    private int Qty;
    private String Description;
    private String Type;
    private double UnitPrice;
}
