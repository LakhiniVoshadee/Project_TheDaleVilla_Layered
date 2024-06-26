package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.custom.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAO
    @Override
    public  boolean delete(String id) throws SQLException {
       /* String sql = "delete from customer where CusId=?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate()>0;*/
        return cust
    }



    public static boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setString(1,customer.getCusName());
        pstm.setString(2,customer.getSex());
        pstm.setString(3,customer.getNic());
        pstm.setString(4,customer.getContact());
        pstm.setString(5,customer.getEmail());
        pstm.setString(6,customer.getCusID());

        return pstm.executeUpdate()>0;
    }

    public static String generateNextId() throws SQLException {
        String sql = "SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()){
            id = resultSet.getString(1);
            return splitId(null);
        }
        return splitId(null);

    }

    private static String splitId(String id) {
        if (id != null){
            String[] ids = id.split("Cus ");
            int CusId = Integer.parseInt(ids[1]);
            CusId++;
            return "Cus " + CusId;
        }
        return "Cus 1";

    }

    public static boolean save(Customer customer) throws SQLException {
        String sql = "insert into customer values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,customer.getCusID());
        pstm.setObject(2,customer.getCusName());
        pstm.setObject(3,customer.getSex());
        pstm.setObject(4,customer.getNic());
        pstm.setObject(5,customer.getContact());
        pstm.setObject(6,customer.getEmail());
        pstm.setObject(7, UserModel.Uid);

        return pstm.executeUpdate()>0;

    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT CusID FROM customer";

        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));

        }
        return idList;
    }

    public static Customer searchCustomer(String cId) throws SQLException {
        String sql = "select * from customer where CusId=?";

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
        return customer;
    }

    public List<Customer> getCustomer() throws SQLException {
        String sql = "select * from customer";

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
        return customerList;
    }

    public int countCustomer() throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "select count(CusID) as customer_count from customer";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()){
            int customerCount = Integer.parseInt(resultSet.getString("customer_count"));
            return customerCount;
        }
        return Integer.parseInt(null);
    }
}
