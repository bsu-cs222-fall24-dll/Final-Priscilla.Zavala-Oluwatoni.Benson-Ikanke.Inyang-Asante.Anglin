package edu.bsu.cs;

import java.util.HashSet;
import java.util.Set;

public class UserCredentialModel {
    private static final Set<String> VALID_CREDENTIALS = new HashSet<>(
            Set.of("100", "200", "300", "400")
    );

    protected boolean isValidCredential(String credentialID) {
        return VALID_CREDENTIALS.contains(credentialID);
    }

    protected String getPositionByCredential (String credentialID) {
        if (credentialID.equals("100")) {
            return "Cost Analyst";
        } else if (credentialID.equals("200")) {
            return "Auditor";
        } else if(credentialID.equals("300")){
            return "HR Director";
        } else if (credentialID.equals("400")) {
            return "Medicaid Data Analyst";
        } else {
            return null;
        }
    }
}
