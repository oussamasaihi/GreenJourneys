package com.greenjourneys.repositories;

import com.greenjourneys.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IReclamation extends JpaRepository<Reclamation,Long> {
   @Query("select r from Reclamation r where r.etat=true ")
    List<Reclamation> reclamationsTraitees();
    @Query("select r from Reclamation r where r.etat=false")
    List<Reclamation> reclamationsNonTratitees();

    @Query("select r from Reclamation r where r.etat=?1")
    List<Reclamation> findReclamationByEtat(boolean etat);
}
