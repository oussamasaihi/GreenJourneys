package com.greenjourneys.services;

import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IChambre;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreService extends IGenericServiceImp<Chambre,Long> implements IChambreService {

    private IChambre chambrerepo;

    @Override
    public Long CalculPrixTotal(Long AncienPrix, Long IdCh, String Option, int nbEnfants) {
        Chambre chambre=chambrerepo.findById(IdCh).orElse(null);
        Long PrixTotal;
        if(Option.equals("Complet")){
            PrixTotal=AncienPrix+chambre.getPrixComplet()-(chambre.getReductionEnfant()*nbEnfants);
        }
        else{
            PrixTotal=AncienPrix+chambre.getPrixDemiPortion()-(chambre.getReductionEnfant()*nbEnfants);
        }
        return PrixTotal;
    }
}
