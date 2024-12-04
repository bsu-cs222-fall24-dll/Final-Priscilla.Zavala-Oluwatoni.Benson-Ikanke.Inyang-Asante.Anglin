package edu.bsu.cs;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class PositionView {
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private final NumberFormat numberFormat = NumberFormat.getPercentInstance();
    protected PositionModel model;

    public PositionView(PositionModel model) {
        this.model = model;
    }

    //NOT model code, view code for formatting data
    public String formatDataForDisplay(String[] jsonDataArray, String[] jsonYearArray, int maxDataWidth, String title) {
        StringBuilder formattedData = new StringBuilder();

        for (int i = 0; i < Math.min(jsonDataArray.length, jsonYearArray.length); i++) {
            String valueString = jsonDataArray[i].trim();
            String year = jsonYearArray[i].trim();

            try {
                long numericValue = Long.parseLong(valueString);
                String formattedValue = decimalFormat.format(numericValue);
                formattedData.append(String.format("%-" + maxDataWidth + "s %s%n", formattedValue, year));
            } catch (NumberFormatException e) {
                try {
                    double percentageValue = Double.parseDouble(valueString) / 100.0;
                    String formattedPercentage = numberFormat.format(percentageValue);
                    formattedData.append(String.format("%-" + maxDataWidth + "s %s%n", formattedPercentage, year));
                } catch (NumberFormatException ignored) {
                    System.err.println("Error formatting value: " + valueString);
                }
            }
        }
        String header = formatHeader(title, maxDataWidth);
        return header + "\n" + formattedData;
    }

    private String formatHeader(String title, int maxDataWidth) {
        int padding = (maxDataWidth - title.length()) / 2;
        return String.format("%" + (padding + title.length()) + "s %" + ((maxDataWidth + 8) - padding - title.length()) + "s", title, "Year");
    }

    //display formatted numeric data, calling model's format method
    public void displayFormattedData(String jsonFile, String jsonPath) {
        System.out.print(jsonFile);
    }
}