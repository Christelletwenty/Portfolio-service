package com.example.My.service.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.My.service.skills.model.SkillSaveModel;
import com.example.My.service.skills.repository.SkillRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SkillService {
    @Autowired
    SkillRepository repository;

    @Transactional(readOnly = true)
    public Flux<Skill> getAllSkills() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Mono<Skill> getSkillById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Mono<Skill> addSkill(SkillSaveModel skill) {
        Skill newSkill = Skill.builder()
        .name(skill.getName())
        .level(Skill.getLevel())
        .build();
        return this.repository.save(newSkill);
    } 
}
