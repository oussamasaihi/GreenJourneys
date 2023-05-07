package com.greenjourneys.services;

import com.greenjourneys.entities.*;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IAccomodation;
import com.greenjourneys.repositories.IChambre;
import com.greenjourneys.repositories.IFile;
import com.greenjourneys.repositories.IReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
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
    private final IFile iFile;
    private final IChambre iChambre;

    @Autowired
    private ReservationService reservationService;

    @Override
    public Boolean VerifierDispoChambre(Accomodation accomodation, Long IdCh, LocalDate DateDebRes,LocalDate DateFinRes) {
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
            if (VerifierDispoChambre(accomodation, c.getIdCH(), DateDebRes,DateFinRes)) {
                ChambresVides.add(c);
            }
        }
        return ChambresVides;
    }

    @Override
    public Set<Accomodation> getAllDispoAcc(String ville,LocalDate DateDeb,LocalDate DateFin,List<TypeCh> t){
        Set<Accomodation> AccomodationsDispo=new HashSet<Accomodation>();
        for(Accomodation a:retrieveAll()) {
            if (a.getVille().equals(ville)) {
                if (verifierdiponibilitechambres(a.getIdAccomodation(),DateDeb,DateFin,t)!=null)
                    AccomodationsDispo.add(a);
            }
        }
        return AccomodationsDispo;
    }
    @Override
    public Set<Accomodation> retrieveAccoByType(TypeAccomodation typeAcc,String ville,LocalDate DateDeb,LocalDate DateFin,List<TypeCh> t) {
        return getAllDispoAcc(ville,DateDeb,DateFin,t)
                .stream()
                .filter(a -> a.getTypeAcc().equals(typeAcc))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Chambre> verifierdiponibilitechambres(Long ida, LocalDate DateDebRes, LocalDate DateFinRes, List<TypeCh> tychambres) {
        Accomodation a=iAccomodation.findById(ida).orElse(null);
        Set<Chambre> chambresvides;
        chambresvides=getAllChambresVides(a.getIdAccomodation(),DateDebRes,DateFinRes);
        Set<Chambre> chambresAreserver=new HashSet<Chambre>();
        int i=0;
        Chambre found=null;
        while(i<tychambres.size()){
            for(Chambre c:chambresvides){
                if(c.getTypech().equals(tychambres.get(i)))
                    found=c;
            }
            if(found!=null){
                i++;
                chambresAreserver.add(found);
                found=null;
            }
            else
                break;
        }
        if(chambresAreserver.size()==tychambres.size())
            return chambresAreserver;
        return null;
    }

}