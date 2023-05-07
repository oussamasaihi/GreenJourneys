package com.greenjourneys.repositories;

import com.greenjourneys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUser extends JpaRepository<User,Long> {
    @Query(value = "SELECT u FROM User u WHERE u.nom = ?1 AND u.id_User = ?2")
    User findUserByNameAndId(String name, Long id);
    @Query (value = "SELECT u FROM User u WHERE u.id_User = ?1")
    User findUserById(Long id);
}
