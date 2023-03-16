package com.greenjourneys.repositories;

import com.greenjourneys.entities.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccomodation extends JpaRepository<Accomodation,Long> {
}
