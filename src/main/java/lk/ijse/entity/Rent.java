package lk.ijse.entity;

public class Rent {
    private String RentID;
    private String Type;
    private int Qty;
    private String Description;
    // private String QtyOnHand;
    private double UnitPrice;

    public Rent() {
    }

    public Rent(String rentID, String type, int qty, String description, double unitPrice) {
        RentID = rentID;
        Type = type;
        Qty = qty;
        Description = description;
        UnitPrice = unitPrice;
    }

    public String getRentID() {
        return RentID;
    }

    public void setRentID(String rentID) {
        RentID = rentID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "RentID='" + RentID + '\'' +
                ", Type='" + Type + '\'' +
                ", Qty=" + Qty +
                ", Description='" + Description + '\'' +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
