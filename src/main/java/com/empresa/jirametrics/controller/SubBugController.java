package com.empresa.jirametrics.controller;

import com.empresa.jirametrics.model.SubBug;
import com.empresa.jirametrics.repository.SubBugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subbugs")
public class SubBugController {

    @Autowired
    private SubBugRepository repository;

    // Criar novo SubBug
    @PostMapping
    public SubBug create(@RequestBody SubBug subBug) {
        return repository.save(subBug);
    }

    // Listar todos SubBugs
    @GetMapping
    public List<SubBug> findAll() {
        return repository.findAll();
    }
}
