package com.greenjourneys.repositories;


import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Reservation;
import com.greenjourneys.entities.TypeAccomodation;
import com.greenjourneys.generic.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IAccomodation extends BaseRepository<Accomodation, Long> {
}
