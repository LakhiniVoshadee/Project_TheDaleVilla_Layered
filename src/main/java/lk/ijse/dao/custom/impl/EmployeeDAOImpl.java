package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE id = ?", id);
    }


    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=? ");
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


