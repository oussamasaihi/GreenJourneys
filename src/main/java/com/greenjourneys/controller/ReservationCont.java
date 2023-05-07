package com.greenjourneys.controller;

import com.greenjourneys.entities.Reservation;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.repositories.IReservation;
import com.greenjourneys.services.IReservationService;
import com.greenjourneys.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ReservationCont extends GenericController<Reservation,Long> {
    private final IReservationService iReservationService;
    @PutMapping("/periode/{idR}")
    public int CalculerPeriodeRes(@PathVariable Long idR) {
        return iReservationService.CalculerPeriodeRes(idR);
    }
}
