package com.greenjourneys.repositories;

import com.greenjourneys.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvent extends JpaRepository<Event,Long> {
}
