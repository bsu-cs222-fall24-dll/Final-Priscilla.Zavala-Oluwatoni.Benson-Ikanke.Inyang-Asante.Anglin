package edu.bsu.cs;

public class HRDirectorModel extends PositionModel{

    @Override
    protected String retrieveJsonPath(String roleID) {
        String jsonPath = "";
        switch (roleID) {
            case "301":
                jsonPath = "comm_bldg_actvs";
                break;
            case "302":
                jsonPath = "comm_bldg_actvs_cmntysuprt";
                break;
            case "303":
                jsonPath = "comm_hlth_impr_svcs_comm_bnft_oper";
                break;
            case "304":
                jsonPath = "comm_bldg_actvs_ldrdevlp";
                break;
            case "305":
                jsonPath = "tot_comm_bnfts";
                break;
            default:
                ErrorProcessor.displayErrorMessage("Error could not retrieve JsonPath Title...");
        }
        return jsonPath;
    }

    @Override
    protected void changeTitle(String jsonPath) {
        switch (jsonPath) {
            case "comm_bldg_actvs":
                setTitle("Community Building Activities");
                break;
            case "comm_bldg_actvs_cmntysuprt":
                setTitle("Community Building Activities - Community Support");
                break;
            case "comm_hlth_impr_svcs_comm_bnft_oper":
                setTitle("Community Health Improvement Services");
                break;
            case "comm_bldg_actvs_ldrdevlp":
                setTitle("Community Building Activities - Leadership Development");
                break;
            case "tot_comm_bnfts":
                setTitle("Total Community Benefits");
                break;
            default:
                ErrorProcessor.displayErrorMessage("Could not display Title...");
        }
        System.out.printf("%18s\n", getTitle());
    }
}