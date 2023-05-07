package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.TypeCh;
import com.greenjourneys.generic.IGenericService;

import java.util.HashMap;
import java.util.List;

public interface IChambreService extends IGenericService<Chambre,Long> {
    public Long CalculPrixTotal(Long AncienPrix,Long IdCh,String Option,int nbEnfants);
    public Long PrixChambresTotale(List<Chambre> chs,List<Integer> nbchilds, String Option);
    public Chambre AssignChambreToAcco(Long IdCh, Long IdAcc);

}
