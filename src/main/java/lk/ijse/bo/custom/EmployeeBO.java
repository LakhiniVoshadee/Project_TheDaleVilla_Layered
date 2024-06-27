package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    public String generateNextEmpId() throws SQLException, ClassNotFoundException ;




    public boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException ;


    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException ;




    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException ;


    public List<String> getEmpId() throws SQLException, ClassNotFoundException ;
}
