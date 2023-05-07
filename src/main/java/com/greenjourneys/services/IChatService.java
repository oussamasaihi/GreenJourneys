package com.greenjourneys.services;

import com.greenjourneys.entities.Chat;

import java.util.List;

public interface IChatService {
    Chat getChatById(long id);

    Chat addChat(Chat c);

    List<Chat> getAllChat();

    void deleteChat(long idChat);

    Chat updateChat(Chat chat);
}
