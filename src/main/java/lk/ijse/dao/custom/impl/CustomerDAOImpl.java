package lk.ijse.dao.custom.impl;

/*mport lk.ijse.thedale.controller.LoginFormController;
import lk.ijse.thedale.db.Dbconnection;
import lk.ijse.thedale.model.Customer;
import lk.ijse.thedale.model.Employee;
import lk.ijse.thedale.model.UserModel;
*/
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

 @Override
 public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "delete from customer where CusId=?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate()>0;*/
  return SQLUtil.execute("delete from customer where CusId=?");
 }


 @Override
 public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setString(1,customer.getCusName());
        pstm.setString(2,customer.getSex());
        pstm.setString(3,customer.getNic());
        pstm.setString(4,customer.getContact());
        pstm.setString(5,customer.getEmail());
        pstm.setString(6,customer.getCusID());

        return pstm.executeUpdate()>0;*/

  return SQLUtil.execute("UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=?");
 }

 @Override
 public String generateNextId() throws SQLException, ClassNotFoundException {
      /*  String sql = "SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()){
            id = resultSet.getString(1);
            return splitId(null);
        }
        return splitId(null);*/

  return SQLUtil.execute("SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1");

 }

 @Override
 public String splitId(String id) throws SQLException, ClassNotFoundException {
       /* if (id != null){
            String[] ids = id.split("Cus ");
            int CusId = Integer.parseInt(ids[1]);
            CusId++;
            return "Cus " + CusId;
        }
        return "Cus 1";*/
  return SQLUtil.execute("");

 }

 @Override
 public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
       /* String sql = "insert into customer values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,customer.getCusID());
        pstm.setObject(2,customer.getCusName());
        pstm.setObject(3,customer.getSex());
        pstm.setObject(4,customer.getNic());
        pstm.setObject(5,customer.getContact());
        pstm.setObject(6,customer.getEmail());
        pstm.setObject(7, UserModel.Uid);

        return pstm.executeUpdate()>0;*/

  return SQLUtil.execute("insert into customer values(?,?,?,?,?,?,?)");


 }

 @Override
 public List<String> getIds() throws SQLException, ClassNotFoundException {
      /*  String sql = "SELECT CusID FROM customer";

        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));

        }
        return idList;*/
  return SQLUtil.execute("SELECT CusID FROM customer");
 }

 @Override

 public Customer search(String cId) throws SQLException, ClassNotFoundException {
      /*  String sql = "select * from customer where CusId=?";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,cId);

        ResultSet resultSet = pstm.executeQuery();
        Customer customer = null;

        if (resultSet.next()){
            String cusID = resultSet.getString(1);
            String cusName = resultSet.getString(2);
            String sex = resultSet.getString(3);
            String nic = resultSet.getString(4);
            String contact = resultSet.getString(5);
            String email = resultSet.getString(6);
            String UserID = resultSet.getString(7);

            customer = new Customer(cusID,cusName,sex,nic,contact,email,UserID);
        }
        return customer;*/
  return SQLUtil.execute("select * from customer where CusId=?");
 }


 @Override
 public List<Customer> getAll() throws SQLException, ClassNotFoundException {
       /* String sql = "select * from customer";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = Dbconnection.getInstance().getConnection().prepareStatement(sql).executeQuery();

        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()){
            String cusId = resultSet.getString(1);
            String cusName = resultSet.getString(2);
            String sex = resultSet.getString(3);
            String nic = resultSet.getString(4);
            String contact = resultSet.getString(5);
            String email = resultSet.getString(6);
            String userID = resultSet.getString(7);

            Customer customer = new Customer(cusId,cusName,sex,nic,contact,email,userID);
            customerList.add(customer);
        }
        return customerList;*/
  return SQLUtil.execute("select * from customer");
 }

 @Override

 public int count() throws SQLException, ClassNotFoundException {
       /* Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "select count(CusID) as customer_count from customer";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()){
            int customerCount = Integer.parseInt(resultSet.getString("customer_count"));
            return customerCount;
        }
        return Integer.parseInt(null);
    }*/
  return SQLUtil.execute("select count(CusID) as customer_count from customer");
 }
}

