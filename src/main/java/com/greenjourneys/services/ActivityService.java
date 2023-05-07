package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.entities.User;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IActivity;
import com.greenjourneys.repositories.IReview;
import com.greenjourneys.repositories.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityService extends IGenericServiceImp<Activity,Long> implements IActivityService  {

    private final IActivity a;
    private final IReview rev;
    IUser iUser ;
    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public ActivityService(IActivity a, IReview rev) {
//        this.a = a;
//        this.rev = rev;
//    }


    public Activity getActivityById(long id) {
        return (Activity)this.a.findById(id).orElse((Activity) null);
    }

    public List<Activity> retrieveAllActivities() {
        return a.findAll();
    }

    public void removeActivity(long Id) {
        a.deleteById(Id);
    }

    public Activity getActivityByReview(Activity act, Review Rev) {
        TypedQuery<Activity> query = entityManager.createQuery(
                "SELECT a FROM Activity a JOIN a.reviewsActivity r WHERE r = :review", Activity.class);
        query.setParameter("review", rev);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }


    public Activity add(Activity activity) {
        return a.save(activity);
    }


    @Override
    public Page<Activity> listeActivities(Pageable pageable) {
        return a.findAll(pageable);
    }

    public Activity update(Activity activity) {
        return a.save(activity);
    }
    public List<Activity> getActivitiesWithBestReviewsByRate(int limit) {
        // Retrieve all activities
        List<Activity> activities = retrieveAllActivities();

        // Filter activities with non-empty reviews
        List<Activity> activitiesWithBestReviews = activities.stream()
                .filter(activity -> activity.getReviewsActivity() != null && !activity.getReviewsActivity().isEmpty())
                .collect(Collectors.toList());

        // Sort activities based on average review rate in descending order
        activitiesWithBestReviews.sort(Comparator.comparingDouble(activity ->
                -activity.getReviewsActivity().stream()
                        .mapToDouble(Review::getRate)
                        .average()
                        .orElse(0.0)));

        // Limit activities based on limit parameter
        return activitiesWithBestReviews.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Activity> getActivitiesByType(String activtyType) {
        return a.getActivityByType(activtyType);
    }

    @Override
    public void AssignUserToActivity(User user, long activityId) {
        Optional<Activity> activityOptional = a.findById(activityId);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            user.setActivity(activity);
            iUser.save(user);
        } else {
            // handle the case when activity with the given ID is not found
        }
    }



}
