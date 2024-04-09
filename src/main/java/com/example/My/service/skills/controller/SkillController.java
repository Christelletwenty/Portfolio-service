package com.example.My.service.skills.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.My.service.skills.model.SkillModel;
import com.example.My.service.skills.model.SkillSaveModel;
import com.example.My.service.skills.service.SkillService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SkillController {

    SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    Flux<Skill> getAllSkills() {
        return skillService.getAllSkills(); //méthode à effectuer dans "SkillService.java"
    }

    @GetMapping("/skills/{id}")
    public Mono<Skill> getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id); //méthode à effectuer dans "SkillService.java"
    }

    @PostMapping("/add-skill")
    public Mono<Skill> addSkill(@RequestBody SkillSaveModel Skill) {
        return skillService.addSkill(Skill); //méthode à effectuer dans "SkillService.java"
    }

    @PutMapping("/update-skill")
    public Mono<Skill> updateSkill(@PathVariable Long id, @RequestBody UpdateModel skill ) { //méthode à effectuer dans "SkillService.java"
        return this.skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/delete-skill/{id}")
    public Mono<Void> deleteSkillById(@PathVariable("id") Long id) { //méthode à effectuer dans "SkillService.java"
        return skillService.deleteSkillById(id)
        .map(val -> {
            if (val == true) {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        });
        }
    }