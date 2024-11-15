package edu.bsu.cs;

public class CostAnalystModel extends PositionModel{

    @Override
    protected String retrieveJsonPath(String taskIDFromUserChoice){
        String jsonPath = "";
        switch (taskIDFromUserChoice){
            case "101":
                jsonPath = "tot_revenue";
                break;
            case "102":
                jsonPath = "tot_func_exp";
                break;
            case "103":
                jsonPath = "subsd_hlth_svcs_tot_func_exp_pct";
                break;
            case "104":
                jsonPath = "hlth_prof_educ_tot_func_exp_pct";
                break;
            case "105":
                jsonPath = "tot_comm_bnfts";
                break;
            case "106":
                jsonPath = "chrty_care";
                break;
            case "107":
                jsonPath = "comm_hlth_impr_svcs_comm_bnft_oper";
                break;
            default:
                ErrorProcessor.displayErrorMessage("jsonPath not found");
        }
        return jsonPath;
    }

    @Override
    public void changeTitle(String jsonPath){
        switch (jsonPath){
            case "tot_revenue":
                setTitle("Total Revenue");
                break;
            case "tot_func_exp":
                setTitle("Total Functional Expenses");
                break;
            case "subsd_hlth_svcs_tot_func_exp_pct":
                setTitle("Subsidized health services as % of total functional expenses");
                break;
            case "hlth_prof_educ_tot_func_exp_pct":
                setTitle("Health Professions Education as a % of Total Functional Expenses");
                break;
            case "tot_comm_bnfts":
                setTitle("Total Community Benefits");
                break;
            case "chrty_care":
                setTitle("Charity Care Expenses");
                break;
            case "comm_hlth_impr_svcs_comm_bnft_oper":
                setTitle("Community Health Improvement Services & Community Benefit Operations Cost");
                break;
            default:
                ErrorProcessor.displayErrorMessage("Could not find title...");
        }
        System.out.printf("%18s\n", getTitle());
    }
}