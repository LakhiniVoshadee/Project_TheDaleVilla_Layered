package lk.ijse.entity;

public class Room {
    private String RoomID;
    private String Type;
    private String Date;
    private String customerId;
    // private String QtyOnHand;
    private double UnitPrice;
    private String Qty;

    public Room() {

    }

    public Room(String roomID, String type, String date, String customerId, double unitPrice, String qty) {
        RoomID = roomID;
        Type = type;
        Date = date;
        this.customerId = customerId;
        UnitPrice = unitPrice;
        Qty = qty;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomID='" + RoomID + '\'' +
                ", Type='" + Type + '\'' +
                ", Date='" + Date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", Qty='" + Qty + '\'' +
                '}';
    }
}
