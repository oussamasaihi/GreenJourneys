package com.greenjourneys.controller;

import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IReviewService;
import com.greenjourneys.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/Reviews"})
@CrossOrigin( origins = {"http://localhost:4200"} )
@Tag(
        name = "Reviews",
        description = "Reviews of Activities , Accomodations and Events "
)
public class ReviewCont extends GenericController<Review, Long> {
    @Autowired
    ReviewService reviewService;


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


}