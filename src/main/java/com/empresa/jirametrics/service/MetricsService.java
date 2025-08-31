package com.empresa.jirametrics.service;

import com.empresa.jirametrics.dto.MetricsReport;
import com.empresa.jirametrics.model.TestCase;
import com.empresa.jirametrics.model.SubBug;
import com.empresa.jirametrics.model.Bug;
import com.empresa.jirametrics.repository.TestCaseRepository;
import com.empresa.jirametrics.repository.SubBugRepository;
import com.empresa.jirametrics.repository.BugRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MetricsService {

    private final TestCaseRepository testCaseRepo;
    private final SubBugRepository subBugRepo;
    private final BugRepository bugRepo;

    public MetricsService(TestCaseRepository testCaseRepo,
                          SubBugRepository subBugRepo,
                          BugRepository bugRepo) {
        this.testCaseRepo = testCaseRepo;
        this.subBugRepo = subBugRepo;
        this.bugRepo = bugRepo;
    }

    public MetricsReport calculateMonthlyMetrics(String projectKey, int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);

        // Busca filtrada direto do banco
        List<TestCase> tests = testCaseRepo.findByProjectKey(projectKey);
        List<SubBug> subBugs = subBugRepo.findByProjectKeyAndOpenedDateBetween(projectKey, start, end);
        List<Bug> bugs = bugRepo.findByProjectKeyAndOpenedDateBetween(projectKey, start, end);

        long plannedTests = tests.size();
        long executedTests = tests.stream().filter(TestCase::isExecuted).count();

        double retrabalhoPercent = (plannedTests > 0)
                ? ((double) subBugs.size() / plannedTests) * 100
                : 0;

        return MetricsReport.builder()
                .projectKey(projectKey)
                .plannedTests(plannedTests)
                .executedTests(executedTests)
                .subBugs(subBugs.size())
                .bugs(bugs.size())
                .retrabalhoPercent(retrabalhoPercent)
                .build();
    }
}
