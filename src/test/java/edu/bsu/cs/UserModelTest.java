package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserModelTest {
    @Test
    void testGetPositionCredentialCostAnalyst() {
        UserModel userModel = new UserModel();
        String costAnalystResult = userModel.getPositionCredential("100");
        assertEquals("Cost Analyst", costAnalystResult);
    }

    @Test
    void testGetPositionCredentialAuditor() {
        UserModel userModel = new UserModel();
        String auditorResult = userModel.getPositionCredential("200");
        assertEquals("Auditor", auditorResult);
    }

    @Test
    void testGetPositionCredentialInvalidCredential() {
        UserModel userModel = new UserModel();
        String invalidResult = userModel.getPositionCredential("");
        assertNull(invalidResult, "Expects null for invalid or empty credential ID");
    }
}
