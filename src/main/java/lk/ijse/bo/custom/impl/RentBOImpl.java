
package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Rent;
import lk.ijse.model.RentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentBOImpl implements RentBO {

    RentDAO rentDAO = (RentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RENT);

    @Override
    public boolean deleteRent(String id) throws SQLException, ClassNotFoundException {
        return rentDAO.delete(id);
    }

    @Override
    public boolean updateRent(RentDTO dto) throws SQLException, ClassNotFoundException {
        return rentDAO.update(new Rent(dto.getRentID(),dto.getType(),dto.getQty(),dto.getDescription(),dto.getUnitPrice()));
    }

    @Override
    public ResultSet generateNextRentId() throws SQLException, ClassNotFoundException{
        return rentDAO.generateNextId();
    }

    @Override
    public boolean saveRent(RentDTO dto) throws SQLException, ClassNotFoundException {
        return rentDAO.save(new Rent(dto.getRentID(),dto.getType(),dto.getQty(),dto.getDescription(),dto.getUnitPrice()));
    }

    @Override
    public ArrayList<RentDTO> getAllRents() throws SQLException, ClassNotFoundException {
        ArrayList<RentDTO> allRent = new ArrayList<>();
        ArrayList<Rent>all = rentDAO.getAll();
        for (Rent rent : all){
            allRent.add(new RentDTO(rent.getRentID(),rent.getType(),rent.getQty(),rent.getDescription(),rent.getUnitPrice()));
        }
        return allRent;
    }

    @Override
    public int countRent() throws SQLException, ClassNotFoundException {
        return rentDAO.count();
    }

    @Override
    public List<String> getRentIds() throws SQLException, ClassNotFoundException {
        return rentDAO.getIds();
    }

    @Override
    public RentDTO searchRent(String id) throws SQLException, ClassNotFoundException {
        Rent rent = rentDAO.search(id);
        RentDTO rentDTO = new RentDTO(rent.getRentID(),rent.getType(),rent.getQty(),rent.getDescription(),rent.getUnitPrice());
        return rentDTO;
    }
}

