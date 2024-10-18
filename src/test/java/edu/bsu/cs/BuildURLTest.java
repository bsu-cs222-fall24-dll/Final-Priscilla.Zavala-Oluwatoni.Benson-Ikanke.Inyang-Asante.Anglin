package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuildURLTest {
    @Test
    public void testBuildHospitalsInStateURL() {
        String expectedHospitalsInStateURL = "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=OH";
        String testState = "OH";
        BuildURL testStateURL = new BuildURL();
        String outputURL = testStateURL.buildHospitalsInStateURL(testState);
        Assertions.assertEquals(expectedHospitalsInStateURL, outputURL);
    }

    @Test
    public void testBuildHospitalDataURL() {
        String expectedHospitalDataURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=2303";
        String testHospitalID = "2303";
        BuildURL testHospitalDataURL = new BuildURL();
        String outputURL = testHospitalDataURL.buildHospitalDataURL(testHospitalID);
        Assertions.assertEquals(expectedHospitalDataURL, outputURL);
    }
}
