package com.greenjourneys.controller;

import com.greenjourneys.entities.Chat;
import com.greenjourneys.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatCont {
    public final ChatService chatService;

    @GetMapping({"/chats"})
    public List<Chat> retrive() {
        return chatService.getAllChat();
    }

    @GetMapping({"/chat/{id}"})
    public Chat retriveById(@PathVariable Long id) {
        return chatService.getChatById(id);
    }

    @PostMapping({"/chat/add"})
    public Chat addChat(@RequestBody Chat c) {
        return chatService.addChat(c);
    }

    @DeleteMapping({"/chat/delete/{id}"})
    public void deleteChat(@PathVariable long id) {
        chatService.getChatById(id);
    }

    @PutMapping({"/chat/update"})
    public Chat updateChat(@RequestBody Chat chat) {
        return chatService.iChat.save(chat);
    }


}
