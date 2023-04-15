package com.greenjourneys.controller;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IReviewService;
import com.greenjourneys.services.ReviewService;
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


}