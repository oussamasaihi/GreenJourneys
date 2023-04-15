package com.greenjourneys.services;

import com.greenjourneys.entities.Event;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IEvent;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EventService extends IGenericServiceImp<Event, Long> implements IEventService {
    private IEvent iEvent;

    public EventService() {
    }
}