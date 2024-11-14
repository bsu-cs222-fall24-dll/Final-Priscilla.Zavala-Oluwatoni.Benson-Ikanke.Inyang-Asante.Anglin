package edu.bsu.cs;

import java.util.List;
public class UserView{
    private static final String POSITION_OPTIONS = """
            Position Credentials Listed Below:
            - Cost Analyst ID: 100
            - Auditor ID: 200
            - HR Director: 300
            - Medicaid Data Analyst: 400
            """;

    protected void displayPositionOptions() {
        System.out.println(POSITION_OPTIONS);
    }

    //retrieves list of tasks from MenuController - it is NOT model code
    protected void displayTasksForPosition(List<String> tasks) {
        if (tasks != null && !tasks.isEmpty()) {
            System.out.println("Position Tasks Specified Below:");
            tasks.forEach(System.out::println);
        } else {
            System.err.println("No tasks found for related position.");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }
}
