package com.unplugnate.chatnate.controller;

import com.unplugnate.chatnate.model.ChatMessage;
import com.unplugnate.chatnate.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository chatRepo;

    @MessageMapping("/chat")
    public void receiveMessage(@Payload ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        chatRepo.save(message); // ✅ Save to DB
        messagingTemplate.convertAndSend("/topic/messages", message); // ✅ Broadcast
        System.out.println("Saved and sent: " + message.getContent());
    }
}
