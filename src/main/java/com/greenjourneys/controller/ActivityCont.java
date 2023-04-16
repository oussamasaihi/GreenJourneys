package com.greenjourneys.controller;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ActivityService;
import com.greenjourneys.services.IActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TableGenerator;
import java.util.List;

@RestController
@RequestMapping({"/Activities"})
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@Tag (name = "Activity", description = "Gestion des Activités")
public class ActivityCont extends GenericController<Activity, Long> {
    @Autowired
    ActivityService activityService;

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
    @Operation(summary = "Add Reclamation", description = "Ajouter une liste de reclamations ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reclamation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addListactivity")
    public List<Activity> addActivities(@RequestBody List<Activity> listActivities){
        return activityService.updateActivities(listActivities);
    }


}