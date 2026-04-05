package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.skill_barter.skill_barter.service.UserService;
import com.skill_barter.skill_barter.service.NotificationService;
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
    @Autowired
    private NotificationService notificationService;

    

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

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);

        // 🔥 ADD NOTIFICATIONS
        model.addAttribute("notifications",
            notificationService.getUserNotifications(user));

        return "dashboard";
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "profile";
    }
 
    @GetMapping("/edit-profile")
    public String editProfile(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "edit-profile";
    }
    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute User updatedUser, HttpSession session) {

        User sessionUser = (User) session.getAttribute("loggedUser");

        if (sessionUser == null) {
            return "redirect:/login";
        }

        // keep same ID
        updatedUser.setId(sessionUser.getId());

        // keep credits & trust score
        updatedUser.setCredits(sessionUser.getCredits());
        updatedUser.setTrustScore(sessionUser.getTrustScore());

        userService.saveUser(updatedUser);

        // update session
        session.setAttribute("loggedUser", updatedUser);

        return "redirect:/profile";
    }
}