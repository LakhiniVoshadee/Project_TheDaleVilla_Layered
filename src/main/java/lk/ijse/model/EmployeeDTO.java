package lk.ijse.model;

public class EmployeeDTO {
    private String EmpID;
    private String Name;
    private String Type;
    private String Email;
    private String DOB;
    private String UserID;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String empID, String name, String type, String email, String DOB, String userID) {
        EmpID = empID;
        Name = name;
        Type = type;
        Email = email;
        this.DOB = DOB;
        UserID = userID;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "EmpID='" + EmpID + '\'' +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Email='" + Email + '\'' +
                ", DOB='" + DOB + '\'' +
                ", UserID='" + UserID + '\'' +
                '}';
    }
}
