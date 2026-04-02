package com.skill_barter.skill_barter.service;

import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
    public long getSkillCount() {
        return skillRepository.count();
    }
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }
   
}