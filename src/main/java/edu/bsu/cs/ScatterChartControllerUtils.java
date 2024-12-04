package edu.bsu.cs;

import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;

public class ScatterChartControllerUtils {

    public static ScatterChart<String, Number> createScatterChart(String title, String[] years, String[] hospitalDataArray) {
        ScatterChart<String, Number> scatterChart;
        try {
            Axis<String> xAxis = new CategoryAxis();
            xAxis.setLabel("Year");

            Axis<Number> yAxis = new NumberAxis();
            yAxis.setLabel(title);

            scatterChart = new ScatterChart<>(xAxis, yAxis);
            XYChart.Series<String, Number> data = new XYChart.Series<>();
            data.setName(title);
            scatterChart.getData().add(data);

            for (int i = 0; i < hospitalDataArray.length; i++) {
                double hospitalData = Double.parseDouble(hospitalDataArray[i]);
                String year = years[i];
                data.getData().add(new XYChart.Data<>(year, hospitalData));
            }

            return scatterChart;
        } catch (Exception e) {
            AlertUtils.showError("Error creating scatter chart");
            return null;
        }
    }

    public static void displayScatterChart(BorderPane borderPane, String title, String[] years, String[] hospitalDataArray){
        borderPane.setRight(null);

        try {
            ScatterChart<String, Number> scatterChart = createScatterChart(title, years, hospitalDataArray);
            if(scatterChart != null){
                borderPane.setRight(scatterChart);
            }else{
                AlertUtils.showError("Could not display scatter plot.");
            }
        }catch(Exception e){
            AlertUtils.showError("Error processing scatter chart data.");
        }


    }
}
