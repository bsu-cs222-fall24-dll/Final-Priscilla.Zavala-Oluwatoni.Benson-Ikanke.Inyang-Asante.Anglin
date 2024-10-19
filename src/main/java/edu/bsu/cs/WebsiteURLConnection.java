package edu.bsu.cs;

import java.io.IOException;
import java.net.*;

public class WebsiteURLConnection{
    protected static URLConnection connectHospitalURL(String hospitalID) throws URISyntaxException, MalformedURLException {
        BuildURL hospitalURLFormatter = new BuildURL();
        String urlString = hospitalURLFormatter.buildHospitalDataURL(hospitalID);

        URL url = new URI(urlString).toURL();

        try {
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "HospitalDataAPIApp/0.1 (ikankeabasi.inyang@bsu.edu)");
            connection.connect();
            return connection;
        } catch (IOException e) {
            ErrorProcessor.checkNetworkConnection(url);
        }
        return null;
    }
}
