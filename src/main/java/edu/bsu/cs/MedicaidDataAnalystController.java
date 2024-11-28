package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicaidDataAnalystController extends Controller{
    PositionModel positionModel = new MedicaidDataAnalystModel();
    public String taskID;

    private String selectedHospital;

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

    public void handleBarChart(ActionEvent actionEvent) {
        borderPane.setRight(null);
        //handles the display of the bar chart
        try{
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Year");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel(positionModel.getTitle());

            BarChart barChart = new BarChart(xAxis, yAxis);

            XYChart.Series data = new XYChart.Series();
            data.setName(positionModel.getTitle());

            barChart.getData().add(data);

            try{
                String[] years = positionModel.getJsonYearArray();
                String[] hospitalDataArray = positionModel.getJsonDataArray();

                for(int i = 0; i < positionModel.getJsonDataArray().length; i++){
                    //Get corresponding x and y values from year and data arrays
                    double hospitalData = Double.parseDouble(hospitalDataArray[i]);
                    String year = years[i];
                        data.getData().add(new XYChart.Data<>(year, hospitalData));
                    }
            }catch (Exception e){
                showAlert("Hospital data process error");
            }
            borderPane.setRight(barChart);
        }catch(Exception e){
            showAlert("Error showing bar chart");
        }
    }

    public void handleTaskSelection(ActionEvent actionEvent) {
        //Method detects the value the user selects and converts it into a taskID that can be
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
                showAlert("Error processing task id");
        }
    }

    public void listViewSelectedHospital(MouseEvent mouseEvent) {
        try{
            selectedHospital = stateSelectionHospitals.getSelectionModel().getSelectedItem();
            String hospitalID = extractIntFromString(selectedHospital);
            UserInput.setHospitalID(hospitalID);
            String jsonPath = positionModel.retrieveJsonPath(taskID);
            String jsonFile = positionModel.retrieveJsonFile(hospitalID, jsonPath);
            positionModel.formatNumericJsonData(jsonFile);
        } catch(Exception e){
            showAlert("Select state and task option");
        }
    }

    public String extractIntFromString(String str) {
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String intString = matcher.group();
            try {
                Integer.parseInt(intString);
                return intString;
            } catch (NumberFormatException e) {
                showAlert("Error finding hospital");
            }
        }
        // Return null if no integer was found
        return null;
    }
}