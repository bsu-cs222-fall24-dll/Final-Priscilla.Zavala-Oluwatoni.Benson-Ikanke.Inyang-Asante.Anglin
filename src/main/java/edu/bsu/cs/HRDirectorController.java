package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class HRDirectorController extends Controller{

    @FXML
    private ComboBox<String> taskComboBox;

    @Override
    public ObservableList<String> taskOptions() {
        return FXCollections.observableArrayList(
                "Community Building Activities",
                "Community Buildings and Activity Support",
                "Community Health Improvement Services",
                "Leadership Development and Training for Community Members",
                "Total Community Benefits");
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
