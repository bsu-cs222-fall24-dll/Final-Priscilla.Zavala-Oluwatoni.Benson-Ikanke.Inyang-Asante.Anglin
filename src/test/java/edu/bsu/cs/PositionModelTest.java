package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class PositionModelTest {

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
    }

    private TestPositionModel positionModel;

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
}
