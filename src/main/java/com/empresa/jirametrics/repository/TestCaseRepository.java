package com.empresa.jirametrics.repository;

import com.empresa.jirametrics.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByProjectKey(String projectKey);
}
