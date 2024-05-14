package com.example.My.service.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.My.service.skills.entity.Skill;
import com.example.My.service.skills.excepiton.SkillNotFound;
import com.example.My.service.skills.mapper.SkillsMapper;
import com.example.My.service.skills.model.SkillModel;
import com.example.My.service.skills.repository.SkillRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService{
    
    private SkillRepository skillrepository;


    @Override
    public Mono<SkillModel> saveSkill(SkillModel skillModel) {
        Skill skill = SkillsMapper.mapToSkill(skillModel);
        Mono<Skill> savedSkill = skillrepository.save(skill);
        return savedSkill
                .map((skillEntity)->SkillsMapper.mapToSkillModel(skillEntity));
    }

    @Override
    public Mono<SkillModel> getSkillById(Long id) {
        Mono<Skill> skillMono = skillrepository.findById(id);
        return skillMono.map((skill -> SkillsMapper.mapToSkillModel(skill))); 
    }

    @Transactional(readOnly = true)
    public Flux<SkillModel> getAllSkill() {
        return skillrepository.findAll()
        .map(s -> SkillsMapper.mapToSkillModel(s));
    }

    @Override
    public Mono<SkillModel> createSkill(SkillModel skillModel) {
        return this.skillrepository.save(SkillsMapper.mapToSkill(skillModel))
        .map(s -> SkillsMapper.mapToSkillModel(s));
    }

    @Override
    public Mono<SkillModel> updateSkill(SkillModel skillModel) {
        return this.skillrepository.findById(skillModel.getId())
        .switchIfEmpty(Mono.error(new SkillNotFound()))
        .flatMap(__ -> this.skillrepository.save(SkillsMapper.mapToSkill(skillModel)))
        .map(SkillsMapper::mapToSkillModel);
    }

    @Override
    public Mono<Void> deleteSkill(Long id) {
        return skillrepository.deleteById(id);
    }
}
