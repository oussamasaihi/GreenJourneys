package com.greenjourneys.repositories;

import com.greenjourneys.entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInterest extends JpaRepository<Interest,Long> {
}
