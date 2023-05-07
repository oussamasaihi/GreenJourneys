package com.greenjourneys.repositories;

import com.greenjourneys.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroup extends JpaRepository<Group, Long> {
}
