package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RoomBookingDTO implements Serializable {
    private String RoomBookingID;
    private String cusID;
    private Date date;


}
