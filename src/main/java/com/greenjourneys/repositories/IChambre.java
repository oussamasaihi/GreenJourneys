package com.greenjourneys.repositories;

import com.greenjourneys.entities.Chambre;
import com.greenjourneys.generic.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChambre extends BaseRepository<Chambre,Long> {
}
