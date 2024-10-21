package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class JSONDocParser {
    //user selects what information they would like to view
    //jsonPath being the information variable
    //method parses that data and returns it
    protected String hospitalDocParser(String hospitalID, String jsonPath) throws IOException, URISyntaxException {
        String jsonFile = jsonHospitalDocFormatter(hospitalID);
        JSONArray hospitalDoc = JsonPath.read(jsonFile, "$.." + jsonPath);
        return hospitalDoc.toString();
    }

    protected String jsonHospitalDocFormatter(String hospitalID) throws IOException, URISyntaxException {
        String articleJSON;
        BuildURL buildURL = new BuildURL();
        String wikiTitleURL = buildURL.buildHospitalDataURL(hospitalID);
        URLConnection wikiConnection = WebsiteURLConnection.connectHospitalURL(wikiTitleURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(wikiConnection.getInputStream()));
        articleJSON = readJSONFromArticleData(in);
        in.close();
        return articleJSON;
    }

    public String readJSONFromArticleData(BufferedReader articleData) throws IOException {
        //StringBuilder for concatenation with BufferedReader
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = articleData.readLine()) != null) {
            json.append(line);
        }
        //convert StringBuilder back to string
        return json.toString();
    }
}
