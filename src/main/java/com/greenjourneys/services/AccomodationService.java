package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.Reservation;
import com.greenjourneys.entities.TypeAccomodation;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IAccomodation;
import com.greenjourneys.repositories.IChambre;
import com.greenjourneys.repositories.IReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccomodationService extends IGenericServiceImp<Accomodation,Long> implements IAccomodationService {

    private final IAccomodation iAccomodation;
    private final IChambre iChambre;
    @Autowired
    private ReservationService reservationService;

    @Override
    public Boolean VerifierDispoChambre(Long IdAcc, Long IdCh, LocalDate DateDebRes,LocalDate DateFinRes) {
        Accomodation accomodation = iAccomodation.findById(IdAcc).orElse(null);
        Chambre chambre = iChambre.findById(IdCh).orElse(null);
        for (Reservation r : accomodation.getReservations()) {
            if (r.getChambres().contains(chambre)) {
                if (DateDebRes.isAfter(r.getDateDebut().minusDays(1)) && DateDebRes.isBefore(r.getDateFin().plusDays(1))) {
                    return false;
                }
            }
        }
        Reservation r1 = reservationService.getProcheRes(DateDebRes, IdCh);
        if (r1 != null) {
            Period period = Period.between(DateDebRes, r1.getDateDebut());
            int days = period.getDays();
            if (days < Period.between(DateDebRes, DateFinRes).getDays())
                return false;
        }
        return true;
    }

    @Override
    public Set<Chambre> getAllChambresVides(Long IdAcc, LocalDate DateDebRes,LocalDate DateFinRes) {
        Accomodation accomodation=iAccomodation.findById(IdAcc).orElse(null);
        Set<Chambre> ChambresVides = new HashSet<Chambre>();
        for (Chambre c : accomodation.getChambres()) {
            if (VerifierDispoChambre(IdAcc, c.getIdCH(), DateDebRes,DateFinRes)) {
                ChambresVides.add(c);
            }
        }
        return ChambresVides;
    }
    @Override
    public int capaciteChambres(Set<Chambre> chambres) {
        int  capacite=0;
        for(Chambre c:chambres){
            capacite+=c.getCapacite();
        }
        return capacite;
    }

    @Override
    public Set<Accomodation> getAllDispoAcc(String ville,LocalDate DateDeb,LocalDate DateFin,int nbpersonnes,int nbChambres){
        Set<Accomodation> AccomodationsDispo=new HashSet<Accomodation>();
        Set<Chambre> chambresvides;
        for(Accomodation a:retrieveAll()) {
            if (a.getVille().equals(ville)) {
                chambresvides = getAllChambresVides(a.getIdAccomodation(),DateDeb,DateFin);
                if ((chambresvides.size() >= nbChambres)&&(capaciteChambres(chambresvides)>=nbpersonnes))
                    AccomodationsDispo.add(a);
            }
        }
        return AccomodationsDispo;
    }
    @Override
    public Set<Accomodation> retrieveAccoByType(TypeAccomodation typeAcc,String ville,LocalDate DateDeb,LocalDate DateFin,int nbpersonnes,int nbChambres) {
        return getAllDispoAcc(ville,DateDeb,DateFin,nbpersonnes,nbChambres)
                .stream()
                .filter(a -> a.getTypeAcc().equals(typeAcc))
                .collect(Collectors.toSet());
    }

    }