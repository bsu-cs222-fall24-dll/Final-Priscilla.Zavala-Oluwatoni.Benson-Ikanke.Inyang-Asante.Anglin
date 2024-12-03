package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuditorModelTest {
    private AuditorModel auditorModel;

    @BeforeEach
    public void setUp() {
        auditorModel = new AuditorModel();
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID201() {
        assertEquals("bad_debt_tot_func_exp_pct", auditorModel.retrieveJsonPath("201"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID202() {
        assertEquals("bad_debt", auditorModel.retrieveJsonPath("202"));
    }

    @Test
    void testRetrieveJsonPath_InvalidRoleID() {
        String result = auditorModel.retrieveJsonPath("999");
        assertEquals("", result);
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle1() {
        auditorModel.changeTitle("bad_debt_tot_func_exp_pct");
        assertEquals("Bad debt as a % of Total Functional Expenses", auditorModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle2() {
        auditorModel.changeTitle("bad_debt");
        assertEquals("General Bad Debt", auditorModel.getTitle());
    }

    @Test
    void testChangeTitle_InvalidJsonPath() {
        auditorModel.changeTitle("invalid_path");
        //no use of assertion - testing invalid input handling
    }
}
