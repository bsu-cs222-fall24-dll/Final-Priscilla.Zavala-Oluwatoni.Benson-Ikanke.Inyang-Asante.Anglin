package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskSpecificationModelTest {
    private final TaskSpecificationModel model = new TaskSpecificationModel();

    @Test
    void testIsValidCostAnalystSpecification_ValidID101() {
        assertTrue(model.isValidCostAnalystSpecification("101"), "Expected valid ID: 101");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID102() {
        assertTrue(model.isValidCostAnalystSpecification("102"), "Expected valid ID: 102");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID103() {
        assertTrue(model.isValidCostAnalystSpecification("103"), "Expected valid ID: 103");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID104() {
        assertTrue(model.isValidCostAnalystSpecification("104"), "Expected valid ID: 104");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID105() {
        assertTrue(model.isValidCostAnalystSpecification("105"), "Expected valid ID: 105");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID106() {
        assertTrue(model.isValidCostAnalystSpecification("106"), "Expected valid ID: 106");
    }

    @Test
    void testIsValidCostAnalystSpecification_ValidID107() {
        assertTrue(model.isValidCostAnalystSpecification("107"), "Expected valid ID: 107");
    }

    @Test
    void testIsValidCostAnalystSpecification_InvalidIDOver() {
        assertFalse(model.isValidCostAnalystSpecification("108"), "Expected invalid ID: 108");
    }

    @Test
    void testIsValidCostAnalystSpecification_InvalidIDEmptyString() {
        assertFalse(model.isValidCostAnalystSpecification(""), "Expected invalid ID: empty string");
    }

    @Test
    void testIsValidCostAnalystSpecification_InvalidIDNull() {
        assertFalse(model.isValidCostAnalystSpecification(null), "Expected invalid ID: null");
    }

    @Test
    void testIsValidAuditorSpecification_ValidID201() {
        assertTrue(model.isValidAuditorSpecification("201"), "Expected valid ID: 201");
    }

    @Test
    void testIsValidAuditorSpecification_ValidID202() {
        assertTrue(model.isValidAuditorSpecification("202"), "Expected valid ID: 202");
    }

    @Test
    void testIsValidAuditorSpecification_InvalidIDOver() {
        assertFalse(model.isValidAuditorSpecification("203"), "Expected invalid ID: 203");
    }

    @Test
    void testIsValidAuditorSpecification_InvalidIDEmptyString() {
        assertFalse(model.isValidAuditorSpecification(""), "Expected invalid ID: empty string");
    }

    @Test
    void testIsValidAuditorSpecification_InvalidIDNull() {
        assertFalse(model.isValidAuditorSpecification(null), "Expected invalid ID: null");
    }
}
