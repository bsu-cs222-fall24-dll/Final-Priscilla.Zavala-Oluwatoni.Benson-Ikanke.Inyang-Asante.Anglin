package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MedicaidDataAnalystModel {

    private String title;
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private final NumberFormat number = NumberFormat.getPercentInstance();
    private final JSONDocParser jsonDocParser = new JSONDocParser();

    protected String retrieveJsonPath(String taskIDFromUserChoice){
        String jsonPath = "";
        switch (taskIDFromUserChoice){
            case "401":
                jsonPath = "unreim_medcd_tot_func_exp_pct";
                break;
            case "402":
                jsonPath = "mdcre_shrtfl";
                break;
            case "403":
                jsonPath = "mdcre_shrtfl_tot_func_exp_pct";
                break;
            case "404":
                jsonPath = "tot_comm_bnfts";
                break;
            case "405":
                jsonPath = "rat_pat_care_npat_care_comm_bnfts";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }

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

    protected void getTitle(String jsonPath){
        switch (jsonPath){
            case "unreim_medcd_tot_func_exp_pct":
                title = "Unreimbursed Medicaid as % of Total Functional Expenses";
                break;
            case "mdcre_shrtfl":
                title = "Medicare Shortfall (Negative Value Indicates Surplus)";
                break;
            case "mdcre_shrtfl_tot_func_exp_pct":
                title = "Medicare Shortfall as % of Total Functional Expenses (Negative Value Indicates Surplus)";
                break;
            case "unreim_medcd":
                title = "Unreimbursed Medicaid";
                break;
            case "tot_comm_bnfts":
                title = "Total Community Benefits";
                break;
            case "rat_pat_care_npat_care_comm_bnfts":
                title = "Ratio of Patient Care to Non-patient Care Community Benefits";
                break;
            default:
                ErrorProcessor.displayErrorMessage("Could not find title...");
        }
        System.out.printf("%18s\n", title);
    }

    protected String formatNumericJsonData(String jsonFile) throws IOException, URISyntaxException {
        StringBuilder numericFormat = new StringBuilder();

        String[] jsonDataArray = jsonFile.replace("[", "").replace("]", "").replace("\"", "").split(",");
        String[] jsonYearArray = jsonDocParser.yearDocParser(UserInput.getHospitalID()).replace("[", "").replace("]", "").replace("\"", "").split(",");

        int maxNameWidth = 0;
        for (String name : jsonDataArray) {
            maxNameWidth = Math.max(maxNameWidth, name.length());
        }

        for (int i = 0; i < Math.min(jsonDataArray.length, jsonYearArray.length); i++) {
            long tempNumeric;
            String valueString = jsonDataArray[i].trim();

            try{
                tempNumeric = Long.parseLong(valueString);
            } catch (NumberFormatException e){
                double tempDecimal = Double.parseDouble(valueString);
                double shiftedLeft = tempDecimal / Math.pow(100, 1);
                String formattedPercentage = number.format(shiftedLeft);
                String year = jsonYearArray[i].trim();
                numericFormat.append(String.format("\t%-"+ maxNameWidth +"s %s%n", formattedPercentage, year));
                continue;
            }

            String formattedValue = decimalFormat.format(tempNumeric);
            String year = jsonYearArray[i].trim();

            int padding = (maxNameWidth - title.length()) / 2;
            numericFormat.append(String.format("%"  + (padding + title.length()) + "s %"+ ((maxNameWidth + 8 ) - padding - title.length()) + "s%n", formattedValue, year));
        }
        return numericFormat.toString();
    }
}