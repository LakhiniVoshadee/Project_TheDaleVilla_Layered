package lk.ijse.model;

public class AdminDTO {
    private String UserId;
    private String Password;
    private String UserName;
    private String Mob_num;

    public AdminDTO() {
    }

    public AdminDTO(String userId, String password, String userName, String mob_num) {
        UserId = userId;
        Password = password;
        UserName = userName;
        Mob_num = mob_num;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMob_num() {
        return Mob_num;
    }

    public void setMob_num(String mob_num) {
        Mob_num = mob_num;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Mob_num='" + Mob_num + '\'' +
                '}';
    }
}
