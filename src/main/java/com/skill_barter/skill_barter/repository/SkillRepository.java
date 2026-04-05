package com.skill_barter.skill_barter.repository;

import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.entity.User;
import java.util.List;
import com.skill_barter.skill_barter.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	List<Skill> findByUser(User user);
}