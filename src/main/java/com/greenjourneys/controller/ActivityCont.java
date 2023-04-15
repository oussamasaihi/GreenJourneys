package com.greenjourneys.controller;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IActivityService;
import jdk.jfr.Name;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TableGenerator;
import java.util.List;

@RestController
@RequestMapping({"/Activities"})
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
//@Tag (name = "Activity", description = "Gestion des Activités")*/
public class ActivityCont extends GenericController<Activity, Long> {
    private IActivityService ias;

    @GetMapping({"/{id}"})
    public Activity retrieveById(Long aLong) {
        return (Activity)this.ias.retrieveById(aLong);
    }

    @PutMapping({"/{id}"})
    public Activity update(Activity entity) {
        return this.ias.update(entity);
    }

    @PostMapping
    public Activity add(Activity entity) {
        return this.ias.add(entity);
    }

    @GetMapping
    public List<Activity> retrieveAll() {
        return this.ias.retrieveAll();
    }

    @DeleteMapping({"/{id}"})
    public Boolean delete(Long aLong) {
        return this.ias.delete(aLong);
    }

    public ActivityCont() {
    }
}