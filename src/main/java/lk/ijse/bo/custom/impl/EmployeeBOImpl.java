package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);


    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }


    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getEmail(),dto.getDOB(),dto.getUserID()));
    }



    @Override
    public ResultSet generateNextEmpId() throws SQLException, ClassNotFoundException {
        return employeeDAO.generateNextId();
    }



    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getEmail(),dto.getDOB(),dto.getUserID()));
    }


    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException {
       ArrayList<EmployeeDTO> allEmployee = new ArrayList<>();
       ArrayList<Employee> employees = employeeDAO.getAll();
       for (Employee employee : employees) {
           allEmployee.add(new EmployeeDTO(employee.getEmpID(),employee.getName(),employee.getType(),employee.getEmail(),employee.getDOB(),employee.getUserID()));
       }
       return allEmployee;
    }



    @Override
    public int countEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.count();
    }
}
