package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    ResultSet generateNextIdEmployee() throws SQLException, ClassNotFoundException;

    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateEmployee(EmployeeDTO dto ) throws SQLException, ClassNotFoundException ;

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    //public ArrayList<CustomerDTO> getIds() throws SQLException, ClassNotFoundException ;

   // public boolean searchEmployee(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException;

    int countEmployee() throws SQLException, ClassNotFoundException;
}
