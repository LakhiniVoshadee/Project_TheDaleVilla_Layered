package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;
import lk.ijse.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ResultSet generateNextEmpId() throws SQLException, ClassNotFoundException {

        return employeeDAO.generateNextId();

    }


 @Override
    public  boolean saveEmployee(Employee dto) throws SQLException, ClassNotFoundException {

        return employeeDAO.save(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getEmail(),dto.getDOB()));

    }
 @Override
    public  boolean updateEmployee(Employee dto) throws SQLException, ClassNotFoundException {

        return employeeDAO.update(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getDOB(),dto.getEmail()));


    }




    @Override
    public ArrayList<EmployeeDTO> getEmployee() throws SQLException, ClassNotFoundException {


        ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
        ArrayList<Employee> all =  employeeDAO.getAll();
        for (Employee employee : all) {
            allEmployees.add(new EmployeeDTO(employee.getEmpID(),employee.getName(),employee.getType(),employee.getDOB(),employee.getEmail()));
        }
        return allEmployees;
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public List<String> getEmpId() throws SQLException, ClassNotFoundException {
       ArrayList<EmployeeDTO>allEmpId = new ArrayList<>();
       ArrayList<Customer> allId = employeeDAO.getIds();
       for (Employee employee : allId) {
           allEmpId.add(new EmployeeDTO(employee.getEmpID(),employee.getName(),employee.getType(),employee.getDOB(),employee.getEmail()));
       }
        return allEmpId;
    }
}
