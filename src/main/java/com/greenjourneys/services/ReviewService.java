package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Activity;
import com.greenjourneys.entities.Review;
import com.greenjourneys.entities.User;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IActivity;
import com.greenjourneys.repositories.IReview;
import com.greenjourneys.repositories.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService extends IGenericServiceImp<Review, Long> implements IReviewService {
    @Autowired
    IReview iReview;
    @Autowired
    IUser iUser ;
    @Autowired
    IActivity iActivity ;

    @Override
    public Optional<Review> getReviewbyId(Long id) {
        return iReview.findById(id);
    }

    @Override
    public Review saveReview(Review review) {
        return iReview.save(review);
    }

    @Override
    public List<Review> saveReviews(List<Review> listReviews) {
        return iReview.saveAll(listReviews);
    }

    @Override
    public Review updateReview(Review review, Long id) {
        return iReview.save(review);
    }

    @Override
    public List<Review> updateReviews(List<Review> listReviews) {
        return iReview.saveAll(listReviews);
    }

    @Override
    public void deleteReviewById(Long id) {
        iReview.deleteById(id);

    }

    @Override
    public void deleteReview(Review review) {
        iReview.delete(review);
    }

    @Override
    public Page<Review> listeRewiews(Pageable pageable) {
       return iReview.findAll(pageable);
    }
    /*review Eevent
    /review accomodation
    /review Activity*/

}
