package com.skill_barter.skill_barter.service;

import java.util.List;
import java.util.List;
import com.skill_barter.skill_barter.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // ✅ DELETE SKILL
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
    public long getSkillCount() {
        return skillRepository.count();
    }
    public List<Skill> getSkillsByUser(User user) {
        return skillRepository.findByUser(user);
    }
}