package com.greenjourneys.services;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public interface IReviewService {

    Review saveReview(Review review);
    Review updateReview(Review review, Long id);
    void deleteReviewById(Long id);
    List<Review> getallReviews();
    public void assignReviewToActivity(Long idActivity, Long id) ;
    public void assignReviewToAccomodation(Long idAccomodation, Long id) ;
    //public void assignReviewToEvent(Long idEvent, Long id) ;

    public List<Review> getReviewsByType (String entity) ;
}
