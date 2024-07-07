package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
   AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN);
    @FXML
    private JFXButton btnLogin;

    @FXML
    private Hyperlink hyperSignUp;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserId;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String userId = txtUserId.getText();
        String password = txtPassword.getText();
        boolean b = adminBO.verifyCredentials(userId,password);

        if (b){
            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/home_form.fxml"));
            Scene scene = new Scene(rootNode);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dashboard Form");
            stage.show();
        }else {
            System.out.println("failed");
        }
    }

    @FXML
    void linkSignUpOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signup_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SignUp Form");
        stage.show();
    }

}
