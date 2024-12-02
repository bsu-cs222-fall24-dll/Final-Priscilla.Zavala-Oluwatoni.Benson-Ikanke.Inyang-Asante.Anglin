package edu.bsu.cs;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

public class BarChartControllerUtils {
    public static BarChart<String, Number> createBarChart(
            String title, String[] years, String[] hospitalDataArray) {
        try {
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Year");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel(title);

            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

            XYChart.Series<String, Number> data = new XYChart.Series<>();
            data.setName(title);

            for (int i = 0; i < hospitalDataArray.length; i++) {
                double hospitalData = Double.parseDouble(hospitalDataArray[i]);
                String year = years[i];
                data.getData().add(new XYChart.Data<>(year, hospitalData));
            }

            barChart.getData().add(data);

            return barChart;
        } catch (Exception e) {
            System.err.println("Error creating bar chart: " + e.getMessage());
            return null;
        }
    }

    public static void displayBarChart(BorderPane borderPane, String title, String[] years, String[] hospitalDataArray) {
        borderPane.setRight(null);

        try {
            BarChart<String, Number> barChart = createBarChart(title, years, hospitalDataArray);

            if (barChart != null) {
                borderPane.setRight(barChart);
            } else {
                AlertUtils.showError("Error displaying bar chart.");
            }
        } catch (Exception e) {
            AlertUtils.showError("Error processing bar chart data.");
        }
    }
}
