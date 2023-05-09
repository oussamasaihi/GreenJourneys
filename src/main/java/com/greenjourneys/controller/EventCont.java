package com.greenjourneys.controller;

import com.greenjourneys.entities.Event;
import com.greenjourneys.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping({"/api/event"})
@CrossOrigin(origins = "*")
public class EventCont {

    @Autowired
    IEventService eventService;

    @GetMapping(value = "/event/getAll")
    @ResponseBody
    List<Event> getAll() {
        return eventService.retrieveAll();
    }

    @GetMapping(value = "/event/getNewEvent/{id_user}")
    @ResponseBody
    List<Event> getNewEvent(@PathVariable("id_user") Integer idUser) {
        return eventService.getNewEventFor(idUser);
    }

    @GetMapping(value = "/event/getById/{id}")
    @ResponseBody
    Event getById(@PathVariable("id") Long id) {
        return eventService.retrieveById(id);
    }

    @PostMapping(value = "/event/add")
    @ResponseBody
    Event add(@RequestBody Event event) {
        return eventService.add(event);
    }

    @PutMapping(value = "/event/update")
    @ResponseBody
    Event update(@RequestBody Event event) {
        return eventService.update(event);
    }

    @DeleteMapping(value = "/event/delete/{id}")
    @ResponseBody
    Boolean delete(@PathVariable("id") Long id) {
        return eventService.delete(id);
    }

    @PostMapping(value = "/event/sendMail/{id_event}")
    @ResponseBody
    String sendMail(@RequestBody List<String> recipients, @PathVariable("id_event") Long idEvent) {
        Event event = eventService.retrieveById(idEvent);
        String text = "A new event has been created with the following details:\n\n" +
                "Name: " + event.getNomEvent() + "\n" +
                "Date: " + event.getDateDebutEvent() + "\n" +
                "Location: " + event.getRegionEvent() + "\n" +
                "Description: " + event.getDescriptionEvent() + "\n";
        String subject = "New Event";
        for (String to: recipients) {
            eventService.sendMail(to, subject, text);
        }
        return "Mail sent successfully!";
    }

}
