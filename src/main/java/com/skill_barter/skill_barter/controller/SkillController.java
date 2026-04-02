package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.service.SkillService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    // 👉 Open Add Skill Page
    @GetMapping("/add-skill")
    public String addSkillPage() {
        return "add-skill";
    }

    // 👉 Save Skill
    @PostMapping("/save-skill")
    public String saveSkill(Skill skill) {
        skillService.saveSkill(skill);
        return "redirect:/view-skills";
    }

    // 👉 View Skills
    @GetMapping("/view-skills")
    public String viewSkills(Model model) {
        model.addAttribute("skills", skillService.getAllSkills());
        return "view-skills";
    }
}