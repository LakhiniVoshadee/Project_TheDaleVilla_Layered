package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {
    public  boolean delete(String id) throws SQLException, ClassNotFoundException;



    public  boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public  String generateNextId() throws SQLException, ClassNotFoundException;

     String splitId(String id) ;

    public  boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<CustomerDTO> getIds() throws SQLException, ClassNotFoundException;

    public  CustomerDTO searchCustomer(String cId) throws SQLException ;

    boolean search(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public List<CustomerDTO> getCustomer() throws SQLException, ClassNotFoundException;

    public int countCustomer() throws SQLException ;
}
