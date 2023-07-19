package com.greenjourneys.controllers;

import com.greenjourneys.entities.Reservation;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReservationCont extends GenericController<Reservation,Long> {
    private final IReservationService iReservationService;
    @PutMapping("/periode/{idR}")
    public int CalculerPeriodeRes(@PathVariable Long idR) {
        return iReservationService.CalculerPeriodeRes(idR);
    }
}
