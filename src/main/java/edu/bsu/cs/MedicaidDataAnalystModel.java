package edu.bsu.cs;

public class MedicaidDataAnalystModel extends PositionModel{

    @Override
    protected String retrieveJsonPath(String taskIDFromUserChoice){
        String jsonPath = "";
        switch (taskIDFromUserChoice){
            case "401":
                jsonPath = "unreim_medcd_tot_func_exp_pct";
                break;
            case "402":
                jsonPath = "mdcre_shrtfl";
                break;
            case "403":
                jsonPath = "mdcre_shrtfl_tot_func_exp_pct";
                break;
            case "404":
                jsonPath = "unreim_medcd";
                break;
            case "405":
                jsonPath = "rat_pat_care_npat_care_comm_bnfts";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }

    @Override
    protected void changeTitle(String jsonPath){
        switch (jsonPath){
            case "unreim_medcd_tot_func_exp_pct":
                setTitle("Unreimbursed Medicaid as % of Total Functional Expenses");
                break;
            case "mdcre_shrtfl":
                setTitle("Medicare Shortfall (Negative Value Indicates Surplus)");
                break;
            case "mdcre_shrtfl_tot_func_exp_pct":
                setTitle("Medicare Shortfall as % of Total Functional Expenses (Negative Value Indicates Surplus)");
                break;
            case "unreim_medcd":
                setTitle("Unreimbursed Medicaid");
                break;
            case "rat_pat_care_npat_care_comm_bnfts":
                 setTitle("Ratio of Patient Care to Non-patient Care Community Benefits");
                break;
            default:
                ErrorProcessor.displayErrorMessage("Could not find title...");
        }
        System.out.printf("%18s\n", getTitle());
    }
}