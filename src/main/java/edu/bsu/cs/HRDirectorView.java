package edu.bsu.cs;

public class HRDirectorView extends PositionView {
    private final HRDirectorModel model = new HRDirectorModel();

    public HRDirectorView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath) {
        model.changeTitle(jsonPath);
        System.out.print(jsonFile);
    }
}