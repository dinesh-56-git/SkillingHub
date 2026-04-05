package com.skill_barter.skill_barter.repository;

import com.skill_barter.skill_barter.entity.BarterRequest;
import java.util.List;
import com.skill_barter.skill_barter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.skill_barter.skill_barter.entity.User;
@Repository
public interface BarterRequestRepository extends JpaRepository<BarterRequest, Long> {
	List<BarterRequest> findByReceiver(User receiver);
	List<BarterRequest> findBySenderOrReceiver(User sender, User receiver);
}