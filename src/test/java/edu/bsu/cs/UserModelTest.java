package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserModelTest {
    @Test
    void testGetPositionCredentialCostAnalyst() {
        UserModel userModel = new UserModel();
        String result = userModel.getPositionCredential("100");
        assertEquals(result, "Cost Analyst");
    }

    @Test
    void testGetPositionCredentialAuditor() {
        UserModel userModel = new UserModel();
        String result = userModel.getPositionCredential("200");
        assertEquals(result, "Auditor");
    }

    @Test
    void testGetPositionCredentialInvalidCredential() {
        UserModel userModel = new UserModel();
        String result = userModel.getPositionCredential("");
        assertNull(result, "Expects null for invalid or empty credential ID");
    }
}
