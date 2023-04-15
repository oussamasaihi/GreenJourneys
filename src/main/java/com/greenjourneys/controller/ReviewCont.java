package com.greenjourneys.controller;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/Reviews"})
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
/*@Tag(
        name = "Reviews",
        description = "Reviews of Activities and Accomodations"
)*/
public class ReviewCont extends GenericController<Review, Long> {
    private final IReviewService reviewService;

    public List<Review> retrieveAll() {
        return this.reviewService.retrieveAll();
    }

    @PostMapping
    public Review add(Review entity) {
        return (Review)this.reviewService.add(entity);
    }

    @GetMapping({"/{id}"})
    public Review retrieveById(Long aLong) {
        return (Review)this.reviewService.retrieveById(aLong);
    }

    @PutMapping
    public Review update(Review entity) {
        return (Review)this.reviewService.update(entity);
    }

    @DeleteMapping({"/{id}"})
    public Boolean delete(Long aLong) {
        return this.reviewService.delete(aLong);
    }

    public ReviewCont(IReviewService reviewService) {
        this.reviewService = reviewService;
    }
}