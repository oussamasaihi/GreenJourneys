package com.greenjourneys.services;

import com.greenjourneys.entities.Review;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IReview;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewService extends IGenericServiceImp<Review, Long> implements IReviewService {
    private final IReview iReview;

    public List<Review> retrieveAll() {
        return super.retrieveAll();
    }

    public Review retrieveById(Long aLong) {
        return (Review)super.retrieveById(aLong);
    }

    public Review update(Review entity) {
        return (Review)super.update(entity);
    }

    public Review add(Review entity) {
        return (Review)super.add(entity);
    }

    public Boolean delete(Long aLong) {
        return super.delete(aLong);
    }

    public Review getReviewbyId() {
        return this.iReview.findById();
    }

    public ReviewService(final IReview iReview) {
        this.iReview = iReview;
    }
}
