package com.example.My.service.skills.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SkillModel {
    private Long id;
    private String name;
    private String level;
    private String category;
    private String icon;
}
