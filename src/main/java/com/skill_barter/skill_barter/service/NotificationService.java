package com.skill_barter.skill_barter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill_barter.skill_barter.entity.Notification;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(User user, String message) {
        Notification n = new Notification();
        n.setUser(user);
        n.setMessage(message);
        notificationRepository.save(n);
    }

    public List<Notification> getUserNotifications(User user) {
        return notificationRepository.findByUser(user);
    }
}