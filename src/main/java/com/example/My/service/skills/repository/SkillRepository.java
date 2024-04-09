package com.example.My.service.skills.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import com.example.My.service.skills.entity.Skill;

@Repository
public interface SkillRepository extends ReactiveCrudRepository<Skill, Long>{
    
}
