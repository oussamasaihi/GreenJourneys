package com.greenjourneys.controller;

import com.greenjourneys.entities.Activity;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Activities"})
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@Tag(name = "Activity", description = "Gestion des Activités")
public class ActivityCont extends GenericController<Activity, Long> {

    private final ActivityService activityService;

    /****************************ajout mta3 Activitiiiiii ***********************/
    @Operation(summary = "Add Activity", description = "Ajouter une nouvelle activité ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addActivity")
    public Activity addActivity(@RequestBody Activity activity){
        return activityService.add(activity);
    }

    /************Ajout mta3 lista mta3 activitiet***********************/
    @Operation(summary = "Add Activity", description = "Ajouter une liste des activités ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addListactivity")
    public List<Activity> addActivities(@RequestBody List<Activity> listActivities){
        return activityService.updateActivities(listActivities);
    }
    @Operation(summary = "Update Activity", description = "Mettre à jour Activity ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Update failed",content = @Content)
    })
    @PutMapping("updateAct/{id}")
    public Activity updateActivity(@RequestBody Activity activity){
        return activityService.update(activity);
    }



    /********************************Delete activity By Id************************************/
    @Operation(summary = "Delete Activity", description = "Supprimer une activité ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Delete failed",content = @Content)
    })
    @DeleteMapping("deleteByIdAct/{id}")
    public void deleteActById(@PathVariable("id") Long id){
        activityService.removeActivity(id);
    }


    /********************************Get All Activities************************************/
    @Operation(summary = "Get All Activities", description = "Retourne la liste des activités")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Activities", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Empty List", content = @Content)
    })
    @GetMapping("listeActivities")
    public Page<Activity> listeActivities(@RequestParam(name = "page", defaultValue = "0") int page,
                                          @RequestParam(name = "size", defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Activity> pageResult = activityService.listeActivities(pageRequest);
        return pageResult;
    }


    /********************************Get Activity By Review************************************/
    @Operation(summary = "Get Activities by Review", description = "Gets an activity by reviw in parametre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Activities", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Activties not found", content = @Content)
    })
    @GetMapping("/Activity/Review")
    public Activity getActivityByReview(Activity act, Review Rev) {
        return activityService.getActivityByReview(act ,Rev);
    }

    /********************************Get Activities with best Reviews************************************/
    @Operation(summary = "Find Best Activities", description = "Gets activities with best reviews")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Activities", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Activity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Activties not found", content = @Content)
    })
    @GetMapping("/Activities/{limit}")
    public List<Activity> getActivitiesWithBestReviews(int limit){
        return activityService.getActivitiesWithBestReviewsByRate(limit);
    }





}