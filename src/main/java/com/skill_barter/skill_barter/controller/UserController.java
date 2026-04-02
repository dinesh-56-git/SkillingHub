package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.skill_barter.skill_barter.service.UserService;
import com.skill_barter.skill_barter.service.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService; 
    

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/dashboard";
    }
    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("skills", skillService.getAllSkills());
        return "admin-dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        if (user != null) {
            model.addAttribute("username", user.getName());
        }

        model.addAttribute("skillCount", skillService.getSkillCount());
        model.addAttribute("userCount", userService.getUserCount());

        return "dashboard";
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }
}