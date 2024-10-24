package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuildURLTest {
    private BuildURL buildURL;

    @BeforeEach
    public void setUp() {
        buildURL = new BuildURL();
    }

    @Test
    public void testIsValidState_EmptyString() {
        assertFalse(buildURL.isValidState(""));
    }

    @Test
    public void testIsValidState_ValidState() {
        assertTrue(buildURL.isValidState("CA"));
    }

    @Test
    public void testIsValidState_InvalidState() {
        assertFalse(buildURL.isValidState("ZZ"));
    }

    @Test
    public void testBuildStateHospitalURL() {
        String expectedHospitalsInStateURL = "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=OH";
        String testState = "OH";
        String outputURL = buildURL.buildStateHospitalURL(testState);
        assertEquals(expectedHospitalsInStateURL, outputURL);
    }

    @Test
    public void testBuildHospitalDataURL_EmptyHospitalID() {
        String expectedURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=";
        assertEquals(expectedURL, buildURL.buildHospitalDataURL(""));
    }

    @Test
    public void testBuildHospitalDataURL_NonNumericHospitalID() {
        String expectedURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=abc123";
        assertEquals(expectedURL, buildURL.buildHospitalDataURL("abc123"));
    }

    @Test
    public void testBuildHospitalDataURL() {
        String expectedHospitalDataURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=2303";
        String testHospitalID = "2303";
        String outputURL = buildURL.buildHospitalDataURL(testHospitalID);
        assertEquals(expectedHospitalDataURL, outputURL);
    }
}
