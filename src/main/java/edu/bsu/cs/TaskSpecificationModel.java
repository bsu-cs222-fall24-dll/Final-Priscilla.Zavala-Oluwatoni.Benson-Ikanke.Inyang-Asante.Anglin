package edu.bsu.cs;

import java.util.HashSet;
import java.util.Set;

public class TaskSpecificationModel {
    private static final Set<String> COST_ANALYST_TASK_ID = new HashSet<>(
            Set.of("101", "102", "103", "104", "105", "106", "107")
    );

    private static final Set<String> AUDITOR_TASK_ID = new HashSet<>(
            Set.of("201", "202")
    );

    private static final Set<String> HR_DIRECTOR = new HashSet<>(
            Set.of("301", "302", "303", "304", "305")
    );

    private static final Set<String> MEDICAID_DATA_ANALYST = new HashSet<>(
            Set.of("401", "402", "403", "404", "405")
    );

    protected boolean isValidCostAnalystSpecification(String specificationID) {
        return COST_ANALYST_TASK_ID.contains(specificationID);
    }

    protected boolean isValidAuditorSpecification(String specificationID) {
        return AUDITOR_TASK_ID.contains(specificationID);
    }

    protected boolean isValidHRDirectorSpecification(String specificationID){
        return HR_DIRECTOR.contains(specificationID);
    }

    protected boolean isValidMedicaidDataAnalyst(String specificationID){
        return MEDICAID_DATA_ANALYST.contains(specificationID);
    }
}
