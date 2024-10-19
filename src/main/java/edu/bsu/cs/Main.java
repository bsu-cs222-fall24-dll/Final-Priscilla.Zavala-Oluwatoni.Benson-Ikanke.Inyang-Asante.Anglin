package edu.bsu.cs;

public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        UserView view = new UserView();
        MenuController controller = new MenuController(model, view);
        controller.runMenu();

        //will implement this logic into separate class
        String state = UserInput.stateInput();
        BuildURL buildURL = new BuildURL();
        System.out.println("List of hospitals in state: " + buildURL.buildHospitalsInStateURL(state));
        String hospital = UserInput.hospitalIDInput();
        System.out.println("List of hospitals in state: " + buildURL.buildHospitalDataURL(hospital));
    }
}
