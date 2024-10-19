package edu.bsu.cs;

public class UserView {
    protected void displayPositionOptions() {
        System.out.println("""
                Position Credentials Listed Below:
                - Cost Analyst ID: 100
                - Auditor ID: 200
                """);
    }

    protected void displayCostAnalystTasks() {
        System.out.println("""
                Position Tasks Specified Below:
                - Total Revenue ID: 101
                - Total Functional Expenses ID: 102
                - Subsidized Health Services as a % of Total Functional Expenses: 103
                - Health Professions Education as a % of Total Functional Expenses: 104
                - Total Community Benefits Costs: 105
                - Charity Care Expenses: 106
                - Community Health Improvement Services & Community Benefit Operations Cost: 107
                """);
    }

    protected void displayAuditorTasks() {
        System.out.println("""
                Position Tasks Specified Below:
                - Bad debt as a % of Total Functional Expenses ID: 201
                - General Bad Debt ID: 202
                """);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

}
