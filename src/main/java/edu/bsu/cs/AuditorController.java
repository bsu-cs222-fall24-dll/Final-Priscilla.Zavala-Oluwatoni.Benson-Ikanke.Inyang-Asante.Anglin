package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AuditorController extends Controller{
    PositionModel positionModel = new AuditorModel();
    public String taskID;

    @FXML
    BorderPane borderPane;

    @FXML
    private ComboBox<String> taskComboBox;

    @Override
    public ObservableList<String> taskOptions() {
        return FXCollections.observableArrayList("Bad debt as a % of Total Functional Expenses ID",
        "General Bad Debt ID");
    }

    @Override
    protected void setTaskOptions() {
        taskComboBox.setItems(taskOptions());
    }

    public void handleTaskSelection(ActionEvent actionEvent) {
        //used for selecting the json path
        positionModel.setTitle(taskComboBox.getValue());
        String selectedTaskID = taskComboBox.getValue();

        switch (selectedTaskID){
            case "Bad debt as a % of Total Functional Expenses ID":
                taskID = "201";
                break;
            case "General Bad Debt ID":
                taskID = "202";
                break;
            default:
                AlertUtils.showError("Error processing task id");
        }
    }

    public void handleBarChart(ActionEvent actionEvent) {
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        BarChartControllerUtils.displayBarChart(borderPane, title, years, hospitalDataArray);
    }

    public void listViewSelectedHospital(MouseEvent mouseEvent) {
        String selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();

        //utility method to handle hospital selection
        StringUtils.processSelectedHospital(selectedHospital, positionModel, taskID);
    }
}
