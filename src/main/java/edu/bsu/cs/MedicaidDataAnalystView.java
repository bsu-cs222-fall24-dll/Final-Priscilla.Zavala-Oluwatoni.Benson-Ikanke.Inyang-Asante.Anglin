package edu.bsu.cs;

public class MedicaidDataAnalystView extends PositionView{
    private final MedicaidDataAnalystModel model = new MedicaidDataAnalystModel();

    public MedicaidDataAnalystView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath){
        model.changeTitle(jsonPath);
        System.out.print(jsonFile); // Print the formatted numerical values
    }
}