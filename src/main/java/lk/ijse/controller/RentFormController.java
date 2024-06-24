package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RentFormController {

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
    private TableView<?> tblRent;

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
