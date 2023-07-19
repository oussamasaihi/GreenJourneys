package com.greenjourneys.controllers;

import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Chambre")
@RequiredArgsConstructor
public class ChambreCont extends GenericController<Chambre,Long> {

    private final IChambreService iChambreService;
    @CrossOrigin(origins = "*")
    @GetMapping("{AncienPrix}/{IdCh}/{Option}/{nbEnfants}")
    public Long CalculPrixTotal(@PathVariable Long AncienPrix,@PathVariable Long IdCh,@PathVariable String Option,@PathVariable int nbEnfants) {
        return iChambreService.CalculPrixTotal(AncienPrix,IdCh,Option,nbEnfants);
    }
    @PutMapping("/{IdCh}/{IdAcc}")
    public Chambre AssignChambreToAcco(@PathVariable Long IdCh, @PathVariable Long IdAcc) {
        return iChambreService.AssignChambreToAcco(IdCh, IdAcc);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/prix/{nbchilds}/{Option}")
    public Long PrixChambresTotale(@RequestBody List<Chambre> chs,@PathVariable List<Integer> nbchilds,@PathVariable String Option) {
        return iChambreService.PrixChambresTotale(chs,nbchilds,Option);
    }
}
