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
        return null;
    }

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
/*
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
                entity.getDOB());


    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE employee SET Name = ?,Type = ?,DOB = ?,Email = ?,UserID = ? WHERE EmpId = ?",
                entity.getName(),
                entity.getType(),
                entity.getDOB(),
                entity.getEmail(),
                entity.getEmpID());
    }



    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE EmpID = ?",id);
    }

*//*
    @Override
    public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM employee");
    }*//*


  *//*  @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM employee WHERE EmpID = ?",id);
    }
*//*
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM employee");
        ArrayList<Employee> allEmployees = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            allEmployees.add(employee);
        }
        return allEmployees;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.execute("SELECT count(EmpID) as employee_count from employee");

       if (resultSet.next()) {
           int employeeCount = Integer.parseInt(resultSet.getString("employee_count"));
           return employeeCount;
       }
       return Integer.parseInt(null);
    }*/
}
