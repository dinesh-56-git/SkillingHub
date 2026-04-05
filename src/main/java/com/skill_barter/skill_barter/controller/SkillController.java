package com.skill_barter.skill_barter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.service.SkillService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/add-skill")
    public String addSkillPage() {
        return "add-skill";
    }

    @PostMapping("/save-skill")
    public String saveSkill(@ModelAttribute Skill skill, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        skill.setUser(user);  

        skillService.saveSkill(skill);

        return "redirect:/view-skills";
    }
    @GetMapping("/view-skills")
    public String viewSkills(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        model.addAttribute("skills", skillService.getSkillsByUser(user));

        return "view-skills";
    }

    @GetMapping("/delete-skill/{id}")
    public String deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return "redirect:/view-skills";
    }
}