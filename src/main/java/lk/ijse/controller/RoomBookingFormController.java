package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.RoomDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RoomBookingFormController  implements Initializable {


    @FXML
    private JFXButton btnAdToCart;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnPrintBill;

    @FXML
    private JFXComboBox<String> cmbCId;

    @FXML
    private JFXComboBox<String> cmbRoomId;

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

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getRoomId();
        getCusId();
        setDate();
    }

    private void setDate() {


    }

    private void getCusId() {
        ObservableList<String> customerList = FXCollections.observableArrayList();
        try {
            List<String> customerIdList = customerBO.getCusIds();
            for (String memberId : customerIdList) {
                customerList.add(memberId);
            }
            cmbCId.setItems(customerList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void getRoomId() {

    }

    private void setCellValueFactory() {
        colRmId.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colUnPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colQtOnHand.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
    }

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
        String customerId = cmbCId.getValue();
        try {
            CustomerDTO customer = customerBO.searchCustomer(customerId);
            lblCName.setText(customer.getCusName());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbRoomOnAction(ActionEvent event) {
        String roomId = cmbRoomId.getValue();
        try {
            RoomDTO room = roomBO.searchRoom(roomId);
            if (room != null) {
                lblType.setText(room.getType());
                lblUnitPrice.setText(String.valueOf(room.getUnitPrice()));
                lblQtyOHand.setText(room.getQty());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
