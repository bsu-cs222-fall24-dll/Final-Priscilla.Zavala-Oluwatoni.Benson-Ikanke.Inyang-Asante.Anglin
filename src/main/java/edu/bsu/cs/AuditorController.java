package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class AuditorController extends Controller{
    @FXML
    private ComboBox<String> taskComboBox;

    @Override
    public ObservableList<String> taskOptions() {
        return FXCollections.observableArrayList("Bad debt as a % of Total Functional Expenses ID",
        "General Bad Debt ID");
    }

    @Override
    protected void setTaskOptions() {
        ;
        taskComboBox.setItems(taskOptions());
    }

    public void handleTaskSelection(ActionEvent actionEvent) {
    }

    public void handleBarChart(ActionEvent actionEvent) {
    }

    public void listViewSelectedHospital(MouseEvent mouseEvent) {
    }
}
