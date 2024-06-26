package lk.ijse.dao.custom;

import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;


    public  boolean update(T entity) throws SQLException, ClassNotFoundException;

    public  String generateNextId() throws SQLException, ClassNotFoundException;

    public   String splitId(String id) throws SQLException, ClassNotFoundException;

    public  boolean save(T entity) throws SQLException, ClassNotFoundException;

    public  List<String> getIds() throws SQLException, ClassNotFoundException;

    public  T search(String id) throws SQLException, ClassNotFoundException;

    public List<T> getAll() throws SQLException, ClassNotFoundException;

    public int count() throws SQLException, ClassNotFoundException;
}
