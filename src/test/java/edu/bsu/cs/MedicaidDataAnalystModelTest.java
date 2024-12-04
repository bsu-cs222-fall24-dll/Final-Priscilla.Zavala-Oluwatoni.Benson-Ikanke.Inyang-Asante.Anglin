package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicaidDataAnalystModelTest {
    private MedicaidDataAnalystModel medicaidDataAnalystModel;

    @BeforeEach
    public void setUp() {
        medicaidDataAnalystModel = new MedicaidDataAnalystModel();
    }

    @Test
    void testRetrieveJsonPath_ValidTaskID401() {
        assertEquals("unreim_medcd_tot_func_exp_pct", medicaidDataAnalystModel.retrieveJsonPath("401"));
    }

    @Test
    void testRetrieveJsonPath_ValidTaskID402() {
        assertEquals("mdcre_shrtfl", medicaidDataAnalystModel.retrieveJsonPath("402"));
    }

    @Test
    void testRetrieveJsonPath_ValidTaskID403() {
        assertEquals("mdcre_shrtfl_tot_func_exp_pct", medicaidDataAnalystModel.retrieveJsonPath("403"));
    }

    @Test
    void testRetrieveJsonPath_InvalidTaskID() {
        String result = medicaidDataAnalystModel.retrieveJsonPath("999");
        assertEquals("", result);
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle1() {
        medicaidDataAnalystModel.changeTitle("unreim_medcd_tot_func_exp_pct");
        assertEquals("Unreimbursed Medicaid as % of Total Functional Expenses", medicaidDataAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle2() {
        medicaidDataAnalystModel.changeTitle("mdcre_shrtfl");
        assertEquals("Medicare Shortfall (Negative Value Indicates Surplus)", medicaidDataAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_InvalidJsonPath() {
        medicaidDataAnalystModel.changeTitle("invalid_path");
    }
}