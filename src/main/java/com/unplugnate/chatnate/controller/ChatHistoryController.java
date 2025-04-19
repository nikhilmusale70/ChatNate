package com.unplugnate.chatnate.controller;

import com.unplugnate.chatnate.model.ChatMessage;
import com.unplugnate.chatnate.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatHistoryController {

    @Autowired
    private ChatMessageRepository chatRepo;

    @GetMapping("/history")
    public List<ChatMessage> getChatHistory() {
        return chatRepo.findAll();
    }
}
