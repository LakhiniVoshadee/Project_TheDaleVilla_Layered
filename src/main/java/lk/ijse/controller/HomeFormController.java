package lk.ijse.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private Label lblCusCount;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblRentalCount;

    @FXML
    private Label lblRoomCount;

    @FXML
    private Label lblTime;

    @FXML
    private Pane pagingPane;

    @FXML
    private PieChart pieChart;


    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeNow();
        countCustomer();
    }

    private void countCustomer() {
        try {
            int count = customerBO.countCustomer();
            lblCusCount.setText(String.valueOf(count));
        }catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private volatile boolean running = true;

    private void timeNow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                    break;
                }
                final String currentTime = timeFormat.format(new Date());
                final String currentDate = dateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(currentTime);
                    lblDate.setText(currentDate);
                });
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void stopTimeThread() {
        running = false;
    }



}
