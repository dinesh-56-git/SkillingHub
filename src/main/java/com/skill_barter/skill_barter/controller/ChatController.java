package com.skill_barter.skill_barter.controller;

import org.springframework.stereotype.Controller;

import com.skill_barter.skill_barter.entity.ChatMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
}