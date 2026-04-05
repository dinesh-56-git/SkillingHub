package com.skill_barter.skill_barter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill_barter.skill_barter.entity.BarterRequest;
import com.skill_barter.skill_barter.entity.Skill;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.repository.BarterRequestRepository;
import com.skill_barter.skill_barter.repository.SkillRepository;
import com.skill_barter.skill_barter.repository.UserRepository;

@Service
public class BarterRequestService {
	@Autowired
	private SkillRepository skillRepository;

    @Autowired
    private BarterRequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;

    // Send request
    public BarterRequest sendRequest(BarterRequest request) {
    	 request.setStatus("PENDING");
    	    BarterRequest savedRequest = requestRepository.save(request);

    	    List<Skill> skills = skillRepository.findAll();

    	    for (Skill skill : skills) {

    	        if (skill.getSkillName().equalsIgnoreCase(request.getSkill())) {

    	            User user = skill.getUser(); // owner of skill

    	            // ❗ skip sender
    	            if (!user.getId().equals(request.getSender().getId())) {

    	                notificationService.sendNotification(
    	                        user,
    	                        "New request for skill: " + request.getSkill()
    	                );
    	            }
    	        }
    	    }

        return savedRequest;
    }


    public BarterRequest acceptRequest(Long id) {

        BarterRequest request = requestRepository.findById(id).orElse(null);

        if (request == null) return null;

        request.setStatus("ACCEPTED");

        User sender = request.getSender();
        User receiver = request.getReceiver();

        if (receiver == null) {
            receiver = sender; // temporary fallback
        }

        if (sender != null && receiver != null && sender.getCredits() >= 1) {

            sender.setCredits(sender.getCredits() - 1);
            receiver.setCredits(receiver.getCredits() + 1);

            userRepository.save(sender);
            userRepository.save(receiver);
        }
       

        return requestRepository.save(request);
    }

    public List<BarterRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public List<BarterRequest> getUserRequests(User user) {
        return requestRepository.findBySenderOrReceiver(user, user);
    }
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}