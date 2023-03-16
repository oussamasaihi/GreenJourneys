package com.greenjourneys.repositories;

import com.greenjourneys.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComment extends JpaRepository<Comment,Long> {
}
