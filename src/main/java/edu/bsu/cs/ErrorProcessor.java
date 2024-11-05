package edu.bsu.cs;

import java.io.IOException;
import java.net.URL;

public final class ErrorProcessor {
    UserView errorMessage = new UserView();

    public void checkNetworkConnection(URL url) {
        try{
            url.openConnection().connect();
        } catch (IOException e) {
            errorMessage.displayErrorMessage("Trouble connecting to the internet...");
        }
    }
}
