package com.greenjourneys.controller;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ActivityService;
import com.greenjourneys.services.IActivityService;
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
    private ActivityService activityService;


}