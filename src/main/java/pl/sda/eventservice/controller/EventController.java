package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.service.EventService;

import javax.validation.Valid;

@RestController
public class EventController {

    EventService eventService;


    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("addComment")
    public void addComment(@ModelAttribute("user") @Valid CommentDto commentDto){
        eventService.addCommentToEvent(commentDto);
    }
}
