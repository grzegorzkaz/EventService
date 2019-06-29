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
    public void addEvent(@ModelAttribute("event") @Valid EventDto eventDto) {
        eventService.saveEvent(eventDto);
    }

//    @PostMapping("/addComment")
//    public void addComment(@ModelAttribute("user") @Valid CommentDto commentDto) {
//        eventService.addCommentToEvent(commentDto);
//    }

    @PostMapping("/addMember/{event_id}")
    public void addMember(@PathVariable Long event_id, Long user_id){
        eventService.addMember(event_id, user_id);
    }

    @PostMapping("/addComment/{event_id}")
    public void addComment(@PathVariable("event_id") Long event_id, String content, String author){
        eventService.addComment(event_id, content, author);
    }
}
