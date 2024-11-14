package edu.bsu.cs;

import java.net.URISyntaxException;
import java.io.IOException;

public abstract class PositionView {

    protected PositionModel model;  // Reference to the model (could be passed in the constructor of child classes)

    public PositionView(PositionModel model) {
        this.model = model;
    }

    // Display names in the JSON data
    public String displayNameJsonData(String jsonFile) {
        StringBuilder nameListFormat = new StringBuilder();
        String[] jsonDataArray = jsonFile.split(",");
        for (String name : jsonDataArray) {
            nameListFormat.append(name).append("\n");  // Add a new line for better formatting
        }
        return nameListFormat.toString();
    }

    // Display formatted numeric data, calling the model's format method
    public void displayFormattedData(String jsonFile, String jsonPath) throws IOException, URISyntaxException {// Call model's formatNumericJsonData
        System.out.print(jsonFile);  // Print the formatted numerical values
    }
}