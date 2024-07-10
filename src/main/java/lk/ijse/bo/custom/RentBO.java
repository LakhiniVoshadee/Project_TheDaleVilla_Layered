package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.RentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RentBO extends SuperBO {

    public boolean deleteRent(String id) throws SQLException, ClassNotFoundException ;


    public boolean updateRent(RentDTO dto) throws SQLException, ClassNotFoundException ;


    public ResultSet generateNextRentId() throws SQLException, ClassNotFoundException;


    public boolean saveRent(RentDTO dto) throws SQLException, ClassNotFoundException ;


    public ArrayList<RentDTO> getAllRents() throws SQLException, ClassNotFoundException ;


    public int countRent() throws SQLException, ClassNotFoundException ;


    public List<String> getRentIds() throws SQLException, ClassNotFoundException ;


    public RentDTO searchRent(String id) throws SQLException, ClassNotFoundException ;
}
