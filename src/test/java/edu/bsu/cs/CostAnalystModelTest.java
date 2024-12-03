package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostAnalystModelTest {
    private CostAnalystModel costAnalystModel;

    @BeforeEach
    public void setUp() {
        costAnalystModel = new CostAnalystModel();
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID101() {
        assertEquals("tot_revenue", costAnalystModel.retrieveJsonPath("101"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID102() {
        assertEquals("tot_func_exp", costAnalystModel.retrieveJsonPath("102"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID103() {
        assertEquals("subsd_hlth_svcs_tot_func_exp_pct", costAnalystModel.retrieveJsonPath("103"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID104() {
        assertEquals("hlth_prof_educ_tot_func_exp_pct", costAnalystModel.retrieveJsonPath("104"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID105() {
        assertEquals("tot_comm_bnfts", costAnalystModel.retrieveJsonPath("105"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID106() {
        assertEquals("chrty_care", costAnalystModel.retrieveJsonPath("106"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID107() {
        assertEquals("comm_hlth_impr_svcs_comm_bnft_oper", costAnalystModel.retrieveJsonPath("107"));
    }

    @Test
    void testRetrieveJsonPath_InvalidRoleID() {
        String result = costAnalystModel.retrieveJsonPath("999");
        assertEquals("", result);
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle1() {
        costAnalystModel.changeTitle("tot_revenue");
        assertEquals("Total Revenue", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle2() {
        costAnalystModel.changeTitle("tot_func_exp");
        assertEquals("Total Functional Expenses", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle3() {
        costAnalystModel.changeTitle("subsd_hlth_svcs_tot_func_exp_pct");
        assertEquals("Subsidized health services as % of total functional expenses", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle4() {
        costAnalystModel.changeTitle("hlth_prof_educ_tot_func_exp_pct");
        assertEquals("Health Professions Education as a % of Total Functional Expenses", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle5() {
        costAnalystModel.changeTitle("tot_comm_bnfts");
        assertEquals("Total Community Benefits", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle6() {
        costAnalystModel.changeTitle("chrty_care");
        assertEquals("Charity Care Expenses", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle7() {
        costAnalystModel.changeTitle("comm_hlth_impr_svcs_comm_bnft_oper");
        assertEquals("Community Health Improvement Services & Community Benefit Operations Cost", costAnalystModel.getTitle());
    }

    @Test
    void testChangeTitle_InvalidJsonPath() {
        costAnalystModel.changeTitle("invalid_path");
        //no use of assertion - testing invalid input handling
    }
}
