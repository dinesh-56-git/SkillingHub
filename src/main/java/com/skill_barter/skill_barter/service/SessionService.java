package com.skill_barter.skill_barter.service;
import java.util.List;
import com.skill_barter.skill_barter.entity.Session;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.repository.SessionRepository;
import com.skill_barter.skill_barter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    public Session createSession(Session session) {
        session.setStatus("PENDING");
        return sessionRepository.save(session);
    }

    public void completeSession(Long sessionId) {

        Session session = sessionRepository.findById(sessionId).orElse(null);

        if (session != null) {

            User teacher = session.getTeacher();
            User learner = session.getLearner();

            int duration = session.getDuration();

            // 💰 CREDIT TRANSFER
            teacher.setTimeCredits(teacher.getTimeCredits() + duration);
            learner.setTimeCredits(learner.getTimeCredits() - duration);

            session.setStatus("COMPLETED");

            userRepository.save(teacher);
            userRepository.save(learner);
            sessionRepository.save(session);
        }
    }
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}