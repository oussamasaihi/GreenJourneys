package com.greenjourneys.services;

import com.greenjourneys.entities.Reservation;
import com.greenjourneys.generic.IGenericService;
import com.greenjourneys.generic.IGenericServiceImp;

import java.time.LocalDate;

public interface IReservationService extends IGenericService<Reservation,Long> {
    public Reservation getProcheRes(LocalDate dateDeb,Long idCh);
    public int CalculerPeriodeRes(Long idR);
}
