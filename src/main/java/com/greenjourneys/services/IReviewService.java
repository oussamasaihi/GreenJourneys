package com.greenjourneys.services;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IReviewService extends IGenericService<Review, Long> {
    Optional<Review> getReviewbyId(Long id);
    Review saveReview(Review review);
    List<Review> saveReviews(List<Review> listReviews);
    Review updateReview(Review review, Long id);
    List<Review> updateReviews(List<Review> listReviews);
    void deleteReviewById(Long id);
    void deleteReview(Review review);
    Page<Review> listeRewiews(Pageable pageable);
}
