package com.greenjourneys.services;

import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.repositories.IReclamation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class ReclamationService implements IReclamationService{

    @Autowired
    IReclamation iReclamation ;

    @Override
    public Reclamation saveReclamation(Reclamation reclamation) {return iReclamation.save(reclamation);}

    @Override
    public List<Reclamation> saveReclamations(List<Reclamation> listReclamations) {return iReclamation.saveAll(listReclamations);}

    @Override
    public Reclamation updateReclamation(Reclamation reclamation, Long id) {return iReclamation.save(reclamation);}

    @Override
    public List<Reclamation> updateReclamations(List<Reclamation> listReclamations) {return iReclamation.saveAll(listReclamations);}

    @Override
    public void deleteReclamationById(Long id) {iReclamation.deleteById(id);}

    @Override
    public void deleteReclamation(Reclamation reclamation) {iReclamation.delete(reclamation);}

    @Override
    public Page<Reclamation> listeReclamations(Pageable pageable) {return iReclamation.findAll(pageable);}

    @Override
    public List<Reclamation> listeReclamationsNonTratitees() {return iReclamation.reclamationsNonTratitees();}

    @Override
    public List<Reclamation> listeReclamationsTratitees() {return iReclamation.reclamationsTraitees();}

    @Override
    public Reclamation traiterRec(Long id, Reclamation reclamation) {
        reclamation=this.iReclamation.findById(id).get();
        reclamation.setEtat(true);
        return reclamation;
    }

    @Override
    public Reclamation findReclamationById(Long id) {
        return iReclamation.findById(id).orElse(new Reclamation());
    }




}
