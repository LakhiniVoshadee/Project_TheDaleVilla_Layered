package lk.ijse.dao;

import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> extends SuperDAO{
    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;


    public  boolean update(T entity) throws SQLException, ClassNotFoundException;

    public ResultSet generateNextId() throws SQLException, ClassNotFoundException;

   // public   String splitId(String id) throws SQLException, ClassNotFoundException;

    public  boolean save(T entity) throws SQLException, ClassNotFoundException;

   // public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException;

  //  public boolean search(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public int count() throws SQLException, ClassNotFoundException;
}
