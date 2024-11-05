package edu.bsu.cs;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URISyntaxException;

public class AuditorData extends JSONReaderFormatter {
    private final JSONDocParser parser;

    public AuditorData() {
        this.parser = new JSONDocParser();
    }

    public String retrieveStateData(String stateID, String jsonPath) throws IOException, URISyntaxException {

        String parseData = parser.stateDocParser(stateID, jsonPath);
        System.out.println("Parsed state data:" + stateID + ":");
        System.out.println(parseData);
        JSONArray stateDoc = JsonPath.read(parseData,"$..");
        return stateDoc.toString();
    }
        System.out.println(parseData);
        JSONArray hospitalDoc = JsonPath.read(parseData,"$..");
        return hospitalDoc.toString();
    }
}

