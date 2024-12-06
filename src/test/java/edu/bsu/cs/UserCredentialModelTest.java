package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserCredentialModelTest {
    private UserCredentialModel userCredentialModel;

    @BeforeEach
    public void setUp() {
        userCredentialModel = new UserCredentialModel();
    }

    @Test
    public void testIsValidCredential_withValidCredential100() {
        assertTrue(userCredentialModel.isValidCredential("100"));
    }

    @Test
    public void testIsValidCredential_withValidCredential200() {
        assertTrue(userCredentialModel.isValidCredential("200"));
    }

    @Test
    public void testIsValidCredential_withValidCredential300() {
        assertTrue(userCredentialModel.isValidCredential("300"));
    }

    @Test
    public void testIsValidCredential_withValidCredential400() {
        assertTrue(userCredentialModel.isValidCredential("400"));
    }

    @Test
    public void testIsValidCredential_withInvalidCredentialNull() {
        assertFalse(userCredentialModel.isValidCredential(null));
    }

    @Test
    public void testIsValidCredential_withInvalidCredentialEmptyString() {
        assertFalse(userCredentialModel.isValidCredential(""));
    }

    @Test
    public void testGetPositionByCredential_withValidCredentialCostAnalyst100() {
        assertEquals("Cost Analyst", userCredentialModel.getPositionByCredential("100"));
    }

    @Test
    public void testGetPositionByCredential_withValidCredentialAuditor200() {
        assertEquals("Auditor", userCredentialModel.getPositionByCredential("200"));
    }

    @Test
    public void testGetPositionByCredential_withValidCredentialHRDirector300() {
        assertEquals("HR Director", userCredentialModel.getPositionByCredential("300"));
    }

    @Test
    public void testGetPositionByCredential_withValidCredentialMedicaidDataAnalyst400() {
        assertEquals("Medicaid Data Analyst", userCredentialModel.getPositionByCredential("400"));
    }
}
