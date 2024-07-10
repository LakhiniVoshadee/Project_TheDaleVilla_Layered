

package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDAOImpl implements RentDAO {


    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM rent WHERE RentID = ?",id);
    }

    @Override
    public boolean update(Rent entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE rent set Type = ?, Qty = ?, Description = ? , UnitPrice = ? where RentID = ?",
                entity.getType(),
                entity.getQty(),
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getRentID());
    }

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT RentID FROM rent order by RentID desc LIMIT 1");
    }

    @Override
    public boolean save(Rent entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO rent VALUES(?,?,?,?,?)",
                entity.getRentID(),
                entity.getQty(),
                entity.getDescription(),
                entity.getType(),
                entity.getUnitPrice());
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
       ResultSet rs = SQLUtil.execute("SELECT RentID FROM rent");
       List<String> list = new ArrayList<>();
       while (rs.next()) {
           list.add(rs.getString(1));
       }
       return list;
    }

    @Override
    public Rent search(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT RentID FROM rent WHERE RentID = ?",id);
    }

    @Override
    public ArrayList<Rent> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM rent");
        ArrayList<Rent> rents = new ArrayList<>();

        while (resultSet.next()) {
            Rent rent = new Rent(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            rents.add(rent);
        }
        return rents;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT count(RentID) as rent_count from Rent");

        if (resultSet.next()){
            int rentCount = Integer.parseInt(resultSet.getString("rent_count"));
            return rentCount;
        }
        return Integer.parseInt(null);
    }
}





