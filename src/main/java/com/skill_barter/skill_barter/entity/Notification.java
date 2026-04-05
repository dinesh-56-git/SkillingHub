package com.skill_barter.skill_barter.entity;

import jakarta.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private boolean isRead = false;

    @ManyToOne
    private User user;

    // getters & setters
    public Long getId() { return id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}