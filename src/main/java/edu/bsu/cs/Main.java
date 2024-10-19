package edu.bsu.cs;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
//        UserModel model = new UserModel();
//        UserView view = new UserView();
//        MenuController controller = new MenuController(model, view);
//        controller.runMenu();
//
//        String state = UserInput.stateInput();
//        BuildURL buildURL = new BuildURL();
//        System.out.println("List of hospitals in state: " + buildURL.buildHospitalsInStateURL(state));
//        String hospital = UserInput.hospitalIDInput();
//        System.out.println("List of hospitals in state: " + buildURL.buildHospitalDataURL(hospital));

        WebsiteURLConnection.connectHospitalURL("10");
    }
}
