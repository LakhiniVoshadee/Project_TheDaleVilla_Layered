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
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.entity.Employee;
import lk.ijse.model.EmployeeDTO;
import lk.ijse.tdm.EmployeeTM;
import lk.ijse.thedale.model.Employee;
import lk.ijse.thedale.repository.EmployeeRepo;
import lk.ijse.thedale.tm.EmployeeTm;
import lk.ijse.thedale.util.DataValidateController;
import lk.ijse.thedale.util.Validation;
import lk.ijse.util.DataValidateController;
//import lk.ijse.thedale.util.Validation;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class EmployeeFormController implements Initializable {

    @FXML
    private TableColumn<String, String> colDob;

    @FXML
    private TableColumn<String, String> colEmail;

    @FXML
    private TableColumn<String, String> colId;

    @FXML
    private TableColumn<String, String> colName;

    @FXML
    private TableColumn<String, String> colType;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<EmployeeTM> tblEmployee;

    @FXML
    private DatePicker pickerDate;


    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtType;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblEmployeeName;

    @FXML
    private Label lblType;


    LinkedHashMap<TextField, Pattern> map =new LinkedHashMap();

    //EmployeeRepo employeeRepo = new EmployeeRepo();

    private List<EmployeeDTO> employeeList = new ArrayList<>();


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields(){
        txtEmpId.setText("");
        txtEmpName.setText("");
        txtType.setText("");
        txtEmail.setText("");
        pickerDate.setValue(null);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
       // EmployeeRepo employeeRepo = new EmployeeRepo();

        try {
            boolean isDeleted = employeeBO.deleteEmployee(id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted successfully").show();
                loadEmployeeTable();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            txtEmpId.setText(employeeBO.generateNextEmpId());
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.employeeList =getAllEmployee();
        setCellValueFactory();
        loadEmployeeTable();

       /* Pattern patternId = Pattern.compile("^([A-Z0-9])$");
        Pattern patternName = Pattern.compile("^[A-z|\\\\s]{3,}$");
        //Pattern patternType = Pattern.compile("^[A-z|\\\\s]{5,}$");
        Pattern patternEmail = Pattern.compile("^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$");

        map.put(txtEmpId, patternId);
        map.put(txtEmpName, patternName);
        map.put(txtEmail, patternEmail);

        */
    }

    @FXML
    void employeeTableClick(MouseEvent event) {
        TablePosition pos = tblEmployee.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<EmployeeTM, ?>> columns = tblEmployee.getColumns();

        txtEmpId.setText(columns.get(0).getCellData(row).toString());
        txtEmpName.setText(columns.get(1).getCellData(row).toString());
        txtType.setText(columns.get(2).getCellData(row).toString());
        txtEmail.setText(columns.get(3).getCellData(row).toString());
        pickerDate.setValue(LocalDate.parse(columns.get(4).getCellData(row).toString()));
    }

    private List<EmployeeDTO>  getAllEmployee() {
        List<EmployeeDTO>employeeList = null;
        try {
            employeeList = employeeBO.getEmployee();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        return employeeList;
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String type = txtType.getText();
        String email = txtEmail.getText();
        String dob = String.valueOf(pickerDate.getValue());
        String userId = LoginFormController.getInstance().userId;

        Employee employee = new Employee(id,name,type,email,dob,userId);
       // DataValidateController DataValidateController = null;
        if (DataValidateController.validateEmail(txtEmail.getText())) {
            lblEmail.setText("");

            if (DataValidateController.validateEmpType(txtType.getText())) {
                lblType.setText("");

                if (DataValidateController.validateEmpName(txtEmpName.getText())) {
                    lblEmployeeName.setText("");


                    try {
                        boolean isSaved = EmployeeBO.saveEmployee(employee);
                        new Alert(Alert.AlertType.CONFIRMATION, "Employee has been saved successfully").show();
                        loadEmployeeTable();
                    } catch (SQLException e) {
                        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    lblEmployeeName.setText("Invalid Name");
                }
            } else {
                lblType.setText("Invalid Type");
            }
        }else {
            lblEmail.setText("Invalid Email");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String type = txtType.getText();
        String email = txtEmail.getText();
        String dob = String.valueOf(pickerDate.getValue());
        String userId = "U001";
        //String userId = LoginFormController.getInstance().userId;

        Employee employee = new Employee(id,name,type,email,dob,userId);

        try {
            boolean isUpdated = EmployeeBO.updateEmployee(employee);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee has been updated successfully").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            loadEmployeeTable();
        }
    }


    private void loadEmployeeTable() {
        EmployeeRepo employeeRepo = new EmployeeRepo();
        ObservableList<EmployeeTm>tmList = FXCollections.observableArrayList();
        try {
            List<Employee> employeeList = employeeRepo.getEmployee();
            for (Employee employee : employeeList) {
                EmployeeTm employeeTm = new EmployeeTm(
                        employee.getEmpID(),
                        employee.getName(),
                        employee.getType(),
                        employee.getEmail(),
                        employee.getDOB()
                );
                tmList.add(employeeTm);
            }
            tblEmployee.setItems(tmList);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        }
    }

    private void setCellValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
    }
    @FXML
    void txtKeyOnRele(KeyEvent event) {
        Validation.validate(map);
    }

}

