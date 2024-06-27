package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.AdminDTO;
import lk.ijse.model.UserModelDTO;
/*import lk.ijse.thedale.model.Admin;
import lk.ijse.thedale.model.UserModel;
import lk.ijse.thedale.util.Navigation;*/

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Hyperlink hyperForgotPassword;

    @FXML
    private Hyperlink hyperSignUp;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public TextField txtUserId;

    public String userId;

    public String tel;

    AdminDTO adminDTO = new AdminDTO();

    private static LoginFormController controller;

    public LoginFormController(){
        controller = this;

    }

    public static LoginFormController getInstance(){
        return controller;
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        userId = txtUserId.getText();
        String password = txtPassword.getText();

        try {
            UserModelDTO.verifyCredentials(userId, password, rootNode);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Try again").show();
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void linkForgotPwOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/forgetPassword_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setTitle("ForgotPassword Form");

        stage.show();
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

    public void gotodashboard() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("DashBoard Form");
        stage.show();
    }
}