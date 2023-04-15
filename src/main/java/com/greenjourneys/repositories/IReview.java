package com.greenjourneys.repositories;

import com.greenjourneys.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReview extends JpaRepository<Review,Long> {

}
