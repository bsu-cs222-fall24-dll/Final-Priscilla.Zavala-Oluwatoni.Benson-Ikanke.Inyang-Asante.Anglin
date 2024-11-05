package edu.bsu.cs;
import java.io.IOException;
import java.net.URISyntaxException;


public class AuditorView {
    private final AuditorModel model = new AuditorModel();
    public void displayFormattedData(String jsonFile, String jsonPath) throws IOException, URISyntaxException {
        String numericalValue = model.formatNumericJsonData(jsonFile);
        model.getTitle(jsonPath);
        System.out.print(numericalValue); // Print the formatted numerical values
    }

}
