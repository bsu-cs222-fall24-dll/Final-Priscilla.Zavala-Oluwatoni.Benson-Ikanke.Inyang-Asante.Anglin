package edu.bsu.cs;

public class UserView {
    protected void displayPositionOptions() {
        System.out.println("""
                Position Credentials Listed Below:
                - Cost Analyst ID: 100
                - Auditor ID: 200
                """);
    }

    public void displayWelcomeMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }
}
