package edu.bsu.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class JSONReaderFormatter {
    protected String jsonDocFormatter(String id) throws IOException, URISyntaxException {
        String articleJSON;
        URLConnection connection = WebsiteURLConnection.connectURL(id);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        articleJSON = readJSONData(in);
        in.close();
        return articleJSON;
    }

    private String readJSONData(BufferedReader articleData) throws IOException {
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