package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private String cusID;
    private String cusName;
    private String sex;
    private String nic;
    private String contact;
    private String email;
    public String UserID;

}
