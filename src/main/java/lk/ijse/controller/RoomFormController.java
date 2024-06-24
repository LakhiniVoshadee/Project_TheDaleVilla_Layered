package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RoomFormController {

    @FXML
    private ComboBox<?> cmbId;

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
    private TableView<?> tblRoom;

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
    void roomTableClick(MouseEvent event) {

    }

    @FXML
    void txtKeyOnRele(KeyEvent event) {

    }

}
