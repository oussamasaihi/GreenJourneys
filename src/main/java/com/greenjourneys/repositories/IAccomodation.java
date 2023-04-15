package com.greenjourneys.repositories;


import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Activity;
import com.greenjourneys.generic.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccomodation extends JpaRepository<Accomodation,Long> {
    @Query(value = "select ac from Accomodation ac where ac.name=?1 and ac.Address=?2",nativeQuery = true)
    List<Activity> getActivityByNameAndAddress(String name, String address);
}
