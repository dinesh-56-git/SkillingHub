package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.Session;
import com.skill_barter.skill_barter.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // 👉 Create session
    @PostMapping("/sessions/create")
    public String createSession(Session session) {
        sessionService.createSession(session);
        return "redirect:/dashboard";
    }

    // 👉 Complete session (credit transfer)
    @GetMapping("/sessions/complete/{id}")
    public String completeSession(@PathVariable Long id) {
        sessionService.completeSession(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/view-sessions")
    public String viewSessions() {
        return "view-sessions";
    }
}