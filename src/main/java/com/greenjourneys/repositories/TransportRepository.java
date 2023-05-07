package com.greenjourneys.repositories;

import com.greenjourneys.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
    @Query("select t from Transport t where t.user.id_user = :id_user")
    public List<Transport> getTransportsByIdUser(@Param("id_user") Long idUser);

}
