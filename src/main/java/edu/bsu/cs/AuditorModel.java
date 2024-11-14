package edu.bsu.cs;

public class AuditorModel extends PositionModel{

    @Override
    protected String retrieveJsonPath(String taskIDFromUserChoice){
        String jsonPath = "";
        switch (taskIDFromUserChoice){
            case "201":
                jsonPath = "bad_debt_tot_func_exp_pct";
                break;
            case "202":
                jsonPath = "bad_debt";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }

    @Override
    public void changeTitle(String jsonPath){
        switch (jsonPath){
            case "bad_debt_tot_func_exp_pct":
                setTitle("Bad debt as a % of Total Functional Expenses");
                break;
            case "bad_debt":
                setTitle("General Bad Debt");
                break;
                default:
                ErrorProcessor.displayErrorMessage("Could not find title...");
        }
        System.out.printf("%30s\n", getTitle());
    }
}