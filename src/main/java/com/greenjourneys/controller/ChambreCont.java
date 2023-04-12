package com.greenjourneys.controller;

import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ChambreService;
import com.greenjourneys.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Chambre")
@RequiredArgsConstructor
public class ChambreCont extends GenericController<Chambre,Long> {
    private final IChambreService iChambreService;
    @GetMapping("{AncienPrix}/{IdCh}/{Option}/{nbEnfants}")
    public Long CalculPrixTotal(@PathVariable Long AncienPrix,@PathVariable Long IdCh,@PathVariable String Option,@PathVariable int nbEnfants) {
        return iChambreService.CalculPrixTotal(AncienPrix,IdCh,Option,nbEnfants);
    }
}
