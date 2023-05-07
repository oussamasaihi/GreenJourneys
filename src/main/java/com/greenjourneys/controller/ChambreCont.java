package com.greenjourneys.controller;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.ChambreService;
import com.greenjourneys.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Chambre")
@RequiredArgsConstructor
public class ChambreCont extends GenericController<Chambre,Long> {

    private final IChambreService iChambreService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{AncienPrix}/{IdCh}/{Option}/{nbEnfants}")
    public Long CalculPrixTotal(@PathVariable Long AncienPrix,@PathVariable Long IdCh,@PathVariable String Option,@PathVariable int nbEnfants) {
        return iChambreService.CalculPrixTotal(AncienPrix,IdCh,Option,nbEnfants);
    }
    @PutMapping("/{IdCh}/{IdAcc}")
    public Chambre AssignChambreToAcco(@PathVariable Long IdCh, @PathVariable Long IdAcc) {
        return iChambreService.AssignChambreToAcco(IdCh, IdAcc);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/prix/{nbchilds}/{Option}")
    public Long PrixChambresTotale(@RequestBody List<Chambre> chs,@PathVariable List<Integer> nbchilds,@PathVariable String Option) {
        return iChambreService.PrixChambresTotale(chs,nbchilds,Option);
    }
}
