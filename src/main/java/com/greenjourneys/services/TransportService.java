package com.greenjourneys.services;

import com.greenjourneys.entities.Transport;
import com.greenjourneys.repositories.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService implements ITransportService{

    @Autowired
    TransportRepository transportRepository;

    @Override
    public Transport add(Transport t) {
        return transportRepository.save(t);
    }

    @Override
    public Transport update(Transport t) {
        return transportRepository.save(t);
    }

    @Override
    public Transport retrieveById(Integer id) {
//        return eventRepository.findById(id).get();
        return transportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transport> retrieveAll() {
        return transportRepository.findAll();
    }

    @Override
    public Boolean delete(Integer id) {
        if (transportRepository.existsById(id)) {
            transportRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Transport> getTransportsByIdUser(Long idUser) {
        return transportRepository.getTransportsByIdUser(idUser);
    }
}
