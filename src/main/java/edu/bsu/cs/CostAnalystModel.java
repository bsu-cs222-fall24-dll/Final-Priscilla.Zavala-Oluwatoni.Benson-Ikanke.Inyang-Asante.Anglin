package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CostAnalystModel {

    DecimalFormat df = new DecimalFormat("###,###,###,###");
    NumberFormat nf = NumberFormat.getPercentInstance();
    JSONDocParser jsonDocParser = new JSONDocParser();

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
            case "101":
                jsonPath = "tot_revenue";
                break;
            case "102":
                jsonPath = "tot_func_exp";
                break;
            case "103":
                jsonPath = "subsd_hlth_svcs_tot_func_exp_pct";
                break;
            case "104":
                jsonPath = "hlth_prof_educ_tot_func_exp_pct";
                break;
            case "105":
                jsonPath = "tot_comm_bnfts";
                break;
            case "106":
                jsonPath = "chrty_care";
                break;
            case "107":
                jsonPath = "comm_hlth_impr_svcs_comm_bnft_oper";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }

    public void getTitle(String jsonPath){
        switch (jsonPath){
            case "tot_revenue":
                title = "Total Revenue";
                break;
            case "tot_func_exp":
                title = "Total Functional Expenses";
                break;
            case "subsd_hlth_svcs_tot_func_exp_pct":
                title = "Subsidized health services as % of total functional expenses";
                break;
            case "hlth_prof_educ_tot_func_exp_pct":
                title = "Health Professions Education as a % of Total Functional Expenses";
                break;
            case "tot_comm_bnfts":
                title = "Total Community Benefits";
                break;
            case "chrty_care":
                title = "Charity Care";
                break;
            case "comm_hlth_impr_svcs_comm_bnft_oper":
                title = "Community Health Improvement";
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
            long tempNumeric;
            String valueString = jsonDataArray[i].trim();

            try{
                tempNumeric = Long.parseLong(valueString);
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