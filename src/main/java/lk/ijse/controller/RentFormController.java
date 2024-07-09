package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RentBO;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.RentDTO;
import lk.ijse.tdm.CustomerTM;
import lk.ijse.tdm.RentTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RentFormController implements Initializable {


    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblType;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Pane pageInPane;

    @FXML
    private TableView<RentTM> tblRent;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtRentId;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtUnitPrice;


    RentBO rentBO = (RentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RENT);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtRentId.setText(generateRentId());
        setCellValueFactory();
        loadRentTable();

    }

    private void setCellValueFactory() {

        try {
            ResultSet resultSet= rentBO.generateNextRentId();
            String currentRentId = "";
            if (resultSet.next()) {
                currentRentId = resultSet.getString(1);
                nextRentId(currentRentId);
                return;
            }
            nextRentId(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String nextRentId(String currentRentId ) {
        if (currentRentId != null){
            String[] split = currentRentId.split("Rent ");
            int RentId = Integer.parseInt(split[1]);
            RentId++;
            return "Rent " + RentId;
        }
        return "Rent 1";
    }

    private void loadRentTable() {
        ObservableList<RentTM> tmList = FXCollections.observableArrayList();
        try {
            ArrayList<RentDTO> rentList = rentBO.getAllRents();
            for (RentDTO rent : rentList) {
                RentTM rentTM=new RentTM(
                       rent.getRentID(),
                       rent.getType(),
                       rent.getQty(),
                       rent.getDescription(),
                       rent.getUnitPrice());
                tmList.add(rentTM);
            }
            tblRent.setItems(tmList);
            tblRent.refresh();
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRentId() {
        try {
            ResultSet resultSet= rentBO.generateNextRentId();
            String currentRentId = "";
            if (resultSet.next()) {
                currentRentId = resultSet.getString(1);
                return nextRentId(currentRentId);
            }
            return nextRentId(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
      clearFields();

    }

    private void clearFields() {
        txtRentId.setText("");
        txtType.setText("");
        txtQty.setText("");
        txtDescription.setText("");
        //txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtRentId.getText();

        try {
            boolean isDeleted = rentBO.deleteRent(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Rent deleted successfully").show();
                loadRentTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String RentID = txtRentId.getText();
        String Type = txtType.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        String Description = txtDescription.getText();
        // String QtyOnHand = txtQtyOnHand.getText();
        double UnitPrice = Double.parseDouble(txtUnitPrice.getText());

        try {
            boolean isSaved =rentBO.saveRent(new RentDTO(RentID,Type,Qty,Description,UnitPrice));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Rent Item saved successfully").show();
                tblRent.getItems().add(new RentTM(RentID,Type,Qty,Description,UnitPrice));
                tblRent.refresh();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String RentID = txtRentId.getText();
        String Type = txtType.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        String Description = txtDescription.getText();
        // String QtyOnHand = txtQtyOnHand.getText();
        double UnitPrice = Double.parseDouble(txtUnitPrice.getText());

        try {
            boolean isUpdated = rentBO.updateRent(new RentDTO(RentID,Type,Qty,Description,UnitPrice));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Rent Item updated successfully").show();
                loadRentTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void rentTableClick(MouseEvent event) {

        TablePosition pos = tblRent.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<RentTM,?>> columns = tblRent.getColumns();

        txtRentId.setText(columns.get(0).getCellData(row).toString());
        txtType.setText(columns.get(1).getCellData(row).toString());
        txtQty.setText(columns.get(2).getCellData(row).toString());
        txtDescription.setText(columns.get(3).getCellData(row).toString());
        txtUnitPrice.setText(columns.get(4).getCellData(row).toString());
    }

}
