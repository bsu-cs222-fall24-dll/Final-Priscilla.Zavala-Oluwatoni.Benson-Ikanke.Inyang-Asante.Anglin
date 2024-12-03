package edu.bsu.cs;

public abstract class PositionView {

    protected PositionModel model;

    public PositionView(PositionModel model) {
        this.model = model;
    }

    //display formatted numeric data, calling model's format method
    public void displayFormattedData(String jsonFile, String jsonPath) {
        System.out.print(jsonFile);
    }
}