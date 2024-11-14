package edu.bsu.cs;

public class CostAnalystView extends PositionView{

    public CostAnalystView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath){
        model.changeTitle(jsonPath);
        System.out.print(jsonFile); // Print the formatted numerical values
    }
}