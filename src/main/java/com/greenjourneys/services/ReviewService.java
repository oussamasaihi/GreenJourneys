package com.greenjourneys.services;

import com.greenjourneys.entities.Review;
import com.greenjourneys.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService implements IReviewService {

    private final IReview iReview;

    @Override
    public Review saveReview(Review review) {
        return iReview.save(review);
    }

    @Override
    public Review updateReview(Review review, Long id) {
        return iReview.save(review);
    }


    @Override
    public void deleteReviewById(Long id) {
        iReview.deleteById(id);

    }


    @Override
    public List<Review> getallReviews() {
        return iReview.findAll();
    }

    /*review Eevent
    /review accomodation
    /review Activity*/
    @Override
    public void assignReviewToActivity(Long idActivity, Long id) {

        iReview.assignReviewToActivity(idActivity,id);
    }

    @Override
    public void assignReviewToAccomodation(Long idAccomodation, Long id) {
        iReview.assignReviewToAccomodation(idAccomodation,id);
    }

    @Override
    public void assignReviewToEvent(Long idEvent, Long id) {
        iReview.assignReviewToEvent(idEvent,id);
    }


    public List<Review> getReviewsByType(String entity) {
        List<Review> reviews = new ArrayList<>();

        // hne bech yrajja3 e les reviews lkol 7asb activity , accomodation walla event
        if ("accommodation".equalsIgnoreCase(entity)) {
            reviews = iReview.findAllByAccommodationIsNotNull();
        } else if ("activity".equalsIgnoreCase(entity)) {
            reviews = iReview.findAllByActivityIsNotNull();
        } else if ("event".equalsIgnoreCase(entity)) {
            reviews = iReview.findAllByEventIsNotNull();
        } else {
            throw new IllegalArgumentException("Invalid entity type: " + entity);
        }

        return reviews;
    }

}
