package com.empresa.jirametrics.repository;

import com.empresa.jirametrics.model.SubBug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SubBugRepository extends JpaRepository<SubBug, Long> {
    List<SubBug> findByProjectKeyAndOpenedDateBetween(String projectKey, LocalDate start, LocalDate end);
}
