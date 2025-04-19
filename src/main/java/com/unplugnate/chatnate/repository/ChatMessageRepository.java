package com.unplugnate.chatnate.repository;

import com.unplugnate.chatnate.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
