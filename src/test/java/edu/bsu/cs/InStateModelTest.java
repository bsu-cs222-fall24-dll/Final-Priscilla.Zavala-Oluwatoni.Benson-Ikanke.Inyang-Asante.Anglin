package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class InStateModelTest {
    private InStateModel model;

    @BeforeEach
    public void setUp() {
        model = new InStateModel();
    }

    @Test
    public void testLoadHospitalData_ValidStateNameArray() throws IOException, URISyntaxException {
        model.loadHospitalData("IN");
        assertNotNull(model.getJsonHospitalNameArray());
    }

    @Test
    public void testLoadHospitalData_ValidStateIDArray() throws IOException, URISyntaxException {
        model.loadHospitalData("IN");
        assertNotNull(model.getJsonHospitalIDArray());
    }

    @Test
    public void testLoadHospitalData_ValidStateNameArrayLength() throws IOException, URISyntaxException {
        model.loadHospitalData("IN");
        assertTrue(model.getJsonHospitalNameArray().length > 0);
    }

    @Test
    public void testLoadHospitalData_ValidStateIDArrayLength() throws IOException, URISyntaxException {
        model.loadHospitalData("IN");
        assertTrue(model.getJsonHospitalIDArray().length > 0);
    }

    @Test
    public void testGetJsonHospitalNameArray_EmptyBeforeLoad() {
        assertNull(model.getJsonHospitalNameArray());
    }
}
