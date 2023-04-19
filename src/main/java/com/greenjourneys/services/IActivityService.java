package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActivityService extends IGenericService<Activity,Long> {
    Activity add(Activity entity);

    List<Activity> updateActivities(List<Activity> listActivities);
    public Page<Activity> listeActivities(Pageable pageable) ;

    Activity update(Activity entity);

    Activity getActivityById(long id);

    List<Activity> retrieveAllActivities();

    void removeActivity(long Id);

    Activity getActivityByReview(Activity act, Review Rev);
    public List<Activity> getActivitiesWithBestReviewsByRate(int limit) ;

}
