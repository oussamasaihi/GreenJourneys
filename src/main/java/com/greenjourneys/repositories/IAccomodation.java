package com.greenjourneys.repositories;


import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.generic.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccomodation extends JpaRepository<Accomodation,Long> {
}
