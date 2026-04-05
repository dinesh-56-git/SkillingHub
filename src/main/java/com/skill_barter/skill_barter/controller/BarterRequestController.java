package com.skill_barter.skill_barter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.skill_barter.skill_barter.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.skill_barter.skill_barter.entity.BarterRequest;
import com.skill_barter.skill_barter.entity.User;
import com.skill_barter.skill_barter.service.BarterRequestService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BarterRequestController {

    @Autowired
    private BarterRequestService requestService;
    @Autowired
    private UserRepository userRepository;

    // Open send request page
    @GetMapping("/send-request")
    public String sendRequestPage() {
        return "send-request";
    }

    @PostMapping("/requests/send")
    public String sendRequest(@ModelAttribute BarterRequest request, HttpSession session) {

        User sender = (User) session.getAttribute("loggedUser");

        if (sender == null) {
            return "redirect:/login";
        }

        request.setSender(sender);

       
        requestService.sendRequest(request);

        return "redirect:/dashboard";
    }
    @PostMapping("/schedule/save")
    public String saveSchedule(@RequestParam String date,
                               @RequestParam String time,
                               @RequestParam String link,
                               Model model) {

        model.addAttribute("message",
            "Meeting scheduled! Join: " + link);

        return "success";
    }

    @GetMapping("/requests/accept/{id}")
    public String acceptRequest(@PathVariable Long id, Model model) {

        BarterRequest request = requestService.acceptRequest(id);

        model.addAttribute("message", 
            "Request Accepted! Both users can now schedule classes.");

        return "success";
    }

    @GetMapping("/view-requests")
    public String viewRequests(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        model.addAttribute("requests",
            requestService.getUserRequests(user));

        return "view-requests";
    }
    @GetMapping("/requests/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "redirect:/view-requests";
    }
    @GetMapping("/schedule/{id}")
    public String schedulePage(@PathVariable Long id, Model model) {

        model.addAttribute("requestId", id);

        return "schedule";
    }
    @GetMapping("/chat/{id}")
    public String chatPage(@PathVariable Long id) {
        return "chat";
    }
}