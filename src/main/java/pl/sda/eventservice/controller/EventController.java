package pl.sda.eventservice.controller;

import io.swagger.models.Model;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.service.EventService;
import javax.validation.Valid;

import pl.sda.eventservice.controller.dto.CommentDto;

import java.util.Arrays;


@Controller
public class EventController {

    EventService eventService;


    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/addEvent")
    public String addEvent(Model model, Authentication auth) {

//        model.addAttribute("auth", auth);
//        model.addAttribute("post", new PostDto());
//        model.addAttribute("categories", Arrays.asList(CategoryEnum.values()));

        return "addEvent";
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
