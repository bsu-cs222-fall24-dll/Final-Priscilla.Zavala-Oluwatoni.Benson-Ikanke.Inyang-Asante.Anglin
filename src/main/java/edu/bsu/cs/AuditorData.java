package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URISyntaxException;


public class AuditorData extends JSONReaderFormatter {
    //this is reference to the instance in which this method is going to be parsed Json Data
    private final JSONDocParser parser;

    //need to implement the constructor after the method
    public AuditorData(){
        this.parser = new JSONDocParser();
    }
    //we have to now use this method to now implement retrieval of the data
    public String retrieveStateData(String stateID, String jsonPath) throws IOException, URISyntaxException{

        String parseData = parser.stateDocParser(stateID,jsonPath);
        System.out.println("Parsed state data:" + stateID + ":");
        System.out.println(parseData);
        JSONArray stateDoc = JsonPath.read(parseData,"$..");
        return  stateDoc.toString();
    }
    public String retrieveHospitalData(String hospitalData,String jsonPath) throws IOException, URISyntaxException{
        String parseData = parser.hospitalDocParser(hospitalData, jsonPath);
        System.out.println("Parsed hospital data:" + hospitalData + ":" );
        System.out.println(parseData);
        JSONArray hospitalDoc = JsonPath.read(parseData,"$..");
        return hospitalDoc.toString();
    }
}

