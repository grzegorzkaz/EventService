package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.service.EventService;

import javax.validation.Valid;


@RestController
public class EventController {

    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/addEvent")
    public void addEvent(@ModelAttribute("event") @Valid EventDto eventDto, Long eventOrganiserId) {
        eventService.saveEvent(eventDto, eventOrganiserId);
    }

    @PostMapping("/addMember/{event_id}")
    public void addMember(@PathVariable Long event_id, Long user_id){
        eventService.addMember(event_id, user_id);
    }
}
