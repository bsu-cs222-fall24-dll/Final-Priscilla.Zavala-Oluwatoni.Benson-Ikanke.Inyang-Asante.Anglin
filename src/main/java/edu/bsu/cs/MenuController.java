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
            view.displayWelcomeMessage("Now logged in as a " + welcomeRoleMessage + "!");
        } else {
            view.displayErrorMessage("Invalid credential. Please try again.");
            runMenu();
        }
    }
}
