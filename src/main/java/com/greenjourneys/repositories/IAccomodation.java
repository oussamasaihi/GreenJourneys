package com.greenjourneys.repositories;


import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAccomodation extends JpaRepository<Accomodation,Long> {
   @Query(value = "select ac from Accomodation ac where ac.name=?1 and ac.Address=?2",nativeQuery = true)
    List<Activity> getActivityByNameAndAddress(String name, String address);


}
