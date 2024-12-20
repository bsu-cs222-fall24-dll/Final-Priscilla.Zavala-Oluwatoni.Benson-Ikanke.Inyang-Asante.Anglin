package edu.bsu.cs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    //Helper method
    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void processSelectedHospital(
            String selectedHospital,
            PositionModel positionModel,
            String taskID) {
        try {
            //extracts hospital ID
            String hospitalID = extractFirstNumber(selectedHospital);
            String hospitalName = extractName(selectedHospital);

            //stores hospital ID globally to use in utility class
            UserInput.setHospitalID(hospitalID);
            UserInput.setHospitalName(hospitalName);

            String jsonPath = positionModel.retrieveJsonPath(taskID);
            String jsonFile = positionModel.retrieveJsonFile(hospitalID, jsonPath);

            positionModel.loadNumericJsonData(jsonFile);

            //validating data
            if (positionModel.getJsonDataArray() == null || positionModel.getJsonYearArray() == null) {
                AlertUtils.showError("No hospital data found");
            }
        } catch (Exception e) {
            AlertUtils.showError("Select state and task option");
        }
    }

    public static String extractFirstNumber(String str) {
        //handle null and/or empty strings
        if (str == null || str.isEmpty()) {
            return null;
        }

        //handle specified patterns
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static String extractName(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        // Define a regex to match the ID part: everything from "(ID:" followed by digits and closing parenthesis
        String regex = "\\s*\\(ID:\\s*\\d+\\)";

        return str.replaceAll(regex, "").trim();
    }
}
