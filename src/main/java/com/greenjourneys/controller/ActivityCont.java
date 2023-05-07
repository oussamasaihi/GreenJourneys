package com.greenjourneys.controller;

import com.greenjourneys.entities.Activity;

import com.greenjourneys.entities.ActivityType;
import com.greenjourneys.entities.Review;
import com.greenjourneys.entities.User;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Activities"})
@CrossOrigin(origins = {"http://localhost:4200"})
public class ActivityCont extends GenericController<Activity, Long> {

    private final ActivityService activityService;
    @PostMapping("addActivity")
    public Activity addActivity(@RequestBody Activity activity){
        return activityService.add(activity);
    }



    @PutMapping("updateAct/{id}")
    public Activity updateActivity(@RequestBody Activity activity){
        return activityService.update(activity);
    }



    /********************************Delete activity By Id************************************/

    @DeleteMapping("deleteByIdAct/{id}")
    public void deleteActById(@PathVariable("id") Long id){
        activityService.removeActivity(id);
    }


    /********************************Get All Activities************************************/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("listeActivities")
    public List<Activity> listeActivities() {
        return activityService.retrieveAllActivities();
    }


    /********************************Get Activity By Review************************************/

    @GetMapping("/Activity/Review")
    public Activity getActivityByReview(Activity act, Review Rev) {
        return activityService.getActivityByReview(act ,Rev);
    }
    /********************************Get Activity with best reviews ************************************/

    @GetMapping("/Activities/{limit}")
    public List<Activity> getActivitiesWithBestReviews(int limit){
        return activityService.getActivitiesWithBestReviewsByRate(limit);
    }

    @GetMapping("{activityType}")
    public List<Activity> getActivitiesByType(@RequestParam String activityType) {
        return activityService.getActivitiesByType(activityType);
    }
    @PostMapping("/{activityId}/assign-user/{user}")
    public void assignUserToActivity(@RequestBody User user , @PathVariable long activityId) {
        activityService.AssignUserToActivity(user, activityId);
    }


}