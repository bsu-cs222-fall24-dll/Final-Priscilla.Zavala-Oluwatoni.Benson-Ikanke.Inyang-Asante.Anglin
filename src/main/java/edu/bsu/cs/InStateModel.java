package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class InStateModel extends JSONDocParser {
    private String[] jsonHospitalNameArray;
    private String[] jsonHospitalIDArray;

    public void loadHospitalData(String state) throws IOException, URISyntaxException {
        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        jsonHospitalNameArray = stateDocParser(state, "name").replace("[", "").replace("]", "").split(regex);
        jsonHospitalIDArray = stateDocParser(state, "hospital_id").replace("[", "").replace("]", "").replace("\"", "").split(regex);
    }

    public String[] getJsonHospitalNameArray() {
        return jsonHospitalNameArray;
    }

    public String[] getJsonHospitalIDArray(){
        return jsonHospitalIDArray;
    }
}