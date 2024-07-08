package lk.ijse.controller;

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
        try {
            ArrayList<RentDTO> rentList = rentBO.getAllRents();
            for (RentDTO rent : rentList) {
                tblRent.getItems().add(new RentTM(
                       rent.getRentID(),
                       rent.getType(),
                       rent.getQty(),
                       rent.getDescription(),
                       rent.getUnitPrice()));
            }

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

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void rentTableClick(MouseEvent event) {

    }

}
