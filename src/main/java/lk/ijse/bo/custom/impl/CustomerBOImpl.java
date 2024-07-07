package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;
import lk.ijse.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public  class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);


    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCusID(),dto.getCusName(),dto.getSex(),dto.getNic(),dto.getContact(),dto.getEmail(),dto.UserID));
    }


    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNextId();
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getCusID(),dto.getCusName(),dto.getSex(),dto.getNic(),dto.getContact(),dto.getEmail(),dto.UserID));
    }

   /* @Override
    public ArrayList<CustomerDTO> getCusIds() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCusId = new ArrayList<>();
        ArrayList<Customer> allId = customerDAO.getIds();
        for (Customer c : allId){
            allCusId.add(new CustomerDTO(c.getCusID(),c.getCusName(),c.getSex(),c.getNic(),c.getContact(),c.getEmail(),c.getUserID()));
        }
        return allCusId;
    }

    @Override
    public boolean searchCustomer(String cId) throws SQLException, ClassNotFoundException {
       return customerDAO.search(cId);
    }
*/
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer : all) {
            allCustomer.add(new CustomerDTO(customer.getCusID(),customer.getCusName(),customer.getSex(),customer.getNic(),customer.getContact(),customer.getEmail(),customer.getUserID()));
        }
        return allCustomer;
    }

    @Override
    public int countCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.count();
    }
}
