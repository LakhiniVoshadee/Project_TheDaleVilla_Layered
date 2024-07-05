package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String cusID;
    private String cusName;
    private String sex;
    private String nic;
    private String contact;
    private String email;
    public String UserID;


}

