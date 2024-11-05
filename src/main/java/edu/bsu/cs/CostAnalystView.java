package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class CostAnalystView{
    private final CostAnalystModel model = new CostAnalystModel();

    public String displayNameJsonData(String jsonFile){
        StringBuilder nameListFormat = new StringBuilder();
        String[] jsonDataArray = jsonFile.split(",");
        for(int i = 0; i < jsonDataArray.length -1; i++){
            String name = jsonDataArray[i];
            nameListFormat.append(name);
        }
        return nameListFormat.toString();
    }

    public void displayFormattedData(String jsonFile, String jsonPath) throws IOException, URISyntaxException {
        String numericalValue = model.formatNumericJsonData(jsonFile);
        model.getTitle(jsonPath);
        System.out.print(numericalValue); // Print the formatted numerical values
    }
}