package com.skill_barter.skill_barter.service;

import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ SAVE USER
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email)
                          && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // ✅ GET USER BY ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✅ USER COUNT
    public long getUserCount() {
        return userRepository.count();
    }

    // ✅ GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}