package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;


public class HRDirectorModel {


    protected String retrieveJsonPath(String roleID) {
        String jsonPath = "";
        switch (roleID) {
            case "101":
                jsonPath = "comm_bldg_actvs";
                break;
            case "102":
                jsonPath = "comm_bldg_actvs_cmntysuprt";
                break;
            case "103":
                jsonPath = "comm_hlth_impr_svcs_comm_bnft_oper";
                break;
            case "104":
                jsonPath = "comm_bldg_actvs_ldrdevlp";
                break;
            case "105":
                jsonPath = "tot_comm_bnfts";
                break;
            default:
                ErrorProcessor.displayErrorMessage("Error could not retrieve JsonPath Title...");

        }
        return jsonPath;
    }

    private String title;

    private void setTitle(String newTitle) {
        this.title = newTitle;
    }

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

    protected String getTitle() {
        return title;
    }

    public String formatNumericJsonData(String jsonFile) {

        return jsonFile;
    }
}







