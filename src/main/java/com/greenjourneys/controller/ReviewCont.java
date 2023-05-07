package com.greenjourneys.controller;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ReviewService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Reviews"})
@CrossOrigin( origins = {"http://localhost:4200"} )

public class ReviewCont extends GenericController<Review, Long> {

    private final ReviewService reviewService;

    @GetMapping("/ReviewList")
    public List<Review> getReviews(){
        return reviewService.getallReviews();
    }
    /****************************ajout mta3 review ***********************/




    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return reviewService.saveReview(review);
    }

    /********************************Update Review************************************/




    @PutMapping("updateRev/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable("id") Long id){
        return reviewService.updateReview(review,id);
    }



    /********************************Delete Review By Id************************************/





    @DeleteMapping("deleteByIdRev/{id}")
    public void deleteRevById(@PathVariable Long id){
        reviewService.deleteReviewById(id);
    }



    /********************************Assign review to Activity************************************/




    @PostMapping("/Activities/addReviews")
    public void assignReviewToActivity(Long idActivity, Long id){
        reviewService.assignReviewToActivity(idActivity,id);
    }
    /********************************Assign review to Event************************************/





    @PostMapping("/Events/addReviews")
    public void assignReviewToEvent(Long idEvent, Long id) {
        reviewService.assignReviewToEvent(idEvent,id);
    }
    /********************************Assign review to Accomodation************************************/




    @PostMapping("/Accomodations/addReviews")
    public void assignReviewToAccomodation(Long idAcc, Long id) {
        reviewService.assignReviewToAccomodation(idAcc,id);
    }
    /********************************Get Reviews by Type************************************/


    @GetMapping("/{Type}/getReviews")
    public List<Review> getReviewsByType(String Type) {
        return reviewService.getReviewsByType(Type);
    }





}