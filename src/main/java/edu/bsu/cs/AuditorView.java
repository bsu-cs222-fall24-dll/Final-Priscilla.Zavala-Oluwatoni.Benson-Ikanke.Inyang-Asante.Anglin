package edu.bsu.cs;
import java.io.IOException;
import java.net.URISyntaxException;


public class AuditorView extends PositionView{
    private final AuditorModel model = new AuditorModel();

    public AuditorView(PositionModel model) {
        super(model);
    }

    @Override
    public void displayFormattedData(String jsonFile, String jsonPath) throws IOException, URISyntaxException {
        model.changeTitle(jsonPath);
        System.out.print(jsonFile);
    }
}