package edu.bsu.cs;

public class BuildURL {
    public String stateValidatorAndBuildURL() {
        while (true) {
            String state = UserInput.stateInput();
            try {
                return buildStateHospitalURL(state);
            } catch (IllegalArgumentException e) {
                UserView error = new UserView();
                error.displayErrorMessage(e.getMessage());
            }
        }
    }

    public String buildStateHospitalURL(String state) {
        try {
            StateAbbreviation.valueOf(state);
            return "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please enter a valid state abbreviation.");
        }
    }

    public String buildHospitalDataURL(String hospital) {
        return "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=" + hospital;
    }
}
