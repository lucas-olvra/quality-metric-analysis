package com.empresa.jirametrics.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetricsReport {
    private String projectKey;
    private long plannedTests;
    private long executedTests;
    private long subBugs;
    private long bugs;
    private double retrabalhoPercent;
}