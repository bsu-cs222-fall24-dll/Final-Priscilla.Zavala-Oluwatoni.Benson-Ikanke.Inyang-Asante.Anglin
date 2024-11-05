package edu.bsu.cs;

import net.minidev.json.JSONUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class InStateModel extends JSONDocParser {
    protected String retrieveHospitalsInStateJson(String state, String jsonNamePath, String jsonIDPath) throws IOException, URISyntaxException {
        JSONReaderFormatter jsonReaderFormatter = new JSONReaderFormatter();
        JSONDocParser jsonDocParser = new JSONDocParser();
        jsonReaderFormatter.jsonDocFormatter(state);

        //parses and retrieves hospital data based on state and jsonPath
        return jsonDocParser.stateDocParser(jsonNamePath, jsonIDPath);
    }


    protected String formatHospitalInfoJsonData(String jsonFile) throws IOException, URISyntaxException {
        StringBuilder hospitalInfoFormat = new StringBuilder();

        //splits json data to arrays for names and ids
        //String[] jsonHospitalInfoArray = jsonFile.replace("[", "").replace("]", "").replace("\"", "").split(",");
        String[] jsonHospitalNameArray = stateDocParser(UserInput.stateInput(), "name").replace("[", "").replace("]", "").replace("\"", "").split(",");
        //TODO: hospital ID prompt is being called twice (1)
        String[] jsonHospitalIDArray = stateDocParser(UserInput.hospitalIDInput(), "hospital_id").replace("[", "").replace("]", "").replace("\"", "").split(",");


        for (int i = 0; i < Math.min(jsonHospitalNameArray.length, jsonHospitalIDArray.length); i++) {
            //TODO: define name and id to print out in append
            String hospitalName = jsonHospitalNameArray[i].trim();
            String hospitalID = jsonHospitalIDArray[i].trim();
            hospitalInfoFormat.append(String.format("%20s %s%n", hospitalName, hospitalID));
            System.out.println(Arrays.toString(jsonHospitalNameArray));
            System.out.println(Arrays.toString(jsonHospitalIDArray));
        }
        return hospitalInfoFormat.toString();
    }

}
