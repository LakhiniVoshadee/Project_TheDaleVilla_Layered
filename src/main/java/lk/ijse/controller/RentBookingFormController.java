package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class RentBookingFormController {

    @FXML
    private JFXButton btnAdToCart;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXComboBox<?> cmbCId;

    @FXML
    private JFXComboBox<?> cmbRentId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colRentId;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblBDate;

    @FXML
    private Label lblBId;

    @FXML
    private Label lblCName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblQtyOHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<?> tblRentBookingCart;

    @FXML
    private TextField txtQty;

    @FXML
    void addToCartOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbRentOnAction(ActionEvent event) {

    }

}
