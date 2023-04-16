package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IActivity;
import com.greenjourneys.repositories.IReview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActivityService extends IGenericServiceImp<Activity,Long> implements IActivityService  {
    @Autowired
    @PersistenceContext

    IActivity a;
    IReview rev;


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


    public Activity add(Activity activity) {
        return a.save(activity);
    }

    @Override
    public List<Activity> updateActivities(List<Activity> listActivities) {
        return a.saveAll(listActivities);
    }

    public Activity update(Activity activity) {
        return a.save(activity);
    }
    public List<Activity> getActivitiesWithBestReviewsByRate(int limit, int rate) {
        // njibou les activités lkol
        List<Activity> activities = retrieveAllActivities();

        // filtriw les activités 7asb rate li fil parametre ama 7atit get Reviews static hne
        List<Activity> activitiesWithBestReviews = activities.stream()
                .filter(activity -> activity.getReviews() != null && !activity.getReviews().isEmpty())
                .filter(activity -> activity.getReviews().stream()
                        .anyMatch(review -> review.getRate() == rate))
                .collect(Collectors.toList());

        // nratbouhom decroissant 7asb e rate
        activitiesWithBestReviews.sort(Comparator.comparingDouble(activity -> Activity.getReviews().stream()
                        .filter(review -> review.getRate() == rate)
                        .mapToDouble(Review::getRate)
                        .average()
                        .orElse(0.0))
                .reversed());

        // n7otou limit li reviews li jebnhom 7asb limit li 3anna fil parametre
        return activitiesWithBestReviews.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }





}
