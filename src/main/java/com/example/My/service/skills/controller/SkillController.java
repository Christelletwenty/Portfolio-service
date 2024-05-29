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

import com.example.My.service.skills.entity.Skill;
import com.example.My.service.skills.model.SkillModel;
import com.example.My.service.skills.service.SkillServiceImpl;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class SkillController {

    SkillServiceImpl skillService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<SkillModel> saveSkill(@RequestBody SkillModel skillModel) {
        return skillService.saveSkill(skillModel);
    }

    @GetMapping("/skills")
    public Flux<SkillModel> getSkills(SkillServiceImpl skillServiceImpl) {
        return skillService.getAllSkills();
    }

    @GetMapping("/skills/{id}")
    public Mono<Skill> getSkills(@PathVariable Long id) {
        return skillService.getSkill(id);
    }

    @PutMapping("/skill/{id}")
    public Mono<SkillModel> updateSkill(@RequestBody SkillModel skillModel, @PathVariable("id") Long id) {
        return skillService.updateSkill(skillModel);
    }

    @PostMapping("/skills")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<SkillModel> createSkill(@RequestBody SkillModel skillModel) {
        return skillService.createSkill(skillModel);
    }

    @DeleteMapping("/skills/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSkill(@PathVariable("id") Long id) {
        return skillService.deleteSkill(id);
    }
}