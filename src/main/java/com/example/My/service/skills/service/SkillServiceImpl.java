package com.example.My.service.skills.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.My.service.skills.entity.Skill;
import com.example.My.service.skills.excepiton.SkillNotFound;
import com.example.My.service.skills.mapper.SkillsMapper;
import com.example.My.service.skills.model.SkillModel;
import com.example.My.service.skills.repository.SkillRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillrepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillrepository = skillRepository;
    }

    public Mono<SkillModel> saveSkill(SkillModel skillModel) {
        Skill skill = SkillsMapper.mapToSkill(skillModel);
        Mono<Skill> savedSkill = skillrepository.save(skill);
        return savedSkill
                .map((skillEntity) -> SkillsMapper.mapToSkillModel(skillEntity));
    }

    @Transactional
    public Mono<SkillModel> getSkillById(Long id) {
        Mono<Skill> skillMono = skillrepository.findById(id);
        return skillMono.map((skill -> SkillsMapper.mapToSkillModel(skill)));
    }

    @Transactional(readOnly = true)
    public Mono<Skill> getSkill(Long id) {
        return skillrepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Flux<SkillModel> getAllSkills() {
        return skillrepository.findAll()
                .map(SkillsMapper::mapToSkillModel);
    }

    @Transactional
    public Mono<SkillModel> createSkill(SkillModel skillModel) {
        return this.skillrepository.save(SkillsMapper.mapToSkill(skillModel))
                .map(s -> SkillsMapper.mapToSkillModel(s));
    }

    @Transactional
    public Mono<SkillModel> updateSkill(SkillModel skillModel) {
        return this.skillrepository.findById(skillModel.getId())
                .switchIfEmpty(Mono.error(new SkillNotFound()))
                .flatMap(__ -> this.skillrepository.save(SkillsMapper.mapToSkill(skillModel)))
                .map(SkillsMapper::mapToSkillModel);
    }

    @Transactional
    public Mono<Void> deleteSkill(Long id) {
        return skillrepository.deleteById(id);
    }

}
