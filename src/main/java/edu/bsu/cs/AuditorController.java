package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class AuditorController extends Controller{
    PositionModel positionModel = new AuditorModel();
    public String taskID;

    @FXML
    BorderPane borderPane;

    @FXML
    private ComboBox<String> taskComboBox;

    public void setTaskOptions(){
        taskComboBox.setItems(taskOptions());
    }

    @Override
    public ObservableList<String> taskOptions() {
        return FXCollections.observableArrayList("Bad debt as a % of Total Functional Expenses",
        "General Bad Debt");
    }

    public void handleBarChart() {
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        BarChartControllerUtils.displayBarChart(borderPane, title, years, hospitalDataArray);
    }

    public void handleTaskSelection() {
        //used for selecting the json path
        positionModel.setTitle(taskComboBox.getValue());
        String selectedTaskID = taskComboBox.getValue();

        switch (selectedTaskID) {
            case "Bad debt as a % of Total Functional Expenses":
                taskID = "201";
                break;
            case "General Bad Debt":
                taskID = "202";
                break;
            default:
                AlertUtils.showError("Error processing task id");
        }
    }

    public void listViewSelectedHospital() {
        String selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();

        //utility method to handle hospital selection
        StringUtils.processSelectedHospital(selectedHospital, positionModel, taskID);
    }
}
