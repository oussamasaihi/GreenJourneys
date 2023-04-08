package com.greenjourneys.services;

import com.greenjourneys.entities.Event;
import com.greenjourneys.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event add(Event e) {
        return eventRepository.save(e);
    }

    @Override
    public Event update(Event e) {
        return eventRepository.save(e);
    }

    @Override
    public Event retrieveById(Long id) {
//        return eventRepository.findById(id).get();
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> retrieveAll() {
        return eventRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
