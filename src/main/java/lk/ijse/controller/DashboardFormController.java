package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private JFXButton btnBooking;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnFood;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnRenting;

    @FXML
    private JFXButton btnRoom;

    @FXML
    private JFXButton btnServices;

    @FXML
    private Pane pagingPane;

    @FXML
    void btnBookingOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane,"room_booking_form.fxml");

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
       Navigation.switchPaging(pagingPane,"customer_form.fxml");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
      Navigation.switchPaging(pagingPane,"employee_form.fxml");
    }

   /* @FXML
    void btnFoodOnAction(ActionEvent event) {

    }
*/
    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
       Navigation.switchPaging(pagingPane,"home_form.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
       btnLogOut.getScene().getWindow().hide();
       Navigation.changeState("view/login_form.fxml","Login Form");

    }

    @FXML
    void btnRentingOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "rent_booking_form.fxml");

    }

    @FXML
    void btnRoomOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane,"room_form.fxml");

    }

    @FXML
    void btnServicesOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane,"rent_form.fxml");

    }

}
