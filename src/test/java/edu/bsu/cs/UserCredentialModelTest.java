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
    public void testIsValidCredential_withValidCredential() {
        assertTrue(userCredentialModel.isValidCredential("100"));
        assertTrue(userCredentialModel.isValidCredential("200"));
    }

    @Test
    public void testIsValidCredential_withInvalidCredential() {
        assertFalse(userCredentialModel.isValidCredential("300"));
        assertFalse(userCredentialModel.isValidCredential(null));
        assertFalse(userCredentialModel.isValidCredential(""));
    }

    @Test
    public void testGetPositionByCredential_withValidCredential() {
        assertEquals("Cost Analyst", userCredentialModel.getPositionByCredential("100"));
        assertEquals("Auditor", userCredentialModel.getPositionByCredential("200"));
    }

    @Test
    public void testGetPositionByCredential_withInvalidCredential() {
        assertNull(userCredentialModel.getPositionByCredential("300"));
        assertNull(userCredentialModel.getPositionByCredential(""));
    }
}
