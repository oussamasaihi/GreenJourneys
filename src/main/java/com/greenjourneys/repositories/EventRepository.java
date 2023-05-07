package com.greenjourneys.repositories;

import com.greenjourneys.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
   // @Query("select e from Event e where e.")
    //List<Event> getNewEventFor(Integer idUser);
}
