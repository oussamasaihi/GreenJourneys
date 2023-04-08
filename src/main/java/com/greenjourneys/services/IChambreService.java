package com.greenjourneys.services;

import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.IGenericService;

public interface IChambreService extends IGenericService<Chambre,Long> {
    public Long CalculPrixTotal(Long AncienPrix,Long IdCh,String Option,int nbEnfants);
}
