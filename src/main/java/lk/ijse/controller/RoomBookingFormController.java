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

public class RoomBookingFormController {

    @FXML
    private JFXButton btnAdToCart;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnPrintBill;

    @FXML
    private JFXComboBox<?> cmbCId;

    @FXML
    private JFXComboBox<?> cmbRoomId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colQtOnHand;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colRmId;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colUnPrice;

    @FXML
    private Label lblBDate;

    @FXML
    private Label lblBId;

    @FXML
    private Label lblCName;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblQtyOHand;

    @FXML
    private Label lblType;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<?> tblRmBookingCart;

    @FXML
    private TextField txtQty;

    @FXML
    void addToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrintBillOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbRoomOnAction(ActionEvent event) {

    }

}
