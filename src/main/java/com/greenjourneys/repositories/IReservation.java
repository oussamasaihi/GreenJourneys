package com.greenjourneys.repositories;

import com.greenjourneys.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface IReservation extends JpaRepository<Reservation,Long> {
    public Reservation findFirstByDateDebutAfterAndChambresIdCHOrderByDateDebutAsc(LocalDate date,long idCh);
}
