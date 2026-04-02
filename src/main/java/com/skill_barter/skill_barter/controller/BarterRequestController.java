package com.skill_barter.skill_barter.controller;

import com.skill_barter.skill_barter.entity.BarterRequest;
import com.skill_barter.skill_barter.service.BarterRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BarterRequestController {

    @Autowired
    private BarterRequestService requestService;

    // 👉 Open send request page (optional UI)
    @GetMapping("/send-request")
    public String showRequestPage1() {
        return "send-request";
    }
  

    // 👉 Send request
    @PostMapping("/requests/send")
    public String sendRequest(BarterRequest request) {
        requestService.sendRequest(request);
        return "redirect:/dashboard";
    }

    // 👉 Accept request
    @GetMapping("/requests/accept/{id}")
    public String acceptRequest(@PathVariable Long id) {
        requestService.acceptRequest(id);
        return "redirect:/dashboard";
    }
}