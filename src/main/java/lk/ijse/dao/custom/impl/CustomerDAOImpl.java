package lk.ijse.dao.custom.impl;


import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

 @Override
 public boolean delete(String id) throws SQLException, ClassNotFoundException {

  return SQLUtil.execute("delete from customer where CusId=?" ,id);
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

  return SQLUtil.execute("insert into customer values(?,?,?,?,?,?,?)",
      entity.getCusID(),
      entity.getCusName(),
      entity.getSex(),
      entity.getNic(),
      entity.getContact(),
      entity.getEmail(),
      entity.getUserID());

 }

 @Override
 public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("SELECT CusID FROM customer");
 }

 @Override
 public boolean search(String cId) throws SQLException, ClassNotFoundException {
  return SQLUtil.execute("select * from customer where CusId=?",cId);
 }


 @Override
 public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
     ResultSet rs = SQLUtil.execute("select * from customer");
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

        ResultSet resultSet = SQLUtil.execute("select count(CusID) as customer_count from customer");

        if (resultSet.next()){
            int customerCount = Integer.parseInt(resultSet.getString("customer_count"));
            return customerCount;
        }
        return Integer.parseInt(null);
    }

 }


