package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.TypeCh;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IAccomodation;
import com.greenjourneys.repositories.IChambre;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChambreService extends IGenericServiceImp<Chambre,Long> implements IChambreService {
    private final IChambre chambrerepo;
    private final IAccomodation iAccomodation;

    @Override
    public Long CalculPrixTotal(Long AncienPrix, Long IdCh, String Option, int nbEnfants) {
        Chambre chambre = chambrerepo.findById(IdCh).orElse(null);
        Long PrixTotal;
        if (Option.equals("Complet")) {
            PrixTotal = AncienPrix + chambre.getPrixComplet() - (chambre.getReductionEnfant() * nbEnfants);
        } else {
            PrixTotal = AncienPrix + chambre.getPrixDemiPortion() - (chambre.getReductionEnfant() * nbEnfants);
        }
        return PrixTotal;
    }

    @Override
    public Long PrixChambresTotale(HashMap<Chambre, Integer> m, String Option) {
        long PrixTotal = 0;
        for (Chambre c : m.keySet()) {
            if (Option.equals("Complet")) {
                PrixTotal = PrixTotal + c.getPrixComplet() - (c.getReductionEnfant() * m.get(c));
            } else {
                PrixTotal = PrixTotal + c.getPrixDemiPortion() - (c.getReductionEnfant() * m.get(c));
            }
        }
        return PrixTotal;
    }
    @Override
    public Chambre AssignChambreToAcco(Long IdCh, Long IdAcc) {
        Chambre c=chambrerepo.findById(IdCh).orElse(null);
        Assert.notNull(c, "chambre not found");
        Accomodation a=iAccomodation.findById(IdAcc).orElse(null);
        Assert.notNull(a,"accomodation not found");
        c.setAccommodation(a);
        return chambrerepo.save(c);
    }

}
