package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

public class JSONDocParser extends JSONReaderFormatter {
    protected String stateDocParser(String state, String jsonPath) throws IOException, URISyntaxException {
        String jsonFile = jsonDocFormatter(state);
        JSONArray stateDoc = JsonPath.read(jsonFile, "$.." + jsonPath);
        return stateDoc.toString();
    }

    protected String hospitalDocParser(String hospitalID, String jsonPath) throws IOException, URISyntaxException {

        String jsonFile = jsonDocFormatter(hospitalID);
        JSONArray hospitalDoc = JsonPath.read(jsonFile, "$.." + jsonPath);
        return hospitalDoc.toString();
    }

    protected String yearDocParser(String hospitalID) throws IOException, URISyntaxException {
        String jsonFile = jsonDocFormatter(hospitalID);
        JSONArray hospitalDoc = JsonPath.read(jsonFile, "$..fiscal_yr");
        return hospitalDoc.toString();
    }
}
