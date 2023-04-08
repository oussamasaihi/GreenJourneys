package com.greenjourneys.services;

import com.greenjourneys.entities.Reservation;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService extends IGenericServiceImp<Reservation,Long> implements IReservationService{
    private final IReservation iReservation;

    @Override
    public Reservation getProcheRes(LocalDate DateDeb,Long IdCh) {
        return iReservation.findFirstByDateDebutAfterAndChambresIdCHOrderByDateDebutAsc(DateDeb,IdCh);
    }
}
