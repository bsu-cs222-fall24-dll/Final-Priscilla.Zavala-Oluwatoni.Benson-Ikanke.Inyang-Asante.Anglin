package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRDirectorModelTest {
    private HRDirectorModel hrDirectorModel;

    @BeforeEach
    public void setUp() {
        hrDirectorModel = new HRDirectorModel();
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID301() {
        assertEquals("comm_bldg_actvs", hrDirectorModel.retrieveJsonPath("301"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID302() {
        assertEquals("comm_bldg_actvs_cmntysuprt", hrDirectorModel.retrieveJsonPath("302"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID303() {
        assertEquals("comm_hlth_impr_svcs_comm_bnft_oper", hrDirectorModel.retrieveJsonPath("303"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID304() {
        assertEquals("comm_bldg_actvs_ldrdevlp", hrDirectorModel.retrieveJsonPath("304"));
    }

    @Test
    void testRetrieveJsonPath_ValidRoleID305() {
        assertEquals("tot_comm_bnfts", hrDirectorModel.retrieveJsonPath("305"));
    }

    @Test
    void testRetrieveJsonPath_InvalidRoleID() {
        String result = hrDirectorModel.retrieveJsonPath("999");
        assertEquals("", result);
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle1() {
        hrDirectorModel.changeTitle("comm_bldg_actvs");
        assertEquals("Community Building Activities", hrDirectorModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle2() {
        hrDirectorModel.changeTitle("comm_bldg_actvs_cmntysuprt");
        assertEquals("Community Building Activities - Community Support", hrDirectorModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle3() {
        hrDirectorModel.changeTitle("comm_hlth_impr_svcs_comm_bnft_oper");
        assertEquals("Community Health Improvement Services", hrDirectorModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle4() {
        hrDirectorModel.changeTitle("comm_bldg_actvs_ldrdevlp");
        assertEquals("Community Building Activities - Leadership Development", hrDirectorModel.getTitle());
    }

    @Test
    void testChangeTitle_ValidJsonPathTitle5() {
        hrDirectorModel.changeTitle("tot_comm_bnfts");
        assertEquals("Total Community Benefits", hrDirectorModel.getTitle());
    }

    @Test
    void testChangeTitle_InvalidJsonPath() {
        hrDirectorModel.changeTitle("invalid_path");
        //no use of assertion - testing invalid input handling
    }
}
