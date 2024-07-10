package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.model.RoomDTO;
import lk.ijse.tdm.RoomTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {


    @FXML
    private ComboBox<String> cmbId;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblRoomQty;

    @FXML
    private Label lblRoomType;

    @FXML
    private Label lblRoomUp;

    @FXML
    private Pane pageInPane;

    @FXML
    private TableView<RoomTM> tblRoom;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtUnitPrice;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       txtRoomId.setText(generateRoomId());
       setCellValueFactory();
       loadRoomTable();
       getCusId();
    }

    private void getCusId() {
        ObservableList<String> customerList = FXCollections.observableArrayList();
        try {
            List<String> cusIDList = customerBO.getCusIds();
            for (String cusID : cusIDList) {
                customerList.add(cusID);
            }
            cmbId.setItems(customerList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
    }

    private String generateRoomId() {

        try {
            ResultSet resultSet= roomBO.generateNextRoomId();
            String currentRoomId = "";
            if (resultSet.next()) {
                currentRoomId = resultSet.getString(1);
                return nextRoomId(currentRoomId);
            }
            return nextRoomId(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String nextRoomId(String currentRoomId) {
        if (currentRoomId != null){
            String[] split = currentRoomId.split("Room ");
            int RoomId = Integer.parseInt(split[1]);
            RoomId++;
            return "Room " + RoomId;
        }
        return "Room 1";

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtRoomId.setText("");
        txtType.setText("");
        txtDate.setValue(null);
        // txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtRoomId.getText();

        try {
            boolean isDeleted = roomBO.deleteRoom(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted successfully").show();
                loadRoomTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadRoomTable() {
        ObservableList<RoomTM> roomList = FXCollections.observableArrayList();
        try {
            ArrayList<RoomDTO>  allroom = roomBO.getAllRooms();
            for (RoomDTO room : allroom) {
                RoomTM roomTM = new RoomTM(
                        room.getRoomID(),
                        room.getType(),
                        room.getDate(),
                        room.getUnitPrice(),
                                room.getQty(),
                        room.getCustomerId());
                roomList.add(roomTM);
            }
            tblRoom.setItems(roomList);
            tblRoom.refresh();

        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtRoomId.getText();
        String type = txtType.getText();
        String date = String.valueOf(txtDate.getValue());
        String cusID = cmbId.getValue();
        Double unitPrice = Double.valueOf(txtUnitPrice.getText());
        String qty = txtQty.getText();


        try {
            boolean isSaved =roomBO.saveRoom(new RoomDTO(id,type,date,unitPrice,qty,cusID));
            System.out.println("ok");
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room saved successfully").show();
                tblRoom.getItems().add(new RoomTM(id,type,date,unitPrice,qty,cusID));
                tblRoom.refresh();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtRoomId.getText();
        String type = txtType.getText();
        String date = String.valueOf(txtDate.getValue());
        String cusID = cmbId.getValue();
        Double unitPrice = Double.valueOf(txtUnitPrice.getText());
        String qty = txtQty.getText();

        try {
            boolean isUpdated = roomBO.updateRoom(new RoomDTO(id,type,date,unitPrice,qty,cusID));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updated successfully").show();
                loadRoomTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void roomTableClick(MouseEvent event) {
        TablePosition pos = tblRoom.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<RoomTM,?>> columns = tblRoom.getColumns();

        txtRoomId.setText(columns.get(0).getCellData(row).toString());
        txtType.setText(columns.get(1).getCellData(row).toString());
        txtDate.setValue(LocalDate.parse(columns.get(2).getCellData(row).toString()));
        cmbId.setValue(columns.get(3).getCellData(row).toString());
        txtUnitPrice.setText(columns.get(4).getCellData(row).toString());
        txtQty.setText(columns.get(5).getCellData(row).toString());
    }

    @FXML
    void txtKeyOnRele(KeyEvent event) {

    }

}
