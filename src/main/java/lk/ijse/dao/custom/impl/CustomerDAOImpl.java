package lk.ijse.dao.custom.impl;


import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

 @Override
 public boolean delete(String id) throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("DELETE from customer where CusId=?" ,id);
 }


 @Override
 public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=?",
          entity.getCusName(),
          entity.getSex(),
          entity.getNic(),
          entity.getContact(),
          entity.getEmail(),
          entity.getCusID());
 }

 @Override
 public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1");

 }

 @Override
 public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("INSERT into customer values(?,?,?,?,?,?,?)",
      entity.getCusID(),
      entity.getCusName(),
      entity.getSex(),
      entity.getNic(),
      entity.getContact(),
      entity.getEmail(),
      entity.getUserID());

 }

 @Override
 public List<String> getIds() throws SQLException, ClassNotFoundException {
  ResultSet rst = SQLUtil.execute("SELECT CusID FROM customer");
  List<String> ids = new ArrayList<>();
  while (rst.next()) {
      ids.add(rst.getString(1));
  }
  return ids;
 }

 @Override
 public Customer search(String cId) throws SQLException, ClassNotFoundException {
  ResultSet rst = SQLUtil.execute("SELECT * from customer where CusId=?",cId);
  Customer customer = null;
  if (rst.next()) {
      String cusId = rst.getString(1);
      String cusName = rst.getString(2);
      String sex = rst.getString(3);
      String nic = rst.getString(4);
      String contact = rst.getString(5);
      String email = rst.getString(6);
      String userID = rst.getString(7);
  }
  return customer;
 }


 @Override
 public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
     ResultSet rs = SQLUtil.execute("SELECT * from customer");
     ArrayList<Customer> allCustomers = new ArrayList<>();

  while (rs.next()) {
    Customer customer = new Customer(
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7)
    );
    allCustomers.add(customer);
  }
  return allCustomers;

 }

 @Override
 public int count() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT count(CusID) as customer_count from customer");

        if (resultSet.next()){
            int customerCount = Integer.parseInt(resultSet.getString("customer_count"));
            return customerCount;
        }
        return Integer.parseInt(null);
    }

 }


