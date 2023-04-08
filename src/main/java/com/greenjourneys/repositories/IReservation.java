package com.greenjourneys.repositories;

import com.greenjourneys.entities.Reservation;
import com.greenjourneys.generic.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IReservation extends BaseRepository<Reservation,Long> {
    public Reservation findFirstByDateDebutAfterAndChambresIdCHOrderByDateDebutAsc(LocalDate date,long idCh);
}
