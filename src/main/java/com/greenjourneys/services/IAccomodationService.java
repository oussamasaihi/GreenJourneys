package com.greenjourneys.services;

import com.greenjourneys.entities.*;
import com.greenjourneys.generic.IGenericService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAccomodationService extends IGenericService<Accomodation,Long> {
    public Boolean VerifierDispoChambre(Accomodation accomodation,Long IdCh, LocalDate DateDebRes,LocalDate DateFinRes);
    public Set<Chambre> getAllChambresVides(Long IdAcc, LocalDate DateDebRes,LocalDate DateFinRes);
    public Set<Accomodation> getAllDispoAcc(String ville,LocalDate DateDeb,LocalDate DateFin,List<TypeCh> t);
    public Set<Accomodation> retrieveAccoByType(TypeAccomodation typeAcc,String ville,LocalDate DateDeb,LocalDate DateFin,List<TypeCh> t);
    public Set<Chambre> verifierdiponibilitechambres(Long ida,LocalDate DateDebRes,LocalDate DateFinRes,List<TypeCh> tychambres);
}
