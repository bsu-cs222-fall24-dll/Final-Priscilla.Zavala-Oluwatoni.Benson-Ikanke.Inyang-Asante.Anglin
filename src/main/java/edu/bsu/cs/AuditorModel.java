package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//TODO: Class on project backlog - finish refactoring it for second iteration
    //class currently has no usages - on backlog
public class AuditorModel {
    private final JSONDocParser parser;
    DecimalFormat df = new DecimalFormat("###,###,###,###");
    NumberFormat nf = NumberFormat.getPercentInstance();
    JSONDocParser jsonDocParser = new JSONDocParser();

    public AuditorModel(){
        this.parser = new JSONDocParser();
    }

    public String retrieveStateData(String stateID, String jsonPath) throws IOException, URISyntaxException{

        String parseData = parser.stateDocParser(stateID,jsonPath);
        System.out.println("Parsed state data:" + stateID + ":");
        System.out.println(parseData);
        JSONArray stateDoc = JsonPath.read(parseData,"$.."+ jsonPath);
        return  stateDoc.toString();
    }
    public String retrieveHospitalData(String hospitalData,String jsonPath) throws IOException, URISyntaxException{
        String parseData = parser.hospitalDocParser(hospitalData, jsonPath);
        System.out.println("Parsed hospital data:" + hospitalData + ":" );
        System.out.println(parseData);
        JSONArray hospitalDoc = JsonPath.read(parseData,"$.."+ jsonPath);
        return hospitalDoc.toString();
    }


    String title = "Title not found...";
    protected String retrieveJsonFile(String id, String jsonPath) throws IOException, URISyntaxException {
        JSONReaderFormatter jsonReaderFormatter = new JSONReaderFormatter();
        JSONDocParser jsonDocParser = new JSONDocParser();
        jsonReaderFormatter.jsonDocFormatter(id);
        String taskIDToJSONData;
        if(StringUtils.isNumeric(id)){
            taskIDToJSONData = jsonDocParser.hospitalDocParser(id,jsonPath);
        }else{
            taskIDToJSONData = jsonDocParser.stateDocParser(id,jsonPath);
        }
        return taskIDToJSONData;
    }

    protected String retrieveJsonPath(String taskIDFromUserChoice){
        String jsonPath = "";
        switch (taskIDFromUserChoice){
            case "201":
                jsonPath = "bad_debt_tot_func_exp_pct";
                break;
            case "202":
                jsonPath = "bad_debt";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }
    public void getTitle(String jsonPath){
        switch (jsonPath){
            case "bad_debt_tot_func_exp_pct":
                title = "Bad debt as a % of Total Functional Expenses";
                break;
            case "bad_debt":
                title = "General Bad Debt";
                break;
                default:
                ErrorProcessor.displayErrorMessage("Could not find title...");
        }
        System.out.printf("%30s\n", title);
    }
    protected String formatNumericJsonData(String jsonFile) throws IOException, URISyntaxException {
        StringBuilder numericFormat = new StringBuilder();

        String[] jsonDataArray = jsonFile.replace("[", "").replace("]", "").replace("\"", "").split(",");
        String[] jsonYearArray = jsonDocParser.yearDocParser(UserInput.getHospitalID()).replace("[", "").replace("]", "").replace("\"", "").split(",");

        for (int i = 0; i < Math.min(jsonDataArray.length, jsonYearArray.length); i++) {
            int tempNumeric;
            String valueString = jsonDataArray[i].trim();

            try{
                tempNumeric = Integer.parseInt(valueString);
            } catch (NumberFormatException e){
                double tempDecimal = Double.parseDouble(valueString);
                String formattedPercentage = nf.format(tempDecimal);
                String year = jsonYearArray[i].trim();
                numericFormat.append(String.format("%20s %s%n", formattedPercentage, year));
                continue;
            }

            String formattedValue = df.format(tempNumeric);
            String year = jsonYearArray[i].trim();

            numericFormat.append(String.format("%20s %s%n", formattedValue, year));
        }
        return numericFormat.toString();
    }
}

