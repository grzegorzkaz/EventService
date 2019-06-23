package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventservice.service.EventService;

@RestController
public class EventController {

    EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
}
