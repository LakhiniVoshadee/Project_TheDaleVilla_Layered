package lk.ijse.tdm;

public class CustomerTM {
    private String cusID;
    private String cusName;
    private String sex;
    private String nic;
    private String contact;
    private String email;
    public String UserID;

    public CustomerTM() {
    }

    public CustomerTM(String cusID, String cusName, String sex, String nic, String contact, String email, String userID) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.sex = sex;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        UserID = userID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "cusID='" + cusID + '\'' +
                ", cusName='" + cusName + '\'' +
                ", sex='" + sex + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", UserID='" + UserID + '\'' +
                '}';
    }
}
