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

    // 👉 LOGIN LOGIC
    @PostMapping("/login")
    public String login(String email, String password, HttpSession session) {

        User user = userService.login(email, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);

            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin-dashboard";
            }
            return "redirect:/dashboard";
        }

        return "redirect:/login?error=true";
    }

    // 👉 LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}