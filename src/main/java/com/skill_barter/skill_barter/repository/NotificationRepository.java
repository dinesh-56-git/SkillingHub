package com.skill_barter.skill_barter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skill_barter.skill_barter.entity.Notification;
import com.skill_barter.skill_barter.entity.User;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUser(User user);
}