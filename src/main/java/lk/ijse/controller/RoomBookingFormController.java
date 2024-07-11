package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.RoomBookingBO;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.RoomDTO;
import lk.ijse.tdm.RoomBookingTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
    private TableView<RoomBookingTM> tblRmBookingCart;

    @FXML
    private TextField txtQty;

    private ObservableList<RoomBookingTM> cartList = FXCollections.observableArrayList();
    private double netTotal = 0;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    RoomBookingBO roomBookingBO = (RoomBookingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Room_BOOKING);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            lblBId.setText(generateBookingID());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setCellValueFactory();
        getRoomId();
        getCusId();
        setDate();
    }

    private String generateBookingID() {
        try {
            ResultSet rst = roomBookingBO.generateNextRoomBookingId();
            String currentOrderId = "";
            if (rst.next()) {
                currentOrderId = rst.getString(1);
                return nextOrderId(currentOrderId);
            }
            return nextOrderId(null);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private String nextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O ");
            int orderID = Integer.parseInt(split[1]);
            orderID++;
            return "O " + orderID;
        }
        return "O 1";

    }


    private void setDate() {
        LocalDate now = LocalDate.now();
        lblBDate.setText(String.valueOf(now));

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
        ObservableList<String> roomList = FXCollections.observableArrayList();

        try {
           List<String>roomIdList =  roomBO.getRoomIds();
           for (String roomId : roomIdList) {
               roomList.add(roomId);
           }
           cmbRoomId.setItems(roomList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
        String RoomId = cmbRoomId.getValue();
        String Type = lblType.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        double UnitPrice = Double.parseDouble(lblUnitPrice.getText());
        String QtyOnHand = lblQtyOHand.getText();
        double Total = Qty * UnitPrice;
        JFXButton btnRemove = new JFXButton("Remove");
        btnRemove.setCursor(Cursor.HAND);

        btnRemove.setOnAction(e  ->{
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> Desc = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure want to remove?", yes, no).showAndWait();

            if (Desc.orElse(no) == yes){
                int selectedIndex = tblRmBookingCart.getSelectionModel().getSelectedIndex();
                cartList.remove(selectedIndex);

                tblRmBookingCart.refresh();
                calculateNetTotal();
            }
        });

        for (int i=0; i<tblRmBookingCart.getItems().size(); i++ ){
            if (RoomId.equals(colRmId.getCellData(i))){
                Qty += cartList.get(i).getQty();
                Total = UnitPrice * Qty;

                cartList.get(i).setQty(Qty);
                cartList.get(i).setTotal(Total);

                tblRmBookingCart.refresh();
                calculateNetTotal();
                txtQty.setText("");
                return;
            }

        }

        RoomBookingTM roomBookingTm = new RoomBookingTM(RoomId, Type, UnitPrice, QtyOnHand, Qty, Total, btnRemove);
        cartList.add(roomBookingTm);

        tblRmBookingCart.setItems(cartList);
        txtQty.setText("");
        calculateNetTotal();

    }

    private void calculateNetTotal() {
        netTotal = 0;
        for (int i = 0; i <tblRmBookingCart.getItems().size(); i++) {
            netTotal += (double) colTotal.getCellData(i);

        }
        lblNetTotal.setText(String.valueOf(netTotal));
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
