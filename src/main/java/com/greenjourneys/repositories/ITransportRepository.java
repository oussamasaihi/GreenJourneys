package com.greenjourneys.repositories;

import com.greenjourneys.entities.Event;
import com.greenjourneys.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransportRepository extends JpaRepository<Transport, Integer> {
}
