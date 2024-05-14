package com.example.My.service.skills.service;

import com.example.My.service.skills.model.SkillModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SkillService {

    Mono<SkillModel> saveSkill(SkillModel skillModel);
    Mono<SkillModel> getSkillById(Long skillId);
    Flux<SkillModel> getAllSkill();
    Mono<SkillModel> createSkill(SkillModel skillModel);
    Mono<SkillModel> updateSkill(SkillModel skillModel);
    Mono<Void> deleteSkill(Long SkillId);

}
