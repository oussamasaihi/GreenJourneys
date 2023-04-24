package com.greenjourneys.controller;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.TypeAccomodation;
import com.greenjourneys.entities.TypeCh;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.AccomodationService;
import com.greenjourneys.services.IAccomodationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accomodation")
@RequiredArgsConstructor
public class AccomodationCont extends GenericController<Accomodation,Long> {
    private final IAccomodationService iAccomodationService;

    @GetMapping("/chambresvides/{IdAcc}/{DateDebRes}/{DateFinRes}")
    Set<Chambre> getAllChambresVides(@PathVariable Long IdAcc, @PathVariable LocalDate DateDebRes, @PathVariable LocalDate DateFinRes) {
        return iAccomodationService.getAllChambresVides(IdAcc, DateDebRes, DateFinRes);
    }

    @GetMapping("/DispoAccomodations/{ville}/{DateDeb}/{DateFin}")
    public Set<Accomodation> getAllDispoAcc(@PathVariable String ville, @PathVariable LocalDate DateDeb, @PathVariable LocalDate DateFin, @RequestBody List<TypeCh> typeschambres) {
        return iAccomodationService.getAllDispoAcc(ville, DateDeb, DateFin, typeschambres);
    }

    @GetMapping("/HotelsDisponibles/{typeAcc}/{ville}/{DateDeb}/{DateFin}/{nbpersonnes}")
    public Set<Accomodation> retrieveAccoByType(@PathVariable TypeAccomodation typeAcc, @PathVariable String ville, @PathVariable LocalDate DateDeb, @PathVariable LocalDate DateFin, @RequestBody List<TypeCh> typesChambres) {
        return iAccomodationService.retrieveAccoByType(typeAcc, ville, DateDeb, DateFin, typesChambres);
    }
    @GetMapping("/aaa/{IdAcc}")
    public Set<Chambre> getchambres(@PathVariable Long IdAcc){
        return iAccomodationService.getchambres(IdAcc);
    }
}
