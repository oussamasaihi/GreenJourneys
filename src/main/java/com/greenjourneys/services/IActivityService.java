package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActivityService  {
    Activity add(Activity entity);

    public Page<Activity> listeActivities(Pageable pageable) ;

    Activity update(Activity entity);

    Activity getActivityById(long id);

    List<Activity> retrieveAllActivities();

    void removeActivity(long Id);

    Activity getActivityByReview(Activity act, Review Rev);
    public List<Activity> getActivitiesWithBestReviewsByRate(int limit) ;
    public List<Activity> getActivitiesByType(String activtyType);
    public void AssignUserToActivity (User user , long activityId);

}
