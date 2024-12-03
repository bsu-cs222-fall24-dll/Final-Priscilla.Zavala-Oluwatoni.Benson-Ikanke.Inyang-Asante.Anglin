package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class HRDirectorController extends Controller{
    PositionModel positionModel = new HRDirectorModel();
    public String taskID;

    @FXML
    BorderPane borderPane;

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

    @SuppressWarnings("unused")
    public void handleTaskSelection(ActionEvent actionEvent) {
        positionModel.setTitle(taskComboBox.getValue());
        String selectedTaskID = taskComboBox.getValue();

        switch (selectedTaskID) {
            case "Community Building Activities":
                taskID = "301";
                break;
            case "Community Buildings and Activity Support":
                taskID = "302";
                break;
            case "Community Health Improvement Services":
                taskID = "303";
                break;
            case "Leadership Development and Training for Community Members":
                taskID = "304";
                break;
            case "Total Community Benefits":
                taskID = "305";
                break;
            default:
                AlertUtils.showError("Error processing task id");
        }
    }

    @SuppressWarnings("unused")
    public void handleBarChart (ActionEvent actionEvent){
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        BarChartControllerUtils.displayBarChart(borderPane, title, years, hospitalDataArray);
    }

    @SuppressWarnings("unused")
    public void listViewSelectedHospital (MouseEvent mouseEvent){
        String selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();

        //utility method to handle hospital selection
        StringUtils.processSelectedHospital(selectedHospital, positionModel, taskID);
    }
}