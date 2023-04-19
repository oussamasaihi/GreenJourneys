package com.greenjourneys.controller;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Reviews"})
@CrossOrigin( origins = {"http://localhost:4200"} )
@Tag(
        name = "Reviews",
        description = "Reviews of Activities , Accomodations and Events "
)
public class ReviewCont extends GenericController<Review, Long> {

    private final ReviewService reviewService;


    /****************************ajout mta3 review ***********************/
    @Operation(summary = "Add Review", description = "Ajouter un review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addReview")
    public Review addReview(@RequestBody Review review){
        return reviewService.saveReview(review);
    }

    /************Ajout mta3 lista mta3 reviews ***********************/
    @Operation(summary = "Add Reviews", description = "Ajouter une liste des reviews ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addListReview")
    public List<Review> addReviews(@RequestBody List<Review> listReviews){
        return reviewService.saveReviews(listReviews);
    }
    /********************************Update Review************************************/
    @Operation(summary = "Update Review", description = "Mettre à jour un Review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Update failed",content = @Content)
    })
    @PutMapping("updateRev/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable("id") Long id){
        return reviewService.updateReview(review,id);
    }


    /********************************Delete A Review************************************/
    @Operation(summary = "Delete Review", description = "Supprimer un Review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Delete failed",content = @Content)
    })
    @DeleteMapping("deleteRev")
    public void deleteReview(@RequestBody Review review){
        reviewService.deleteReview(review);
    }


    /********************************Delete Review By Id************************************/
    @Operation(summary = "Delete Review by Id", description = "Supprimer un Review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Delete failed",content = @Content)
    })
    @DeleteMapping("deleteByIdRev/{id}")
    public void deleteRevById(@PathVariable("id") Long id){
        reviewService.deleteReviewById(id);
    }



    /********************************Assign review to Activity************************************/
    @Operation(summary = "Make an activity Review", description = "gets All activity reviews ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Activity Reviewed",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Empty List ",content = @Content)
    })
    @PostMapping("/Activities/addReviews")
    public void assignReviewToActivity(Long idActivity, Long id){
        reviewService.assignReviewToActivity(idActivity,id);
    }
    /********************************Assign review to Event************************************/
    @Operation(summary = "Make an Event Review", description = "gets All Events and make review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event Reviewd",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Empty List ",content = @Content)
    })
    @PostMapping("/Events/addReviews")
    public void assignReviewToEvent(Long idEvent, Long id) {
        reviewService.assignReviewToEvent(idEvent,id);
    }
    /********************************Assign review to Accomodation************************************/
    @Operation(summary = "Make an Accomodation Review", description = "gets All Accomodations and make review ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accomodation Reviewd",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Empty List ",content = @Content)
    })
    @PostMapping("/Accomodations/addReviews")
    public void assignReviewToAccomodation(Long idAcc, Long id) {
        reviewService.assignReviewToAccomodation(idAcc,id);
    }
    /********************************Get Reviews by Type************************************/
    @Operation(summary = "get all reviews of a Type", description = "gets All Reviews to a type ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews Found",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Review.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Empty List ",content = @Content)
    })
    @GetMapping("/{Type}/getReviews")
    public List<Review> getReviewsByType(String entity) {
        return reviewService.getReviewsByType(entity);
    }



}