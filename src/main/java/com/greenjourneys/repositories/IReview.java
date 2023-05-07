package com.greenjourneys.repositories;

import com.greenjourneys.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IReview extends JpaRepository<Review,Long> {
    @Modifying
    @Query("UPDATE Accomodation a SET a.idAccomodation = :review WHERE a.idAccomodation = :idAccomodation")
    void assignReviewToAccomodation(@Param("idAccomodation") Long idAccomodation, @Param("review") Long review);
    @Modifying
    @Query("UPDATE Activity a SET a.reviewsActivity = :review WHERE a.idActivity = :idActivity")
    void assignReviewToActivity(@Param("idActivity") Long idActivity, @Param("review") Long review);
   // @Modifying
//    @Query("UPDATE Event e SET e.reviewsEvent = :review WHERE e.IdEvent = :idEvent")
//    void assignReviewToEvent(@Param("idEvent") Long idEvent, @Param("review") Long review);
    @Query("SELECT r FROM Review r WHERE r.accomodation IS NOT NULL")
    List<Review> findAllByAccommodationIsNotNull();

    @Query("SELECT r FROM Review r WHERE r.activity IS NOT NULL")
    List<Review> findAllByActivityIsNotNull();

    @Query("SELECT r FROM Review r WHERE r.event IS NOT NULL")
    List<Review> findAllByEventIsNotNull();

}
