package com.greenjourneys.services;

import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.repositories.IReclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReclamationService  {
        List <Reclamation> getReclamations();
        Reclamation saveReclamation(Reclamation reclamation);
        Reclamation updateReclamation(Reclamation reclamation, Long id);
        void deleteReclamationById(Long id);

        List<Reclamation> listeReclamationsNonTratitees();
        List<Reclamation> listeReclamationsTratitees();
        Reclamation traiterRec(Long id, Reclamation reclamation);
        Reclamation findReclamationById(Long id);

}
