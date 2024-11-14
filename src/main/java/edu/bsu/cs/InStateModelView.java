package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class InStateModelView {
    InStateModel model = new InStateModel();

    public void displayHospitalsByState() throws IOException, URISyntaxException {
        System.out.println(model.formatHospitalInfoJsonData());
    }
}
