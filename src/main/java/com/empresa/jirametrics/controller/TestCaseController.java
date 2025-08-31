package com.empresa.jirametrics.controller;

import com.empresa.jirametrics.model.TestCase;
import com.empresa.jirametrics.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseRepository repository;

    // Criar novo CT
    @PostMapping
    public TestCase create(@RequestBody TestCase testCase) {
        return repository.save(testCase);
    }

    // Listar todos CTs
    @GetMapping
    public List<TestCase> findAll() {
        return repository.findAll();
    }
}
