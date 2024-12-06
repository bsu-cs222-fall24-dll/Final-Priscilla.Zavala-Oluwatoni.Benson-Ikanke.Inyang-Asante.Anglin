package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class PositionModel {

    protected String title;
    protected String hospitalName;
    private final JSONDocParser jsonDocParser = new JSONDocParser();

    public String[] getJsonDataArray() {
        return jsonDataArray;
    }

    public String[] getJsonYearArray() {
        return jsonYearArray;
    }

    public String getHospitalName(){return UserInput.getHospitalName();}

    String[] jsonDataArray;
    private String[] jsonYearArray;

    protected abstract String retrieveJsonPath(String taskIDFromUserChoice);

    protected abstract void changeTitle(String jsonPath);

    protected String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //cannot make unit test - requires live connect via jsonPath
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

    public int calculateMaxDataWidth() {
        int maxWidth = 0;
        for (String name : jsonDataArray) {
            maxWidth = Math.max(maxWidth, name.length());
        }
        return maxWidth;
    }

    //cannot make unit test - requires user input for hospitalID to obtain jsonFile
    public void loadNumericJsonData(String jsonFile) throws IOException, URISyntaxException {
        jsonDataArray = jsonFile.replace("[", "").replace("]", "").replace("\"", "").split(",");
        jsonYearArray = jsonDocParser.yearDocParser(UserInput.getHospitalID()).replace("[", "").replace("]", "").replace("\"", "").split(",");
    }
}