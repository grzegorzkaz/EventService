package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.enums.EventCategoryEnum;
import pl.sda.eventservice.model.enums.EventLocationEnum;
import pl.sda.eventservice.service.EventService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
public class EventController {

    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String getAllPosts(Model model, Authentication auth) {

        model.addAttribute("auth", auth);

        //List<Event> posts = EventService.getAllEvents();
        //model.addAttribute("posts", posts);

        return "index";
    }


    @GetMapping("/addEvent")
    public String addPost(Model model, Authentication auth){

        model.addAttribute("auth", auth);
        model.addAttribute("post", new EventDto());
        model.addAttribute("categories", Arrays.asList(EventCategoryEnum.values()));
        model.addAttribute("locations", Arrays.asList(EventLocationEnum.values()));

        return "addEvent";
    }


    @PostMapping("/addEvent")
    public String addPost(@ModelAttribute("post") @Valid EventDto eventDto,
                          BindingResult bindingResult,
                          Authentication auth,
                          Model model){

        if(bindingResult.hasErrors()){

            model.addAttribute("auth", auth);
            model.addAttribute("categories", Arrays.asList(EventCategoryEnum.values()));

            return "addEvent";
        }

        String email = ((UserDetails)auth.getPrincipal()).getUsername();

        //eventService.saveEvent(eventDto, email);
        return "redirect:/";
    }

//    @PostMapping("/addEvent")
//    public void addEvent(@ModelAttribute("event") @Valid EventDto eventDto, Long eventOrganiserId) {
//        eventService.saveEvent(eventDto, eventOrganiserId);
//    }

    @PostMapping("/addMember/{event_id}")
    public void addMember(@PathVariable Long event_id, Long user_id){
        eventService.addMember(event_id, user_id);
    }
}
