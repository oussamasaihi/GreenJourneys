package com.greenjourneys.services;

import com.greenjourneys.entities.Event;
import com.greenjourneys.generic.IGenericService;
import org.springframework.stereotype.Service;

@Service
public interface IEventService extends IGenericService<Event, Long> {

    void sendMail(String to, String subject, String text);
}
