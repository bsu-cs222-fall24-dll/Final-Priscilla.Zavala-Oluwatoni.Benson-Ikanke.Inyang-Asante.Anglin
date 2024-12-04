package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class InStateModelView {
    private final InStateModel model;

    public InStateModelView() {
        this.model = new InStateModel(); //instantiate model internally
    }

    //NOT model code, view code for formatting data
    protected String formatHospitalInfoJsonData(String[] hospitalNames, String[] hospitalIDs) {
        StringBuilder hospitalInfoFormat = new StringBuilder();

        int maxNameWidth = 0;
        for (String name : hospitalNames) {
            maxNameWidth = Math.max(maxNameWidth, name.length());
        }

        for (int i = 0; i < Math.min(hospitalNames.length, hospitalIDs.length); i++) {
            String hospitalName = hospitalNames[i].trim();
            String hospitalID = hospitalIDs[i].trim();
            hospitalInfoFormat.append(String.format("%-"+ maxNameWidth +"s %s%n", hospitalName, hospitalID));
        }

        String hospitalTitle = "Hospital Name";
        int padding = (maxNameWidth - hospitalTitle.length()) / 2;
        System.out.printf("%"  + (padding + hospitalTitle.length()) + "s %" + ((maxNameWidth + 8) - padding - hospitalTitle.length()) + "s\n", "Hospital Name", "Hospital ID");
        return hospitalInfoFormat.toString();
    }

    public void displayHospitalsByState(String state) throws IOException, URISyntaxException {
        model.loadHospitalData(state);
        String[] hospitalNames = model.getJsonHospitalNameArray();
        String[] hospitalIDs = model.getJsonHospitalIDArray();

        String formattedData = formatHospitalInfoJsonData(hospitalNames, hospitalIDs);
        System.out.println(formattedData);
    }
}
