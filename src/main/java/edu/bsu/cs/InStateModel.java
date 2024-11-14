package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class InStateModel extends JSONDocParser {

    protected String formatHospitalInfoJsonData() throws IOException, URISyntaxException {
        StringBuilder hospitalInfoFormat = new StringBuilder();

        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        String[] jsonHospitalNameArray = stateDocParser(UserInput.getStateID(), "name").replace("[", "").replace("]", "").split(regex);
        String[] jsonHospitalIDArray = stateDocParser(UserInput.getStateID(), "hospital_id").replace("[", "").replace("]", "").replace("\"", "").split(regex);

        int maxNameWidth = 0;
        for (String name : jsonHospitalNameArray) {
            maxNameWidth = Math.max(maxNameWidth, name.length());
        }

        for (int i = 0; i < Math.min(jsonHospitalNameArray.length, jsonHospitalIDArray.length); i++) {
            String hospitalName = jsonHospitalNameArray[i].trim();
            String hospitalID = jsonHospitalIDArray[i].trim();
            hospitalInfoFormat.append(String.format("%-"+ maxNameWidth +"s %s%n", hospitalName, hospitalID));
        }

        String hospitalTitle = "Hospital Name";
        int padding = (maxNameWidth - hospitalTitle.length()) / 2;
        System.out.printf("%"  + (padding + hospitalTitle.length()) + "s %" + ((maxNameWidth + 8) - padding - hospitalTitle.length()) + "s\n", "Hospital Name", "Hospital ID");
        return hospitalInfoFormat.toString();
    }
}