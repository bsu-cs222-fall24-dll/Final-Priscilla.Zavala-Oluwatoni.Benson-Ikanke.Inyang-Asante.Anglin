package edu.bsu.cs;

public class BuildURL {
    UserView error = new UserView();

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

    public String hospitalValidatorBuildURL() {
        while(true) {
            String hospital = UserInput.hospitalIDInput();
            if (isValidHospital(hospital)) {
                return buildHospitalDataURL(hospital);
            } else {
                error.displayErrorMessage("Please enter a valid hospital ID.");
            }
        }
    }

    public String stateValidatorBuildURL() {
        while (true) {
            String state = UserInput.stateInput();
            if (isValidState(state)) {
                return buildStateHospitalURL(state);
            } else {
                error.displayErrorMessage("Please enter a valid state abbreviation.");
            }
        }
    }

    public String buildStateHospitalURL(String state) {
        return "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state;
    }

    public String buildHospitalDataURL(String hospital) {
        return "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=" + hospital;
    }
}
