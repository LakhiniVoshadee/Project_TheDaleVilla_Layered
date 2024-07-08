package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rent {
    private String RentID;
    private String Type;
    private int Qty;
    private String Description;
    private double UnitPrice;


}
