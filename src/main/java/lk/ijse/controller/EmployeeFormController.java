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
import javafx.scene.shape.Rectangle;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.EmployeeDTO;
import lk.ijse.tdm.EmployeeTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblEmployeeName;

    @FXML
    private Label lblType;

    @FXML
    private Pane pagingPane;

    @FXML
    private DatePicker pickerDate;

    @FXML
    private TableView<EmployeeTM> tblEmployee;

    @FXML
    private Rectangle txtDob;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtType;


    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    @FXML
    void btnClearOnAction(ActionEvent event) {

        clearFields();
    }

    private void clearFields() {
        txtEmpId.setText("");
        txtEmpName.setText("");
        txtType.setText("");
        txtEmail.setText("");
        pickerDate.setValue(null);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            txtEmpId.setText(generateEmployeeId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            loadEmployeeTable();
            setCellValueFactory();

    }

    private String generateEmployeeId() {

        try {
            ResultSet resultSet= employeeBO.generateNextEmpId();
            String currentEmpId = "";
            if (resultSet.next()) {
                currentEmpId = resultSet.getString(1);
                return nextEmpId(currentEmpId);
            }
            return nextEmpId(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private String nextEmpId(String currentEmpId) {
        if (currentEmpId != null){
            String[] split = currentEmpId.split("Emp ");
            int EmpId = Integer.parseInt(split[1]);
            EmpId++;
            return "Emp " + EmpId;
        }
        return "Emp 1";

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
    }

    private void loadEmployeeTable() {
        ObservableList<EmployeeTM> employees = FXCollections.observableArrayList();
        try {
            ArrayList<EmployeeDTO> employeeList = employeeBO.getAllEmployees();
            for (EmployeeDTO employee : employeeList){
                EmployeeTM employeeTM = new EmployeeTM(
                        employee.getEmpID(),
                        employee.getName(),
                        employee.getType(),
                        employee.getEmail(),
                        employee.getDOB(),
                        employee.getUserID());
                employees.add(employeeTM);
            }
            tblEmployee.setItems(employees);
            tblEmployee.refresh();

        } catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event)  {
        String id = txtEmpId.getText();

        try {
            boolean isDeleted = employeeBO.deleteEmployee(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted successfully").show();
                loadEmployeeTable();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String type = txtType.getText();
        String email = txtEmail.getText();
        String dob = String.valueOf(pickerDate.getValue());
        String userID = "U001";

        try {
            boolean isSaved =employeeBO.saveEmployee(new EmployeeDTO(id,name,type,email,dob,userID));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee saved successfully").show();
                tblEmployee.getItems().add(new EmployeeTM(id,name,type,email,dob,userID));
                tblEmployee.refresh();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String type = txtType.getText();
        String email = txtEmail.getText();
        String dob = String.valueOf(pickerDate.getValue());
        String userID = "U001";

        try {
            boolean isUpdated = employeeBO.updateEmployee(new EmployeeDTO(id,name,type,email,dob,userID));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee updated successfully").show();
                loadEmployeeTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void employeeTableClick(MouseEvent event) {
        TablePosition pos = tblEmployee.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<EmployeeTM,?>> columns = tblEmployee.getColumns();

        txtEmpId.setText(columns.get(0).getCellData(row).toString());
        txtEmpName.setText(columns.get(1).getCellData(row).toString());
        txtType.setText(columns.get(2).getCellData(row).toString());
        txtEmail.setText(columns.get(3).getCellData(row).toString());
        pickerDate.setValue(LocalDate.parse(columns.get(4).getCellData(row).toString()));
    }

    @FXML
    void txtKeyOnRele(KeyEvent event) {

    }

}
