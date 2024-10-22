package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

public class JSONDocParser extends JSONReaderFormatter {
    protected String stateDocParser(String stateID, String jsonPath) throws IOException, URISyntaxException {
        String jsonFile = jsonDocFormatter(stateID);
        JSONArray stateDoc = JsonPath.read(jsonFile, "$.." + jsonPath);
        return stateDoc.toString();
    }

    protected String hospitalDocParser(String hospitalID, String jsonPath) throws IOException, URISyntaxException {
        String jsonFile = jsonDocFormatter(hospitalID);
        JSONArray hospitalDoc = JsonPath.read(jsonFile, "$.." + jsonPath);
        return hospitalDoc.toString();
    }
}
