package com.greenjourneys.repositories;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActivity extends JpaRepository<Activity,Long> {
    @Query(value = "select ac from Activity ac where ac.Name=?1 and ac.Region=?2")
    List<Activity> getActivityByNameAndRegion(String name, String region);
    @Query("SELECT a FROM Activity a JOIN a.reviewsActivity r WHERE r = :review")
    Activity getActivityByReview(@Param("review") Review review);



}
