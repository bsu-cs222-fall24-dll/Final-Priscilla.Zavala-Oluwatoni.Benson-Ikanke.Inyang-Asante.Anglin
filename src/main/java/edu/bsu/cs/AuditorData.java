package edu.bsu.cs;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

public class AuditorData extends JSONReaderFormatter {
    //this is in reference to the instance in which this method is being stored to parse JSon Data
    private final JSONDocParser parser;

    //need to implement constructor after the instance
    public AuditorData() {
        this.parser = new JSONDocParser();
    }

    //we have to now use this method to now implement retrieval of the data
    public String retrieveStateData(String stateID, String jsonPath) throws IOException, URISyntaxException {

        String parseData = parser.stateDocParser(stateID, jsonPath);
        System.out.println("Parsed state data:" + stateID + ":");
        System.out.println(parseData);
        JSONArray stateDoc = JsonPath.read(parseData,"$..");
        return stateDoc.toString();
    }

    public String retrieveHospitalData(String hospitalID, String jsonPath) throws IOException, URISyntaxException {
        String parseData = parser.hospitalDocParser(hospitalID, jsonPath);
        System.out.println("Parsed Hospital data" + hospitalID + ":");
        System.out.println(parseData);
        JSONArray hospitalDoc = JsonPath.read(parseData,"$..");
        return hospitalDoc.toString();
    }

}



