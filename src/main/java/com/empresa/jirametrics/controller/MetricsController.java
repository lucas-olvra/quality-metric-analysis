package com.empresa.jirametrics.controller;

import com.empresa.jirametrics.dto.MetricsReport;
import com.empresa.jirametrics.service.MetricsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final MetricsService service;

    public MetricsController(MetricsService service) {
        this.service = service;
    }

    // Relatório por sigla + ano + mês
    @GetMapping("/{projectKey}/{year}/{month}")
    public MetricsReport getMetrics(
            @PathVariable String projectKey,
            @PathVariable int year,
            @PathVariable int month) {
        return service.calculateMonthlyMetrics(projectKey, year, month);
    }
}
