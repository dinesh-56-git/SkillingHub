package com.skill_barter.skill_barter.entity;

import jakarta.persistence.*;

@Entity
public class BarterRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String skillRequested;

    private String status;
    private String skill;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }

    public String getSkillRequested() { return skillRequested; }
    public void setSkillRequested(String skillRequested) { this.skillRequested = skillRequested; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}