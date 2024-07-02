package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.entity.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDAOImpl implements RentDAO {

    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
      /*  String sql = "SELECT RentID FROM Rent order by RentID desc LIMIT 1";
        Connection connection = Dbconnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String id = null;
        if (resultSet.next()){
            id = resultSet.getString(1);
            return splitId(id);
        }
        return splitId(null);*/

        return SQLUtil.execute("SELECT RentID FROM Rent order by RentID desc LIMIT 1");


    }

  /*  private static String splitId(String id) {
        if (id != null){
            String[] split = id.split("Rent ");
            int RentID = Integer.parseInt(split[1]);
            RentID++;
            return "Rent " + RentID;
        }
        return "Rent 1";
    }*/

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "DELETE FROM Rent WHERE RentID = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() >0;*/

        return SQLUtil.execute("DELETE FROM Rent WHERE RentID = ?");
    }

    @Override

    public  boolean save(Rent entity) throws SQLException, ClassNotFoundException {
      /*  String sql = "INSERT INTO Rent VALUES(?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,rent.getRentID());
        pstm.setObject(2,rent.getQty());
        pstm.setObject(3,rent.getDescription());
        pstm.setObject(4,rent.getType());
        //  pstm.setObject(5,rent.getQtyOnHand());
        pstm.setObject(5,rent.getUnitPrice());

        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO Rent VALUES(?,?,?,?,?)",
        entity.getRentID(),
        entity.getQty(),
        entity.getDescription(),
        entity.getType(),
        entity.getUnitPrice());
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean update(Rent entity) throws SQLException, ClassNotFoundException {
       /* String sql = "Update Rent set Type = ?, Qty = ?, Description = ? , UnitPrice = ? where RentID = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,rent.getType());
        pstm.setObject(2,rent.getQty());
        pstm.setObject(3,rent.getDescription());
        // pstm.setObject(4,rent.getQtyOnHand());
        pstm.setObject(4,rent.getUnitPrice());
        pstm.setObject(5,rent.getRentID());

        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("Update Rent set Type = ?, Qty = ?, Description = ? , UnitPrice = ? where RentID = ?",
                entity.getType(),
                entity.getQty(),
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getRentID());
    }
   @Override
    public  boolean search(String rentId) throws SQLException, ClassNotFoundException {
        /*String sql = "select * from Rent where RentID = ?";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);


        pstm.setObject(1,rentId);
        ResultSet resultSet = pstm.executeQuery();
        Rent rent = null;

        if (resultSet.next()){
            String id = resultSet.getString(1);
            int qty = Integer.parseInt(resultSet.getString(2));
            String description = resultSet.getString(3);
            String type = resultSet.getString(4);
            // String qtyOnHand = resultSet.getString(5);
            double unitPrice = resultSet.getDouble(6);

            rent = new Rent(id,type,qty,description,unitPrice);

        }
        return rent;*/
       return SQLUtil.execute("select * from Rent where RentID = ?");


    }

    @Override
    public ArrayList<Rent> getAll() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM Rent";
        ResultSet resultSet = Dbconnection.getInstance().getConnection().prepareStatement(sql).executeQuery();
        List<Rent> rentList = new ArrayList<>();
        while (resultSet.next()){
            String id = resultSet.getString(1);
            int qty = Integer.parseInt(resultSet.getString(2));
            String description = resultSet.getString(3);
            String type = resultSet.getString(4);
            // String qtyOnHand = resultSet.getString(5);
            double unitPrice = resultSet.getDouble(5);

            Rent rent = new Rent(id,type,qty,description,unitPrice);
            rentList.add(rent);

        }
        return rentList;*/
        ArrayList<Rent> rents = new ArrayList<>();
        ResultSet rs = SQLUtil.execute("select * from Rent");
        while (rs.next()) {
            Rent rent = new Rent(
                    rs.getString("RentId"),
                    rs.getString("type"),
                    rs.getInt("qty"),
                    rs.getString("description"),
                    rs.getDouble("unitPrice")
            );
            rents.add(rent);
        }
        return rents;
    }

    @Override

    public int count() throws SQLException, ClassNotFoundException {
       /* Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "select count(RentID) as rent_count from Rent";

        PreparedStatement pstm = connection.prepareStatement(sql);*/
        ResultSet resultSet = SQLUtil.execute("select count(RentID) as rent_count from Rent");

        if (resultSet.next()){
            int rentCount = Integer.parseInt(resultSet.getString(1));
            return rentCount;
        }
        return Integer.parseInt(null);
    }
}



