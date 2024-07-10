package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    ResultSet generateNextId() throws SQLException, ClassNotFoundException ;


    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    List<String> getCusIds() throws SQLException, ClassNotFoundException;

    CustomerDTO searchCustomer(String cId) throws SQLException, ClassNotFoundException;

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

    public int countCustomer() throws SQLException, ClassNotFoundException ;
}
