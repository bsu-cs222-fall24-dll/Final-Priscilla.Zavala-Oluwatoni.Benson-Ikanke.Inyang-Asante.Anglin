package edu.bsu.cs;

public class MenuController {
    private final UserModel model;
    private final UserView view;

    protected MenuController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    protected void runMenu() {
        view.displayPositionOptions();
        String credentialID = UserInput.credentialInput();
        if (model.isValidCredential(credentialID)) {
            String welcomeRoleMessage = model.getPositionCredential(credentialID);
            view.displayMessage("Now logged in as a " + welcomeRoleMessage + "!");
            runPositionTaskMenu(credentialID);
        } else {
            view.displayErrorMessage("Invalid credential. Please try again.");
            runMenu();
        }
    }

    protected void runPositionTaskMenu(String credentialID) {
        String position = model.getPositionCredential(credentialID);
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
        } else {
            view.displayErrorMessage("Invalid " + position + " task. Please try again.");
            processUserTaskInput(position);
        }
    }
}
