package edu.bsu.cs;

import java.io.IOException;
import java.net.*;

public class WebsiteURLConnection{
    protected static URLConnection connectURL(String id) throws URISyntaxException, IOException {
        BuildURL urlFormatter = new BuildURL();
        String urlString;
        if(isNumeric(id)){
            urlString = urlFormatter.buildHospitalDataURL(id);
        }else{
            urlString = urlFormatter.buildHospitalsInStateURL(id);
        }
        URL url = new URI(urlString).toURL();

        try {
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "HospitalDataAPIApp/0.1 (ikankeabasi.inyang@bsu.edu)");
            connection.connect();
            return connection;
        } catch (IOException e) {
            ErrorProcessor.checkNetworkConnection(url);
            throw new IOException("Unable to connect to " +  urlString);
        }
    }

    //Helper method
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);  // Try to parse the string to an integer
            return true;            // If parsing succeeds, it's a number
        } catch (NumberFormatException e) {
            return false;           // If parsing fails, it's not a number
        }
    }
}