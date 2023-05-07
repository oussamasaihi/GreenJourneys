package com.greenjourneys.repositories;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEvent extends JpaRepository<Event,Long> {
    @Query(value = "select ac from Event ac where ac.Nom=?1 and ac.Region=?2",nativeQuery = true)
    List<Activity> getEventByNameAndRegion(String name, String region);
}
