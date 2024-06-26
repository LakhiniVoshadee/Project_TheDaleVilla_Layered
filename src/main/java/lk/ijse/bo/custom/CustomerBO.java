package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {
    public  boolean delete(String id) throws SQLException ;



    public  boolean update(CustomerDTO dto) throws SQLException ;

    public  String generateNextId() throws SQLException ;

     String splitId(String id) ;

    public  boolean save(CustomerDTO dto) throws SQLException ;

    public  List<String> getIds() throws SQLException ;

    public  CustomerDTO searchCustomer(String cId) throws SQLException ;

    public List<CustomerDTO> getCustomer() throws SQLException ;

    public int countCustomer() throws SQLException ;
}
