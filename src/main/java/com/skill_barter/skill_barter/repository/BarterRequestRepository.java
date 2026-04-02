package com.skill_barter.skill_barter.repository;

import com.skill_barter.skill_barter.entity.BarterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarterRequestRepository extends JpaRepository<BarterRequest, Long> {
}