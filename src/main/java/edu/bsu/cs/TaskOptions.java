package edu.bsu.cs;

import java.util.List;
import java.util.Map;

public class TaskOptions {
    //use mapping for readability and CC
    private static final Map<String, List<String>> TASKS_MAP = Map.of(
            "Cost Analyst", List.of(
                    "- Total Revenue ID: 101",
                    "- Total Functional Expenses ID: 102",
                    "- Subsidized Health Services as a % of Total Functional Expenses: 103",
                    "- Health Professions Education as a % of Total Functional Expenses: 104",
                    "- Total Community Benefits Costs: 105",
                    "- Charity Care Expenses: 106",
                    "- Community Health Improvement Services & Community Benefit Operations Cost: 107"
            ),
            "Auditor", List.of(
                    "- Bad debt as a % of Total Functional Expenses ID: 201",
                    "- General Bad Debt ID: 202"
            )
    );

    public List<String> getTasksForPosition(String position) {
        //getOrDefault method avoids potential NullPointerExceptions
        return TASKS_MAP.getOrDefault(position, List.of());
    }
}
