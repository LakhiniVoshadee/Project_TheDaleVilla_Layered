package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HomeFormController {

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

}
