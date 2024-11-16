package edu.bsu.cs;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.*;

public class WebsiteURLConnection {
    protected static URLConnection connectURL(String id) throws URISyntaxException, IOException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        BuildURL urlFormatter = new BuildURL();
        String urlString;
        if(StringUtils.isNumeric(id)){
            urlString = urlFormatter.buildHospitalDataURL(id);
        }else{
            urlString = urlFormatter.buildStateHospitalURL(id);
        }
        URL url = new URI(urlString).toURL();

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("User-Agent",
                    "HospitalDataAPIApp/0.1 (ikankeabasi.inyang@bsu.edu)");
            connection.connect();
            return connection;
        } catch (IOException e){
            ErrorProcessor.checkNetworkConnection(url);
            throw new IOException("Unable to connect to " +  urlString);
        }
    }
}