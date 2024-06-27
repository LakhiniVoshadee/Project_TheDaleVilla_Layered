package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;
import lk.ijse.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public  class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "delete from customer where CusId=?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate()>0;*/
        return customerDAO.delete(id);
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    /*@Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }
*/



    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        /*String sql = "UPDATE customer SET Name = ?, sex = ?, Nic =?, Contact =?, Email =? WHERE CusId=? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setString(1,customer.getCusName());
        pstm.setString(2,customer.getSex());
        pstm.setString(3,customer.getNic());
        pstm.setString(4,customer.getContact());
        pstm.setString(5,customer.getEmail());
        pstm.setString(6,customer.getCusID());

        return pstm.executeUpdate()>0;*/
        return customerDAO.update(new Customer(dto.getCusID(), dto.getCusName(), dto.getSex(), dto.getNic(), dto.getContact(), dto.getEmail(), dto.getEmail()));
    }


    public String generateNextId() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()){
            id = resultSet.getString(1);
            return splitId(null);
        }
        return splitId(null);*/
        return customerDAO.generateNextId();

    }

   /* @Override
    public String splitId(String id) {
        String result = "Cus 1";
        if (id != null) {
            String[] ids = id.split("Cus ");
            int CusId = Integer.parseInt(ids[1]);
            CusId++;
            result = "Cus " + CusId;
        }

        return result;
    }*/


  
/*

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }
*/


    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        /*String sql = "insert into customer values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,customer.getCusID());
        pstm.setObject(2,customer.getCusName());
        pstm.setObject(3,customer.getSex());
        pstm.setObject(4,customer.getNic());
        pstm.setObject(5,customer.getContact());
        pstm.setObject(6,customer.getEmail());
        pstm.setObject(7, UserModel.Uid);

        return pstm.executeUpdate()>0;*/
        return customerDAO.save(new Customer(dto.getCusID(), dto.getCusName(), dto.getSex(), dto.getNic(), dto.getContact(), dto.getEmail(), dto.UserID));

    }

    @Override
    public ArrayList<CustomerDTO> getIds() throws SQLException, ClassNotFoundException {
      /*  String sql = "SELECT CusID FROM customer";

        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));

        }
        return idList;*/
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = (ArrayList<Customer>) customerDAO.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCusID(), c.getCusName(), c.getSex(), c.getNic(), c.getContact(), c.getEmail(), c.getUserID()));
        }
        return allCustomers;

    }

    @Override
    public CustomerDTO searchCustomer(String cId) throws SQLException {
        return null;
    }

    @Override
    public boolean search(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       /* String sql = "select * from customer where CusId=?";

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
        return customerDAO.search(String.valueOf(new Customer(dto.getCusID(), dto.getCusName(), dto.getSex(), dto.getNic(), dto.getContact(), dto.getEmail(), dto.UserID)));

    }

    public ArrayList<CustomerDTO> getCustomer() throws SQLException, ClassNotFoundException {
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
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = (ArrayList<Customer>) customerDAO.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCusID(), c.getCusName(), c.getSex(), c.getNic(), c.getContact(), c.getEmail(), c.getUserID()));
        }
        return allCustomers;
    }

    @Override
    public int countCustomer() throws SQLException {
        return 0;
    }

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
        return customerDAO.count();
    }
}
