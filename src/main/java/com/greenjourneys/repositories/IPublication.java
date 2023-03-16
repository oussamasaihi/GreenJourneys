package com.greenjourneys.repositories;

import com.greenjourneys.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublication extends JpaRepository<Publication,Long> {
}
