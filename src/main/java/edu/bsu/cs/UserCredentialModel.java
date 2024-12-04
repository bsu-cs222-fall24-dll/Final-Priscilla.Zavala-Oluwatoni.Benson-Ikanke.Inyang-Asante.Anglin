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
        return switch (credentialID) {
            case "100" -> "Cost Analyst";
            case "200" -> "Auditor";
            case "300" -> "HR Director";
            case "400" -> "Medicaid Data Analyst";
            default -> null;
        };
    }
}
