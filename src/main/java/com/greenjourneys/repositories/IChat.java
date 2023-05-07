package com.greenjourneys.repositories;

import com.greenjourneys.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChat extends JpaRepository<Chat, Long> {
}
