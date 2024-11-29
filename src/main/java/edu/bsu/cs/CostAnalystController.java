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

public class CostAnalystController extends Controller{
    PositionModel positionModel = new CostAnalystModel();
    public String taskID;

    private String selectedHospital;

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
                showAlert("Error processing task id");
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
}
