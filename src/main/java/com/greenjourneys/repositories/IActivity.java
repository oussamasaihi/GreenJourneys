package com.greenjourneys.repositories;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActivity extends JpaRepository<Activity,Long> {
    @Query(value = "select ac from Activity ac where ac.Name=?1 and ac.Region=?2",nativeQuery = true)
    List<Activity> getActivityByNameAndRegion(String name, String region);



}
