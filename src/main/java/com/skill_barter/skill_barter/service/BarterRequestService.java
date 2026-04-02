package com.skill_barter.skill_barter.service;

import com.skill_barter.skill_barter.entity.BarterRequest;
import com.skill_barter.skill_barter.repository.BarterRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarterRequestService {

    @Autowired
    private BarterRequestRepository requestRepository;

    public BarterRequest sendRequest(BarterRequest request) {
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    public BarterRequest acceptRequest(Long id) {
        BarterRequest request = requestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus("ACCEPTED");
            return requestRepository.save(request);
        }
        return null;
    }
}