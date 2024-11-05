package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController extends UserView{
    private final UserModel model;
    private final UserView view;
    private final BuildURL buildURL;
    public CostAnalystModel costAnalystModel = new CostAnalystModel();
    public CostAnalystView costAnalystView = new CostAnalystView();
    public TaskOptions taskOptions = new TaskOptions();
    public AuditorData auditorData = new AuditorData();
    public String taskID = "";
    private String jsonPath;
    private String jsonFile;

    protected MenuController(UserModel model, UserView view, BuildURL buildURL) {
        this.model = model;
        this.view = view;
        this.buildURL = buildURL;
    }

    protected void runMenu() throws IOException, URISyntaxException {
        view.displayPositionOptions();
        String credentialID = UserInput.credentialInput();
        if (model.isValidCredential(credentialID)) {
            String welcomeRoleMessage = model.getPositionByCredential(credentialID);
            view.displayMessage("Now logged in as a " + welcomeRoleMessage + "!");
            runPositionTaskMenu(credentialID);
        } else {
            view.displayErrorMessage("Invalid credential. Please try again.");
            runMenu();
        }

    }

    protected void runPositionTaskMenu(String credentialID) throws IOException, URISyntaxException {
        String position = model.getPositionByCredential(credentialID);
        if (position != null) {
            displayTasksBasedOnPosition(position);
            processUserTaskInput(position);
        }
    }

    private void displayTasksBasedOnPosition(String position) {
        if (position.equals("Cost Analyst")) {
            view.displayTasksForPosition(taskOptions.getTasksForPosition("Cost Analyst"));
        } else if (position.equals("Auditor")) {
            //view.displayAuditorTasks();
        }
    }

    private void processUserTaskInput(String position) throws IOException, URISyntaxException {
        taskID = UserInput.taskIDInput();
        boolean isValidPositionTask = false;

        if (position.equals("Cost Analyst")) {
            isValidPositionTask = model.isValidCostAnalystSpecification(taskID);
        } else if (position.equals("Auditor")) {
            isValidPositionTask = model.isValidAuditorSpecification(taskID);
        }

        if (isValidPositionTask) {
            view.displayMessage("Valid " + position + " task selected: " + taskID);
            runHospitalInfoMenu();
        } else {
            view.displayErrorMessage("Invalid " + position + " task. Please try again.");
            processUserTaskInput(position);
        }
    }

    private void runHospitalInfoMenu() throws IOException, URISyntaxException {
        String state = UserInput.stateInput();
        String hospitalsInStateURL = buildURL.buildStateHospitalURL(state);
        view.displayMessage("List of hospitals in state: " + hospitalsInStateURL);

        String hospitalID = UserInput.hospitalIDInput();
        String hospitalDataURL = buildURL.buildHospitalDataURL(hospitalID);
        view.displayMessage("Data for hospital ID: " + hospitalDataURL);
        //menuDisplay(hospitalID);
        auditorData.retrieveHospitalData(hospitalID, "bad_debt_tot_func_exp_pct");
    }

    private void menuDisplay(String hospitalID) throws IOException, URISyntaxException {
        jsonPath = costAnalystModel.retrieveJsonPath(taskID);
        jsonFile = costAnalystModel.retrieveJsonFile(hospitalID, jsonPath);
        costAnalystView.displayFormattedData(jsonFile, jsonPath);
    }
}