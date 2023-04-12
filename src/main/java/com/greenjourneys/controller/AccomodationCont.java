package com.greenjourneys.controller;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.TypeAccomodation;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.AccomodationService;
import com.greenjourneys.services.IAccomodationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/accomodation")
@RequiredArgsConstructor
public class AccomodationCont extends GenericController<Accomodation,Long>{
    private final IAccomodationService iAccomodationService;

    @GetMapping("/chambresvides/{IdAcc}/{DateDebRes}/{DateFinRes}")
    Set<Chambre> getAllChambresVides(@PathVariable Long IdAcc,@PathVariable LocalDate DateDebRes,@PathVariable LocalDate DateFinRes) {
        return iAccomodationService.getAllChambresVides(IdAcc, DateDebRes, DateFinRes);
    }

    @GetMapping("/DispoAccomodations/{ville}/{DateDeb}/{DateFin}/{nbpersonnes}/{nbchambres}")
    public Set<Accomodation> getAllDispoAcc(@PathVariable String ville,@PathVariable LocalDate DateDeb,@PathVariable LocalDate DateFin,@PathVariable int nbpersonnes,@PathVariable int nbChambres) {
        return iAccomodationService.getAllDispoAcc(ville, DateDeb, DateFin, nbpersonnes, nbChambres);
    }

    @GetMapping("/HotelsDisponibles/{typeAcc}/{ville}/{DateDeb}/{DateFin}/{nbpersonnes}/{nbChambres}")
    public Set<Accomodation> retrieveAccoByType(@PathVariable TypeAccomodation typeAcc,@PathVariable String ville,@PathVariable LocalDate DateDeb,@PathVariable LocalDate DateFin,@PathVariable int nbpersonnes,@PathVariable int nbChambres) {
        return iAccomodationService.retrieveAccoByType(typeAcc,ville,DateDeb,DateFin,nbpersonnes,nbChambres);
    }
}
