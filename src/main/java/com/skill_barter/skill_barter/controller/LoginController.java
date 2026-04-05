package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 👉 LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userService.login(email, password);

        if (user != null) {

            session.setAttribute("loggedUser", user);

            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin";
            } else {
                return "redirect:/dashboard";
            }
        }

        return "login"; // invalid login
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    @GetMapping("/admin")
    public String adminDashboard(HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/dashboard";
        }

        return "admin";
    }
}