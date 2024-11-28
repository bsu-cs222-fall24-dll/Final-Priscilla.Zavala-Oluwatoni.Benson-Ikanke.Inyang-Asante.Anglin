package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class CostAnalystController extends Controller{

    @FXML
    private ComboBox<String> taskComboBox;

    @Override
    public ObservableList<String> taskOptions() {
        return FXCollections.observableArrayList("Total Revenue ID",
                "Total Functional Expenses ID",
                "Subsidized Health Services as a % of Total Functional Expenses",
                "Health Professions Education as a % of Total Functional Expenses",
                "Total Community Benefits Costs",
                "Charity Care Expenses",
                "Community Health Improvement Services & Community Benefit Operations Cost");
    }

    @Override
    protected void setTaskOptions() {
        taskComboBox.setItems(taskOptions());
    }

    public void handleTaskSelection(ActionEvent actionEvent) {
    }

    public void handleBarChart(ActionEvent actionEvent) {
    }

    public void listViewSelectedHospital(MouseEvent mouseEvent) {
    }
}
