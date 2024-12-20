package edu.bsu.cs;

public class UserModel{
    private final UserCredentialModel credentialModel = new UserCredentialModel();
    private final TaskSpecificationModel specificationModel = new TaskSpecificationModel();

    public boolean isValidCredential(String credentialID) {
        return credentialModel.isValidCredential(credentialID);
    }

    public String getPositionByCredential(String credentialID) {
        return credentialModel.getPositionByCredential(credentialID);
    }

    //helper method to separate logic for processing user task input in MenuController
    public boolean isValidTaskForPosition(String position, String taskID) {
        return switch (position) {
            case "Cost Analyst" -> isValidCostAnalystSpecification(taskID);
            case "Auditor" -> isValidAuditorSpecification(taskID);
            case "HR Director" -> isValidHRDirectorSpecification(taskID);
            case "Medicaid Data Analyst" -> isValidMedicaidDataAnalystSpecification(taskID);
            default -> false;
        };
    }

    public boolean isValidCostAnalystSpecification(String specificationID) {
        return specificationModel.isValidCostAnalystSpecification(specificationID);
    }

    public boolean isValidAuditorSpecification(String specificationID) {
        return specificationModel.isValidAuditorSpecification(specificationID);
    }

    public boolean isValidHRDirectorSpecification(String specificationID) {
        return specificationModel.isValidHRDirectorSpecification(specificationID);
    }

    public boolean isValidMedicaidDataAnalystSpecification(String specificationID) {
        return specificationModel.isValidMedicaidDataAnalyst(specificationID);
    }
}