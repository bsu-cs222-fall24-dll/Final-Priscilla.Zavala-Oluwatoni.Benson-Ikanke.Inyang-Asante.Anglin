package edu.bsu.cs;

public class BuildURL {
    public String buildStateURL(String state) {
        return "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state;
    }

    public String buildHospitalURL(String hospital) {
        return "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=" + hospital;
    }
}
