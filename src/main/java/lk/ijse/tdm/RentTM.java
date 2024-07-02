package lk.ijse.tdm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentTM {
    private String RentID;
    private String Type;
    private int Qty;
    private String Description;
    private double UnitPrice;


}
