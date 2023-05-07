package com.greenjourneys.repositories;

import com.greenjourneys.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IChambre extends JpaRepository<Chambre,Long> {
}
