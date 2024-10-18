package edu.bsu.cs;

public class BuildURL {
    public String buildHospitalsInStateURL(String state) {
        return "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state;
    }

    public String buildHospitalDataURL(String hospital) {
        return "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=" + hospital;
    }
}
