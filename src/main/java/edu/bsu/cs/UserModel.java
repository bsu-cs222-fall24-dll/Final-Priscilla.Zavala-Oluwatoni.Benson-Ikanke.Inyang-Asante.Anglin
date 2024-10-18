package edu.bsu.cs;

public class UserModel {
    protected String getPositionCredential (String credentialID) {
        if (credentialID.equals("100")) {
            return "Cost Analyst";
        } else if (credentialID.equals("200")) {
            return "Auditor";
        } else {
            return null;
        }
    }

    protected boolean isValidCredential(String credentialID) {
        return credentialID.equals("100") || credentialID.equals("200");
    }
}
