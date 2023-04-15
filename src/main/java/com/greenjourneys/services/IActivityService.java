package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericService;

import java.util.List;

public interface IActivityService extends IGenericService<Activity,Long> {
    Activity add(Activity entity);

    Activity update(Activity entity);

    Activity getActivityById(long id);

    List<Activity> retrieveAllActivities();

    void removeActivity(long Id);

    Activity getActivityByReview(Activity act, Review Rev);

    Review assignReviewToActivity(Long idActivity, long IdReview);
}
