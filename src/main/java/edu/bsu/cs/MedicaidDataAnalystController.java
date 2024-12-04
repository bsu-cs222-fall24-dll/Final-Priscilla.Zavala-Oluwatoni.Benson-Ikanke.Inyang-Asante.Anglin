package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MedicaidDataAnalystController extends Controller{
    PositionModel positionModel = new MedicaidDataAnalystModel();
    public String taskID;

    @FXML
    BorderPane borderPane;

    @FXML
    ComboBox<String> taskComboBox;

    public void setTaskOptions(){
        taskComboBox.setItems(taskOptions());
    }

    @Override
    public ObservableList<String> taskOptions(){
        return FXCollections.observableArrayList("Unreimbursed Medicaid as % of Total Functional Expenses",
                "Medicare Shortfall (Negative Value Indicates Surplus)",
                "Medicare Shortfall as % of Total Functional Expenses (Negative Value Indicates Surplus)",
                "Unreimbursed Medicaid",
                "Ratio of Patient Care to Non-patient Care Community Benefits");
    }

    @SuppressWarnings("unused")
    public void handleTaskSelection(ActionEvent actionEvent) {
        //used for selecting the json path
        positionModel.setTitle(taskComboBox.getValue());
        String selectedTaskID = taskComboBox.getValue();

        switch (selectedTaskID){
            case "Unreimbursed Medicaid as % of Total Functional Expenses":
                taskID = "401";
                break;
            case "Medicare Shortfall (Negative Value Indicates Surplus)":
                taskID = "402";
                break;
            case "Medicare Shortfall as % of Total Functional Expenses (Negative Value Indicates Surplus)":
                taskID = "403";
                break;
            case "Unreimbursed Medicaid":
                taskID = "404";
                break;
            case "Ratio of Patient Care to Non-patient Care Community Benefits":
                taskID = "405";
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
    public void handleScatterChart(ActionEvent actionEvent){
        String title = positionModel.getTitle();
        String[] years = positionModel.getJsonYearArray();
        String[] hospitalDataArray = positionModel.getJsonDataArray();

        ScatterChartControllerUtils.displayScatterChart(borderPane, title, years, hospitalDataArray);
    }

    @SuppressWarnings("unused")
    public void listViewSelectedHospital(MouseEvent mouseEvent) {
        String selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();

        //utility method to handle hospital selection
        StringUtils.processSelectedHospital(selectedHospital, positionModel, taskID);
    }
}