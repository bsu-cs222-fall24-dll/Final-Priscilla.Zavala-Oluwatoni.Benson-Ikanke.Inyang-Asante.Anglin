package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class PositionModel {

    protected String title;
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private final NumberFormat number = NumberFormat.getPercentInstance();
    private final JSONDocParser jsonDocParser = new JSONDocParser();

    protected abstract String retrieveJsonPath(String taskIDFromUserChoice);

    protected abstract void changeTitle(String jsonPath);

    protected String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected String retrieveJsonFile(String id, String jsonPath) throws IOException, URISyntaxException {
        JSONReaderFormatter jsonReaderFormatter = new JSONReaderFormatter();
        JSONDocParser jsonDocParser = new JSONDocParser();
        jsonReaderFormatter.jsonDocFormatter(id);
        String taskIDToJSONData;
        changeTitle(jsonPath);
        if(StringUtils.isNumeric(id)){
            taskIDToJSONData = jsonDocParser.hospitalDocParser(id,jsonPath);
        }else{
            taskIDToJSONData = jsonDocParser.stateDocParser(id,jsonPath);
        }
        return taskIDToJSONData;
    }

    protected String formatNumericJsonData(String jsonFile) throws IOException, URISyntaxException {
        StringBuilder numericFormat = new StringBuilder();
        String[] jsonDataArray = jsonFile.replace("[", "").replace("]", "").replace("\"", "").split(",");
        String[] jsonYearArray = jsonDocParser.yearDocParser(UserInput.getHospitalID()).replace("[", "").replace("]", "").replace("\"", "").split(",");

        int maxDataWidth = 0;
        for (String name : jsonDataArray) {
            maxDataWidth = Math.max(maxDataWidth, name.length());
        }

        for (int i = 0; i < Math.min(jsonDataArray.length, jsonYearArray.length); i++) {
            long tempNumeric;
            String valueString = jsonDataArray[i].trim();
            String year = jsonYearArray[i].trim();
                try{
                    tempNumeric = Long.parseLong(valueString);
                } catch (NumberFormatException e){
                    double tempDecimal = Double.parseDouble(valueString);
                    double shiftedLeft = tempDecimal / Math.pow(100, 1);
                    String formattedPercentage = number.format(shiftedLeft);
                    numericFormat.append(String.format("\t%-"+ maxDataWidth +"s %s%n", formattedPercentage, year));
                    continue;
                }
                String formattedValue = decimalFormat.format(tempNumeric);
                int padding = (maxDataWidth - title.length()) / 2;
                numericFormat.append(String.format("%"  + (padding + title.length()) + "s %"+ ((maxDataWidth + 8 ) - padding - title.length()) + "s%n", formattedValue, year));
        }
        return numericFormat.toString();
    }
}