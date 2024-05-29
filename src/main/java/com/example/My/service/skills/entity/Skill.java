package com.example.My.service.skills.entity;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("skills")
public class Skill {

    @Id
    private Long id;
    private String name;
    private String level;
    private String category;
    private String icon;
}
