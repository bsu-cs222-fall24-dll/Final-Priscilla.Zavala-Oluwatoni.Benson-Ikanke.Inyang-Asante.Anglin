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
    void testIsValidCredential_ValidCredential() {
        assertTrue(userModel.isValidCredential("100"), "Expected valid credential ID: 100");
        assertTrue(userModel.isValidCredential("200"), "Expected valid credential ID: 200");
    }

    @Test
    void testIsValidCredential_InvalidCredential() {
        assertFalse(userModel.isValidCredential("0"), "Expected invalid credential ID: 0");
        assertFalse(userModel.isValidCredential(""), "Expected invalid credential ID: empty string");
        assertFalse(userModel.isValidCredential(null), "Expected invalid credential ID: null");
    }

    @Test
    void testIsValidTaskForPosition_ValidTasks() {
        assertTrue(userModel.isValidTaskForPosition("Cost Analyst", "101"), "Expected valid task for Cost Analyst");
        assertTrue(userModel.isValidTaskForPosition("Auditor", "201"), "Expected valid task for Auditor");
    }

    @Test
    void testIsValidTaskForPosition_InvalidTasks() {
        assertFalse(userModel.isValidTaskForPosition("Cost Analyst", "108"), "Expected invalid task for Cost Analyst");
        assertFalse(userModel.isValidTaskForPosition("Auditor", "203"), "Expected invalid task for Auditor");
        assertFalse(userModel.isValidTaskForPosition("Nonexistent", "301"), "Expected invalid task for nonexistent position");
    }
}

