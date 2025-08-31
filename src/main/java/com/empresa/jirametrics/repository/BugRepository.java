package com.empresa.jirametrics.repository;

import com.empresa.jirametrics.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByProjectKeyAndOpenedDateBetween(String projectKey, LocalDate start, LocalDate end);
}
