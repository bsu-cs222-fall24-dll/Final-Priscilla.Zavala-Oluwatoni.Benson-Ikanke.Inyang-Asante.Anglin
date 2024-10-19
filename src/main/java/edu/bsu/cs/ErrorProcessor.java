package edu.bsu.cs;

import java.io.IOException;
import java.net.URL;

public class ErrorProcessor {
    public static void checkNetworkConnection(URL url) {
        try{
            url.openConnection().connect();
        } catch (IOException e) {
            System.err.println("Trouble connecting to the internet...");
        }
    }
}
