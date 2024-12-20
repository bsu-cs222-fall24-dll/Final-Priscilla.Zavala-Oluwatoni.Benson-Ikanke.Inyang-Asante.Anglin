package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTest {
    private UserModel userModel;

    @BeforeEach
    public void setUp() {
        userModel = new UserModel();
    }

    @Test
    void testGetPositionCredentialCostAnalyst() {
        String costAnalystResult = userModel.getPositionByCredential("100");
        assertEquals("Cost Analyst", costAnalystResult);
    }

    @Test
    void testGetPositionCredentialAuditor() {
        String auditorResult = userModel.getPositionByCredential("200");
        assertEquals("Auditor", auditorResult);
    }

    @Test
    void testGetPositionCredentialInvalidCredential() {
        String invalidResult = userModel.getPositionByCredential("");
        assertNull(invalidResult, "Expected null for invalid or empty credential ID");
    }

    @Test
    void testIsValidCredential_ValidCredential100() {
        assertTrue(userModel.isValidCredential("100"), "Expected valid credential ID: 100");
    }

    @Test
    void testIsValidCredential_ValidCredential200() {
        assertTrue(userModel.isValidCredential("200"), "Expected valid credential ID: 200");
    }

    @Test
    void testIsValidCredential_InvalidCredential0() {
        assertFalse(userModel.isValidCredential("0"), "Expected invalid credential ID: 0");
    }

    @Test
    void testIsValidCredential_InvalidCredentialEmptyString() {
        assertFalse(userModel.isValidCredential(""), "Expected invalid credential ID: empty string");
    }

    @Test
    void testIsValidCredential_InvalidCredentialNull() {
        assertFalse(userModel.isValidCredential(null), "Expected invalid credential ID: null");
    }

    @Test
    void testIsValidTaskForPosition_ValidTasksCostAnalyst101() {
        assertTrue(userModel.isValidTaskForPosition("Cost Analyst", "101"), "Expected valid task for Cost Analyst");
    }

    @Test
    void testIsValidTaskForPosition_ValidTasksAuditor201() {
        assertTrue(userModel.isValidTaskForPosition("Auditor", "201"), "Expected valid task for Auditor");
    }

    @Test
    void testIsValidTaskForPosition_ValidTasksHRDirector301() {
        assertTrue(userModel.isValidTaskForPosition("HR Director", "301"), "Expected valid task for HR Director");
    }

    @Test
    void testIsValidTaskForPosition_ValidTasksMedicaidDataAnalyst401() {
        assertTrue(userModel.isValidTaskForPosition("Medicaid Data Analyst", "401"), "Expected valid task for Medicaid Data Analyst");
    }

    @Test
    void testIsValidTaskForPosition_InvalidTasksCostAnalystInvalidID() {
        assertFalse(userModel.isValidTaskForPosition("Cost Analyst", "108"), "Expected invalid task for Cost Analyst");
    }

    @Test
    void testIsValidTaskForPosition_InvalidTasksAuditorInvalidID() {
        assertFalse(userModel.isValidTaskForPosition("Auditor", "203"), "Expected invalid task for Auditor");
    }

    @Test
    void testIsValidTaskForPosition_InvalidTasksHRDirectorInvalidID() {
        assertFalse(userModel.isValidTaskForPosition("HR Director", "308"), "Expected invalid task for HR Director");
    }

    @Test
    void testIsValidTaskForPosition_InvalidTasksMedicaidAnalystInvalidID() {
        assertFalse(userModel.isValidTaskForPosition("Medicaid Analyst", "408"), "Expected invalid task for Medicaid Analyst");
    }


}

