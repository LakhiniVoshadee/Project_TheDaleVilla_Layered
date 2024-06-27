package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        /*String sql = "Select EmpID from employee order by EmpID desc limit 1 ";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()) {
            id = resultSet.getString(1);
            return splitId(id);
        }
        return splitId(null);*/

        ResultSet rst = SQLUtil.execute("Select EmpID from employee order by EmpID desc limit 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newEmpID = Integer.parseInt(id.replace("E00-", "")) + 1;
            return String.format("E00-%s", newEmpID);
        } else {
            return "E00-001";
        }
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

    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
       /* String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getEmpID());
        pstm.setObject(2, employee.getName());
        pstm.setObject(3, employee.getType());
        pstm.setObject(4, employee.getEmail());
        pstm.setObject(5, employee.getDOB());
        pstm.setObject(6, employee.getUserID());

        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?)");

    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE employee SET Name = ?,Type = ?,DOB = ?,Email = ?,UserID = ? WHERE EmpId = ? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getName());
        pstm.setObject(2, employee.getType());
        pstm.setObject(3, employee.getDOB());
        pstm.setObject(4, employee.getEmail());
        pstm.setObject(5, employee.getEmpID());
        // pstm.setObject(6, employee.getUserID());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE employee SET Name = ?,Type = ?,DOB = ?,Email = ?,UserID = ? WHERE EmpId = ?");
    }


    /*  public List<Employee> getEmployee() throws SQLException, ClassNotFoundException {
          String sql = "SELECT * FROM employee";
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
          return employeeList;
      }
  */
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "DELETE FROM employee WHERE EmpID = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("DELETE FROM employee WHERE EmpID = ?");
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
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
        return employeeList;
    }*/
        return SQLUtil.execute("SELECT * FROM employee");
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
