package com.greenjourneys.controller;

import com.greenjourneys.entities.Interest;
import com.greenjourneys.services.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class IntrestCont {
    public final InterestService interestService ;
    @GetMapping({"/interests"})
    public List<Interest> retrieve() {
        return interestService.getAllInterest();
    }

    @GetMapping({"/interest/{id}"})
    public Interest retrieveById(@PathVariable Long id) {
        return interestService.getInterstById(id);
    }

    @PostMapping({"/interest/add"})
    public Interest addInterest(@RequestBody Interest i) {
        return interestService.addInterest(i);
    }

    @DeleteMapping({"/interest/delete/{id}"})
    public void deleteInterest(@PathVariable long id) {
        interestService.iInterest.deleteById(id);
    }

    @PutMapping({"/interest/update"})
    public Interest updateInterest(@RequestBody Interest interest) {
        return interestService.updateInterest(interest);
    }
}
