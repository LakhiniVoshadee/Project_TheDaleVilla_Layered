package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminBOImpl implements AdminBO {

    AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean verifyCredentials(String UserName, String Password) throws SQLException , ClassNotFoundException{
       ResultSet resultSet = adminDAO.verifyCredentials(UserName,Password);
       String pw = "";
       if (resultSet.next()){
           pw = resultSet.getString(1);
           if (pw.equals(Password)){
               return true;
           }
       }
       return false;
    }




}
