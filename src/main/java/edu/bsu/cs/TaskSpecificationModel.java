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

    protected boolean isValidCostAnalystSpecification(String specificationID) {
        return COST_ANALYST_TASK_ID.contains(specificationID);
    }

    protected boolean isValidAuditorSpecification(String specificationID) {
        return AUDITOR_TASK_ID.contains(specificationID);
    }
}
