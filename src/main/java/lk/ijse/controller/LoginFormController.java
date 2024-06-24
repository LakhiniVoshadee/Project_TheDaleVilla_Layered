package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {

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
    void btnLoginOnAction(ActionEvent event) {

    }

    @FXML
    void linkSignUpOnAction(ActionEvent event) {

    }

}
