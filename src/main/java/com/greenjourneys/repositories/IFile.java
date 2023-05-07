package com.greenjourneys.repositories;

import com.greenjourneys.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFile extends JpaRepository<File,Long> {
}
