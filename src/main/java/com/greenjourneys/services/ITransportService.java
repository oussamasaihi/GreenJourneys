package com.greenjourneys.services;

import com.greenjourneys.entities.Transport;
import com.greenjourneys.generic.IGenericService;
import org.springframework.stereotype.Service;

@Service
public interface ITransportService extends IGenericService<Transport, Integer> {
}
