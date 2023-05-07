package com.greenjourneys.services;

import com.greenjourneys.entities.Transport;
import com.greenjourneys.generic.IGenericService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransportService extends IGenericService<Transport, Integer> {
    public List<Transport> getTransportsByIdUser(Long idUser);

    }
