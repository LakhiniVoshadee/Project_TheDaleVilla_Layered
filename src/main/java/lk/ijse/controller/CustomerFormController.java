package lk.ijse.controller;


import com.mysql.cj.xdevapi.Table;
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
import lk.ijse.model.CustomerDTO;
import lk.ijse.tdm.CustomerTM;
/*import lk.ijse.thedale.model.Customer;
import lk.ijse.thedale.repository.CustomerRepo;
import lk.ijse.thedale.tm.CustomerTm;
import lk.ijse.thedale.util.DataValidateController;
import lk.ijse.thedale.util.Validation;*/
//import lk.ijse.thedale.util.Validation;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CustomerFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colSex;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtCusName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtSex;

    @FXML
    private Label lblCusContact;

    @FXML
    private Label lblCusEmail;

    @FXML
    private Label lblCusNic;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblCustomerSex;

    public String cusID;

 //   private static CustomerFormController controller;

 //   LinkedHashMap<TextField, Pattern> map =new LinkedHashMap();

  /*  public CustomerFormController (){
        controller = this;
    }

    public static CustomerFormController getInstance(){
        return controller;
    }*/

  //  CustomerRepo customerRepo = new CustomerRepo();

   // private List<Customer> customerList = new ArrayList<>();

    // LinkedHashMap<TextField, Pattern> map =new LinkedHashMap();


    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields(){
        txtCusId.setText("");
        txtCusName.setText("");
        txtSex.setText("");
        txtNic.setText("");
        txtEmail.setText("");
        txtContact.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtCusId.getText();

        try {
            boolean isDeleted = customerBO.deleteCustomer(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted successfully").show();
                loadCustomerTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        txtCusId.setText(generateCustomerId());
        //  this.customerList=getAllCustomer();
        setCellValueFactory();
        loadCustomerTable();

       /* Pattern patternId = Pattern.compile("^([A-Z0-9])$");
        Pattern patternName = Pattern.compile("^[A-z|\\\\s]{3,}$");
        Pattern patternSex = Pattern.compile("^(male|female|non-binary|genderqueer|genderfluid|transgender|agender|bigender|gender nonconforming|gender questioning|gender variant|genderqueer|intersex|neutrois|pangender|third gender)$");
        Pattern patternNIC = Pattern.compile("^[0-9 a-z]{10}$");
        Pattern patternContact = Pattern.compile("^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$");
        Pattern patternEmail = Pattern.compile("^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$");

        map.put(txtCusId, patternId);
        map.put(txtCusName, patternName);
        map.put(txtSex, patternSex);
        map.put(txtNic, patternNIC);
        map.put(txtContact, patternContact);
        map.put(txtEmail, patternEmail);

        */

    }

    public String generateCustomerId() {

        try {
           ResultSet resultSet= customerBO.generateNextId();
           String currentCusId = "";
           if (resultSet.next()) {
               currentCusId = resultSet.getString(1);
               return nextCusId(currentCusId);
           }
           return nextCusId(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private String nextCusId(String currentCusId) {
        if (currentCusId != null){
            String[] split = currentCusId.split("Cus ");
            int CusId = Integer.parseInt(split[1]);
            CusId++;
            return "Cus " + CusId;
        }
        return "Cus 1";


    }

    @FXML
    void customerTableClick(MouseEvent event) {
        TablePosition pos = tblCustomer.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<CustomerTM,?>> columns = tblCustomer.getColumns();

        txtCusId.setText(columns.get(0).getCellData(row).toString());
        txtCusName.setText(columns.get(1).getCellData(row).toString());
        txtSex.setText(columns.get(2).getCellData(row).toString());
        txtContact.setText(columns.get(3).getCellData(row).toString());
        txtNic.setText(columns.get(4).getCellData(row).toString());
        txtEmail.setText(columns.get(5).getCellData(row).toString());

    }

    private void loadCustomerTable() {
        try {
            ArrayList<CustomerDTO> customerList = customerBO.getAllCustomers();
            for (CustomerDTO customer : customerList) {
              tblCustomer.getItems().add(new CustomerTM(
                        customer.getCusID(),
                        customer.getCusName(),
                        customer.getSex(),
                        customer.getNic(),
                        customer.getContact(),
                        customer.getEmail(),
                        customer.getUserID()));
            }

        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("cusID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

    }



    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtCusId.getText();
        String name = txtCusName.getText();
        String sex = txtSex.getText();
        String nic = txtNic.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
      //  LoginFormController userId = LoginFormController.getInstance();
        String userId = "U001";

        try {
            boolean isSaved =customerBO.saveCustomer(new CustomerDTO(id,name,sex,nic,contact,email,userId));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer saved successfully").show();
                loadCustomerTable();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtCusId.getText();
        String name = txtCusName.getText();
        String sex = txtSex.getText();
        String nic = txtNic.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        //String userId = LoginFormController.getInstance().userId;
        String userId = "U001";

        try {
            boolean isUpdated = customerBO.updateCustomer(new CustomerDTO(id,name,sex,nic,contact,email,userId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updated successfully").show();
                loadCustomerTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void txtOnKeyRelease(KeyEvent event) {
        //Validation.validate(map);


    }



}
