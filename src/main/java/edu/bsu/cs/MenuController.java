package edu.bsu.cs;

public class MenuController {
    private final UserModel model;
    private final UserView view;
    private final BuildURL buildURL;

    protected MenuController(UserModel model, UserView view, BuildURL buildURL) {
        this.model = model;
        this.view = view;
        this.buildURL = buildURL;
    }

    protected void runMenu() {
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

    protected void runPositionTaskMenu(String credentialID) {
        String position = model.getPositionByCredential(credentialID);
        if (position != null) {
            displayTasksBasedOnPosition(position);
            processUserTaskInput(position);
        }
    }

    private void displayTasksBasedOnPosition(String position) {
        if (position.equals("Cost Analyst")) {
            view.displayCostAnalystTasks();
        } else if (position.equals("Auditor")) {
            view.displayAuditorTasks();
        }
    }

    private void processUserTaskInput(String position) {
        String taskID = UserInput.taskIDInput();
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

    private void runHospitalInfoMenu() {
        String state = UserInput.stateInput();
        String hospitalsInStateURL = buildURL.buildHospitalsInStateURL(state);
        view.displayMessage("List of hospitals in state: " + hospitalsInStateURL);

        String hospitalID = UserInput.hospitalIDInput();
        String hospitalDataURL = buildURL.buildHospitalDataURL(hospitalID);
        view.displayMessage("Data for hospital ID: " + hospitalDataURL);
    }
}
