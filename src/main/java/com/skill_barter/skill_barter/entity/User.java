package com.skill_barter.skill_barter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; 

    private int timeCredits;
    private int credits;
    private double trustScore;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getTimeCredits() { return timeCredits; }
    public void setTimeCredits(int timeCredits) { this.timeCredits = timeCredits; }

    public double getTrustScore() { return trustScore; }
    public void setTrustScore(double trustScore) { this.trustScore = trustScore; }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}