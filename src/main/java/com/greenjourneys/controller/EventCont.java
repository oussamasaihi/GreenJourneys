package com.greenjourneys.controller;

import com.greenjourneys.entities.Event;
import com.greenjourneys.entities.Transport;
import com.greenjourneys.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventCont {

    @Autowired
    IEventService eventService;

    @GetMapping(value = "/event/getAll")
    @ResponseBody
    List<Event> getAll() {
        return eventService.retrieveAll();
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
}
