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

    protected boolean isValidCostAnalystSpecification (String specificationID) {
        return specificationID.equals("101") || specificationID.equals("102") ||
                specificationID.equals("103") || specificationID.equals("104") ||
                specificationID.equals("105") || specificationID.equals("106") ||
                specificationID.equals("107");
    }

    protected boolean isValidAuditorSpecification (String specificationID) {
        return specificationID.equals("201") || specificationID.equals("202");
    }

}
