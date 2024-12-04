package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PositionModelTest {
    private TestPositionModel positionModel;

    //PositionModel is abstract class - create concrete subclass for testing
    static class TestPositionModel extends PositionModel {
        @Override
        protected String retrieveJsonPath(String taskIDFromUserChoice) {
            return "mock/path/for/" + taskIDFromUserChoice;
        }

        @Override
        protected void changeTitle(String jsonPath) {
            this.title = "Mock Title";
        }

        //call from model class for setting jsonDataArray (testing purposes only)
        public void setJsonDataArray(String[] jsonDataArray) {
            this.jsonDataArray = jsonDataArray;
        }
    }

    @BeforeEach
    void setUp() {
        positionModel = new TestPositionModel();
    }

    @Test
    void testGetJsonDataArray_initialState() {
        assertNull(positionModel.getJsonDataArray());
    }

    @Test
    void testGetJsonYearArray_initialState() {
        assertNull(positionModel.getJsonYearArray());
    }

    @Test
    void testCalculateMaxDataWidth_nonEmptyArray() {
        String[] testData = {"Short", "MediumLength", "ExtraLongStringHere"};
        positionModel.setJsonDataArray(testData);
        int maxWidth = positionModel.calculateMaxDataWidth();
        assertEquals(19, maxWidth, "The maximum width should match the longest string length.");
    }

    @Test
    void testCalculateMaxDataWidth_emptyArray() {
        String[] testData = {};
        positionModel.setJsonDataArray(testData);
        int maxWidth = positionModel.calculateMaxDataWidth();
        assertEquals(0, maxWidth, "The maximum width for an empty array should be 0.");
    }
}
