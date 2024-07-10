package lk.ijse.tdm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentTM {
    private String RentID;
    private int Qty;
    private String Description;
    private String Type;
    private double UnitPrice;


}
