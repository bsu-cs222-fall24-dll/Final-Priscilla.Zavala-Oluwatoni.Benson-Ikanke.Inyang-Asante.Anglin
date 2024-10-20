package edu.bsu.cs;

public class UserModel {
    private final UserCredentialModel credentialModel = new UserCredentialModel();
    private final TaskSpecificationModel specificationModel = new TaskSpecificationModel();

    public boolean isValidCredential(String credentialID) {
        return credentialModel.isValidCredential(credentialID);
    }

    public String getPositionByCredential(String credentialID) {
        return credentialModel.getPositionByCredential(credentialID);
    }

    public boolean isValidCostAnalystSpecification(String specificationID) {
        return specificationModel.isValidCostAnalystSpecification(specificationID);
    }

    public boolean isValidAuditorSpecification(String specificationID) {
        return specificationModel.isValidAuditorSpecification(specificationID);
    }
}
