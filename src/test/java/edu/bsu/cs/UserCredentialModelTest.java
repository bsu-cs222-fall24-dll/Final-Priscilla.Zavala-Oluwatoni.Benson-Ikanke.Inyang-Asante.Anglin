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
}
