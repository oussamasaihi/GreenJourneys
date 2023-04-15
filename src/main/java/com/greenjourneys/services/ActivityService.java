package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IActivity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional

public class ActivityService extends IGenericServiceImp<Activity,Long> implements IActivityService  {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    private final IActivity a;
    private final IReviewService rev;

    public Activity getActivityById(long id) {
        return (Activity)this.a.findById(id).orElse((Activity) null);
    }

    public List<Activity> retrieveAllActivities() {
        return this.a.findAll();
    }

    public void removeActivity(long Id) {
        this.a.deleteAllById(Collections.singleton(Id));
    }

    public Activity getActivityByReview(Activity act, Review Rev) {
        return null;
    }

    public Review assignReviewToActivity(Long idActivity, long IdReview) {
        return null;
    }

    public Activity add(Activity activity) {
        return (Activity)this.a.save(activity);
    }

    public Activity update(Activity activity) {
        return (Activity)this.a.save(activity);
    }

    public ActivityService(final IActivity a, final IReviewService rev) {
        this.a = a;
        this.rev = rev;
    }
}
