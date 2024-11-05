package edu.bsu.cs;

import java.io.IOException;
import java.net.*;

public class WebsiteURLConnection {
    protected static URLConnection connectURL(String id) throws URISyntaxException, IOException {
        BuildURL urlFormatter = new BuildURL();
        String urlString;
        if(StringUtils.isNumeric(id)){
            urlString = urlFormatter.buildHospitalDataURL(id);
        }else{
            urlString = urlFormatter.buildStateHospitalURL(id);
        }
        URL url = new URI(urlString).toURL();

        try {
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "HospitalDataAPIApp/0.1 (ikankeabasi.inyang@bsu.edu)");
            connection.connect();
            return connection;
        } catch (IOException e) {
            ErrorProcessor checkNetwork = new ErrorProcessor();
            checkNetwork.checkNetworkConnection(url);
            throw new IOException("Unable to connect to " +  urlString);
        }
    }
}