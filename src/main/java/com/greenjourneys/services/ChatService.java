package com.greenjourneys.services;

import com.greenjourneys.entities.Chat;
import com.greenjourneys.repositories.IChat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService{
    public final IChat iChat;
    @Override
    public Chat getChatById(long id) {
        return iChat.getReferenceById(id);
    }

    @Override
    public Chat addChat(Chat c) {
        return iChat.save(c);
    }

    @Override
    public List<Chat> getAllChat() {
        return iChat.findAll();
    }

    @Override
    public void deleteChat(long idChat) {
        iChat.deleteById(idChat);
    }

    @Override
    public Chat updateChat(Chat chat) {
        return iChat.save(chat) ;
    }
}
