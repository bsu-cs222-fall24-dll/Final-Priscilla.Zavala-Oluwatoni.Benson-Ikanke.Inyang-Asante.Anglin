package edu.bsu.cs;

import io.github.cdimascio.dotenv.Dotenv;

public class BuildURL {
    UserView error = new UserView();
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("API_KEY");

    public boolean isValidState(String state) {
        try {
            StateAbbreviation.valueOf(state);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isValidHospital(String hospital) {
        //pattern "\\d+" checks string consists of only digits
        return hospital != null && !hospital.isEmpty() && hospital.matches("\\d+");
    }

    //cannot make unit test - view code
    public String stateValidator() {
        while (true) {
            String state = UserInput.stateInput();
            if (isValidState(state)) {
                return state;
            } else {
                error.displayErrorMessage("Please enter a valid state abbreviation.");
            }
        }
    }

    public String buildStateHospitalURL(String state) {
        return "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state + "&" + apiKey;
    }

    public String buildHospitalDataURL(String hospital) {
        return "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=" + hospital + "&" + apiKey;
    }
}
