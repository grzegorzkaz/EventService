package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.service.EventService;
import javax.validation.Valid;
import java.util.Arrays;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.controller.dto.UserDto;
import javax.validation.Valid;


@RestController
public class EventController {

    EventService eventService;


    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/addEvent")
    public void addEvent(@ModelAttribute("event") @Valid EventDto eventDto){
        eventService.saveEvent(eventDto);
    }

    @PostMapping("addComment")
    public void addComment(@ModelAttribute("user") @Valid CommentDto commentDto){
        eventService.addCommentToEvent(commentDto);
    }
}
