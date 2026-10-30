package com.connectsphere.controller;
import com.connectsphere.entity.ChatMessage; import com.connectsphere.repository.ChatMessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping; import org.springframework.messaging.handler.annotation.SendTo; import org.springframework.stereotype.Controller;
@Controller
public class ChatController {
 private final ChatMessageRepository messages; public ChatController(ChatMessageRepository r){messages=r;}
 @MessageMapping("/chat.send") @SendTo("/topic/public")
 public ChatMessage send(ChatMessage message){return messages.save(message);}
}
