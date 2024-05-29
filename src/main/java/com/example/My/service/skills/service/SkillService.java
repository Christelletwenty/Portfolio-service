package com.example.My.service.skills.service;

import org.springframework.stereotype.Service;

import com.example.My.service.skills.model.SkillModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface SkillService {

    Mono<SkillModel> saveSkill(SkillModel skillModel);

    Mono<SkillModel> getSkillById(Long skillId);

    Flux<SkillModel> getAllSkills();

    Mono<SkillModel> createSkill(SkillModel skillModel);

    Mono<SkillModel> updateSkill(SkillModel skillModel);

    Mono<Void> deleteSkill(Long SkillId);

}
