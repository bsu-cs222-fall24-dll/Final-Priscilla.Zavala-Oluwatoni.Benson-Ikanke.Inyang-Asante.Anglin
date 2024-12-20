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
        String expectedHospitalsInStateURL = "https://www.communitybenefitinsight.org/api/get_hospitals.php?state=OH&access_id=w2pF83jSz43nAnf82A49xFns32";
        String testState = "OH";
        String outputURL = buildURL.buildStateHospitalURL(testState);
        assertEquals(expectedHospitalsInStateURL, outputURL);
    }

    @Test
    public void testBuildHospitalDataURL_EmptyHospitalID() {
        String expectedURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=&access_id=w2pF83jSz43nAnf82A49xFns32";
        assertEquals(expectedURL, buildURL.buildHospitalDataURL(""));
    }

    @Test
    public void testBuildHospitalDataURL_NonNumericHospitalID() {
        String expectedURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=abc123&access_id=w2pF83jSz43nAnf82A49xFns32";
        assertEquals(expectedURL, buildURL.buildHospitalDataURL("abc123"));
    }

    @Test
    public void testBuildHospitalDataURL() {
        String expectedHospitalDataURL = "https://www.communitybenefitinsight.org/api/get_hospital_data.php?hospital_id=2303&access_id=w2pF83jSz43nAnf82A49xFns32";
        String testHospitalID = "2303";
        String outputURL = buildURL.buildHospitalDataURL(testHospitalID);
        assertEquals(expectedHospitalDataURL, outputURL);
    }

    @Test
    public void testIsValidHospital_ValidNumericID() {
        assertTrue(buildURL.isValidHospital("889"), "Expected valid hospital ID: 889");
    }

    @Test
    public void testIsValidHospital_EmptyString() {
        assertFalse(buildURL.isValidHospital(""), "Expected invalid hospital ID: empty string");
    }

    @Test
    public void testIsValidHospital_Null() {
        assertFalse(buildURL.isValidHospital(null), "Expected invalid hospital ID: null");
    }

    @Test
    public void testIsValidHospital_NonNumericID() {
        assertFalse(buildURL.isValidHospital("id"), "Expected invalid hospital ID: id");
    }
}
