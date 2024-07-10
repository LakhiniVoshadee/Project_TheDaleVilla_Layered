package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Employee;
import lk.ijse.model.RoomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE EmpID = ?", id);
    }


    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET Name = ?,Type = ?,DOB = ?,Email = ?,UserID = ? WHERE EmpId = ? ",
                entity.getName(),
                entity.getType(),
                entity.getDOB(),
                entity.getEmail(),
                entity.getUserID(),
                entity.getEmpID()
        );
    }


    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT EmpID from employee order by EmpID desc limit 1");
    }


    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?)",
                entity.getEmpID(),
                entity.getName(),
                entity.getType(),
                entity.getEmail(),
                entity.getDOB(),
                entity.getUserID());
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

   /* @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public RoomDTO search(String id) throws SQLException, ClassNotFoundException {
        return false;
    }*/


    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
      ResultSet resultSet= SQLUtil.execute("SELECT * FROM employee");
      ArrayList<Employee> allEmployees = new ArrayList<>();

      while (resultSet.next()) {
          Employee employee = new Employee(
                  resultSet.getString(1),
                  resultSet.getString(2),
                  resultSet.getString(3),
                  resultSet.getString(4),
                  resultSet.getString(5),
                  resultSet.getString(6)
          );
          allEmployees.add(employee);
      }
      return allEmployees;
    }



    @Override
    public int count() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.execute("SELECT count(EmpID) as employee_count from employee");

        if (resultSet.next()){
            int customerCount = Integer.parseInt(resultSet.getString("employee_count"));
            return customerCount;
        }
        return Integer.parseInt(null);
    }
    }


