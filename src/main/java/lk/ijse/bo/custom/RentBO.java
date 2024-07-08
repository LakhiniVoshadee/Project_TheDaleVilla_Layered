package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.RentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RentBO extends SuperBO {

    public boolean deleteRent(String id) throws SQLException, ClassNotFoundException ;


    public boolean updateRent(RentDTO dto) throws SQLException, ClassNotFoundException ;


    public ResultSet generateNextRentId() throws SQLException, ClassNotFoundException;


    public boolean saveRent(RentDTO dto) throws SQLException, ClassNotFoundException ;


    public ArrayList<RentDTO> getAllRents() throws SQLException, ClassNotFoundException ;


    public int countRent() throws SQLException, ClassNotFoundException ;
}
