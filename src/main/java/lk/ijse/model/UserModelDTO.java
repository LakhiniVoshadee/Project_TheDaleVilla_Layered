package lk.ijse.model;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.controller.LoginFormController;
import lk.ijse.db.Dbconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModelDTO {
    public static String Uid;
    public static void verifyCredentials(String UserId, String Password, AnchorPane rootNode) throws SQLException, IOException, ClassNotFoundException {
        Uid = UserId;
        String sql = "select UserId,Password from admin where UserId=?";

        Dbconnection instance = Dbconnection.getInstance();
        Connection connection = instance.getConnection();

        // String sql = "select Password from admin where UserId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1, UserId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String psw = resultSet.getString(2);
            if (psw.equals(Password)) {
                rootNode.getScene().getWindow().hide();
                new LoginFormController().gotodashboard();

            } else {
                new Alert(Alert.AlertType.ERROR, "Wrong Password").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, " Password").show();
        }

    }

}
