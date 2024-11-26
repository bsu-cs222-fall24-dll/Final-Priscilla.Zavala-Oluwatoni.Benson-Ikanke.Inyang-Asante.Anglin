package edu.bsu.cs;

public class AuditorView extends PositionView{

    public AuditorView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath){
        model.changeTitle(jsonPath);
        System.out.print(jsonFile); // Print the formatted numerical values
    }
}