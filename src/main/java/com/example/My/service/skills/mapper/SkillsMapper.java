package com.example.My.service.skills.mapper;

import com.example.My.service.skills.entity.Skill;
import com.example.My.service.skills.model.SkillModel;

public class SkillsMapper {

    public static SkillModel mapToSkillModel(Skill skill) {
        return new SkillModel(
                skill.getId(),
                skill.getName(),
                skill.getLevel(),
                skill.getCategory(),
                skill.getIcon());
    }

    public static Skill mapToSkill(SkillModel skillModel) {
        return new Skill(
                skillModel.getId(),
                skillModel.getName(),
                skillModel.getLevel(),
                skillModel.getCategory(),
                skillModel.getIcon());
    }
}
