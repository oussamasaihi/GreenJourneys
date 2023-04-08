package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.Reservation;
import com.greenjourneys.entities.TypeAccomodation;
import com.greenjourneys.generic.IGenericService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAccomodationService extends IGenericService<Accomodation,Long> {
    public Boolean VerifierDispoChambre(Long IdAcc,Long IdCh, LocalDate DateDebRes,LocalDate DateFinRes);
    public Set<Chambre> getAllChambresVides(Long IdAcc, LocalDate DateDebRes,LocalDate DateFinRes);
    public Set<Accomodation> getAllDispoAcc(String ville,LocalDate DateDeb,LocalDate DateFin,int nbpersonnes,int nbChambres);
    public int capaciteChambres(Set<Chambre> chambres);
    public Set<Accomodation> retrieveAccoByType(TypeAccomodation typeAcc,String ville,LocalDate DateDeb,LocalDate DateFin,int nbpersonnes,int nbChambres);
}
