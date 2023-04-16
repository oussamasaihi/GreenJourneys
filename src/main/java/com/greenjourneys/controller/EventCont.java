package com.greenjourneys.controller;

import com.greenjourneys.entities.Event;
import com.greenjourneys.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;

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

    @PostMapping(value = "/event/sendMail")
    @ResponseBody
    String sendMail(@RequestBody Event event, @RequestParam List<String> recipients) throws MessagingException {
        String from = "sender@example.com"; // replace with actual sender email address

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", "smtp.gmail.com"); // replace with your SMTP server host

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        for (String recipient : recipients) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }

        // Set Subject: header field
        message.setSubject("New event created: " + event.getNomEvent());

        // Now set the actual message
        message.setText("A new event has been created with the following details:\n\n" +
                "Name: " + event.getNomEvent() + "\n" +
                "Date: " + event.getDateDebutEvent() + "\n" +
                "Location: " + event.getRegionEvent() + "\n" +
                "Description: " + event.getDescriptionEvent() + "\n");

        // Send message
        Transport.send(message);

        return "Mail sent successfully!";
    }

}
