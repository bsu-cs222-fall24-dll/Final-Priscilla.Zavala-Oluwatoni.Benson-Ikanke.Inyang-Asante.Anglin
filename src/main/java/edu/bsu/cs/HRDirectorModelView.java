package edu.bsu.cs;

public class HRDirectorModelView extends PositionView {
    private final HRDirectorModel model = new HRDirectorModel();

    public HRDirectorModelView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath) {
        model.changeTitle(jsonPath);
        System.out.print(jsonFile);
    }
}