package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskSpecificationModelTest {
    private final TaskSpecificationModel model = new TaskSpecificationModel();

    @Test
    void testIsValidCostAnalystSpecification_ValidIDs() {
        assertTrue(model.isValidCostAnalystSpecification("101"), "Expected valid ID: 101");
        assertTrue(model.isValidCostAnalystSpecification("102"), "Expected valid ID: 102");
        assertTrue(model.isValidCostAnalystSpecification("103"), "Expected valid ID: 103");
        assertTrue(model.isValidCostAnalystSpecification("104"), "Expected valid ID: 104");
        assertTrue(model.isValidCostAnalystSpecification("105"), "Expected valid ID: 105");
        assertTrue(model.isValidCostAnalystSpecification("106"), "Expected valid ID: 106");
        assertTrue(model.isValidCostAnalystSpecification("107"), "Expected valid ID: 107");
    }

    @Test
    void testIsValidCostAnalystSpecification_InvalidIDs() {
        assertFalse(model.isValidCostAnalystSpecification("108"), "Expected invalid ID: 108");
        assertFalse(model.isValidCostAnalystSpecification("999"), "Expected invalid ID: 999");
        assertFalse(model.isValidCostAnalystSpecification(""), "Expected invalid ID: empty string");
        assertFalse(model.isValidCostAnalystSpecification(null), "Expected invalid ID: null");
    }

    @Test
    void testIsValidAuditorSpecification_ValidIDs() {
        assertTrue(model.isValidAuditorSpecification("201"), "Expected valid ID: 201");
        assertTrue(model.isValidAuditorSpecification("202"), "Expected valid ID: 202");
    }

    @Test
    void testIsValidAuditorSpecification_InvalidIDs() {
        assertFalse(model.isValidAuditorSpecification("203"), "Expected invalid ID: 203");
        assertFalse(model.isValidAuditorSpecification("999"), "Expected invalid ID: 999");
        assertFalse(model.isValidAuditorSpecification(""), "Expected invalid ID: empty string");
        assertFalse(model.isValidAuditorSpecification(null), "Expected invalid ID: null");
    }
}
