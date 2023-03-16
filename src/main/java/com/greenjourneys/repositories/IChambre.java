package com.greenjourneys.repositories;

import com.greenjourneys.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChambre extends JpaRepository<Chambre,Long> {
        }
