package com.greenjourneys.repositories;

import com.greenjourneys.entities.Interest;
import com.greenjourneys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInterest extends JpaRepository<Interest,Long> {
    @Query("select u from User u where :interest MEMBER OF u.interest")
    List<User> getUsersByInterest(@Param("interest") Interest interest);
}
