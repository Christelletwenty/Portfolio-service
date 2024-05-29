package com.example.My.service.skills.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.My.service.skills.entity.Skill;

public interface SkillRepository extends ReactiveCrudRepository<Skill, Long> {

}
