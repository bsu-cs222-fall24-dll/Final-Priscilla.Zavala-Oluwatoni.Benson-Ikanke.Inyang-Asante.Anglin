package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        UserModel model = new UserModel();
        UserView view = new UserView();
        BuildURL buildURL = new BuildURL();
        MenuController controller = new MenuController(model, view, buildURL);
        controller.runMenu();
    }
}