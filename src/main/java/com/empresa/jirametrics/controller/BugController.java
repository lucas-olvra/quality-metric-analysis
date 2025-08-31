package com.empresa.jirametrics.controller;

import com.empresa.jirametrics.model.Bug;
import com.empresa.jirametrics.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    @Autowired
    private BugRepository repository;

    // Criar novo Bug
    @PostMapping
    public Bug create(@RequestBody Bug bug) {
        return repository.save(bug);
    }

    // Listar todos Bugs
    @GetMapping
    public List<Bug> findAll() {
        return repository.findAll();
    }
}
