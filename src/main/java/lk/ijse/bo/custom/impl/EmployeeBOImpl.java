package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.db.Dbconnection;
import lk.ijse.entity.Employee;
import lk.ijse.model.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public  String generateNextEmpId() throws SQLException, ClassNotFoundException {
       /* String sql = "Select EmpID from employee order by EmpID desc limit 1 ";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()) {
            id = resultSet.getString(1);
            return splitId(id);
        }
        return splitId(null);*/
        return employeeDAO.generateNextId();

    }

   /* private static String splitId(String id) {
        if (id != null) {
            String[] split = id.split("Emp ");
            int EmpId = Integer.parseInt(split[1]);
            EmpId++;
            return "Emp " + EmpId;
        }
        return "Emp 1";
    }*/

    public  boolean saveEmployee(Employee dto) throws SQLException, ClassNotFoundException {
        /*String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getEmpID());
        pstm.setObject(2, employee.getName());
        pstm.setObject(3, employee.getType());
        pstm.setObject(4, employee.getEmail());
        pstm.setObject(5, employee.getDOB());
        pstm.setObject(6, employee.getUserID());

        return pstm.executeUpdate() > 0;*/
        return employeeDAO.save(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getEmail(),dto.getDOB()));

    }

    public  boolean updateEmployee(Employee dto) throws SQLException, ClassNotFoundException {
        /*String sql = "UPDATE employee SET Name = ?,Type = ?,DOB = ?,Email = ?,UserID = ? WHERE EmpId = ? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getName());
        pstm.setObject(2, employee.getType());
        pstm.setObject(3, employee.getDOB());
        pstm.setObject(4, employee.getEmail());
        pstm.setObject(5, employee.getEmpID());
        // pstm.setObject(6, employee.getUserID());

        return pstm.executeUpdate() > 0;*/

        return employeeDAO.update(new Employee(dto.getEmpID(),dto.getName(),dto.getType(),dto.getDOB(),dto.getEmail()));


    }




    public List<EmployeeDTO> getEmployee() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM employee";
        ResultSet resultSet = Dbconnection.getInstance().getConnection().prepareStatement(sql).executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while (resultSet.next()) {
            employeeList.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)

            ));
        }
        return employeeList;*/

        ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
        ArrayList<Employee> all = (ArrayList<Employee>) employeeDAO.getAll();
        for (Employee employee : all) {
            allEmployees.add(new EmployeeDTO(employee.getEmpID(),employee.getName(),employee.getType(),employee.getDOB(),employee.getEmail()));
        }
        return allEmployees;
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
      /*  String sql = "DELETE FROM employee WHERE EmpID = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return employeeDAO.delete(id);
    }

    @Override
    public List<String> getEmpId() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
