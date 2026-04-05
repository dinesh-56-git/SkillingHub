package com.skill_barter.skill_barter.entity;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    @ManyToOne
    private User user;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }
   
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}