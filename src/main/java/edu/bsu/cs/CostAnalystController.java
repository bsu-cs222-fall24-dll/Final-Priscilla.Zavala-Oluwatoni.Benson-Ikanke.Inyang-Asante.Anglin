package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CostAnalystController extends Controller{
    PositionModel positionModel = new CostAnalystModel();
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
        return FXCollections.observableArrayList("Total Revenue ID",
                "Total Functional Expenses ID",
                "Subsidized Health Services as a % of Total Functional Expenses",
                "Health Professions Education as a % of Total Functional Expenses",
                "Total Community Benefits Costs",
                "Charity Care Expenses",
                "Community Health Improvement Services & Community Benefit Operations Cost");
    }

    @SuppressWarnings("unused")
    public void handleTaskSelection(ActionEvent actionEvent) {
        //used for selecting the json path
        positionModel.setTitle(taskComboBox.getValue());
        String selectedTaskID = taskComboBox.getValue();

        switch (selectedTaskID) {
            case "Total Revenue ID":
                taskID = "101";
                break;
            case "Total Functional Expenses ID":
                taskID = "102";
                break;
            case "Subsidized Health Services as a % of Total Functional Expenses":
                taskID = "103";
                break;
            case "Health Professions Education as a % of Total Functional Expenses":
                taskID = "104";
                break;
            case "Total Community Benefits Costs":
                taskID = "105";
                break;
            case "Charity Care Expenses":
                taskID = "106";
                break;
            case "Community Health Improvement Services & Community Benefit Operations Cost":
                taskID = "107";
                break;
            default:
                AlertUtils.showError("Error processing task id");
        }
    }

    @SuppressWarnings("unused")
    public void handleBarChart(ActionEvent actionEvent) {
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        BarChartControllerUtils.displayBarChart(borderPane, title, years, hospitalDataArray);
    }

    @SuppressWarnings("unused")
    public void listViewSelectedHospital(MouseEvent mouseEvent) {
        String selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();
        //utility method to handle hospital selection
        StringUtils.processSelectedHospital(selectedHospital, positionModel, taskID);
    }

    @SuppressWarnings("unused")
    public void handleScatterChart(ActionEvent actionEvent) {
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        ScatterChartControllerUtils.displayScatterChart(borderPane, title, years, hospitalDataArray);
    }

    @SuppressWarnings("unused")
    public void handleCSV(ActionEvent actionEvent){
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        ExportCSV.exportToCSV(positionModel,hospitalDataArray, years);
    }
}
