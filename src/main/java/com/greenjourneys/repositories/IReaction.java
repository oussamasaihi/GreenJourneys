package com.greenjourneys.repositories;

import com.greenjourneys.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReaction extends JpaRepository<Reaction,Long> {
}
