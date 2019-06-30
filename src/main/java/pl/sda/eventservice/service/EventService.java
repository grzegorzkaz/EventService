package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.repository.CommentRepository;
import pl.sda.eventservice.repository.EventRepository;
import pl.sda.eventservice.repository.UserRepository;

import java.util.List;

@Service
public class EventService {
    UserRepository userRepository;
    EventRepository eventRepository;
    CommentRepository commentRepository;

    @Autowired
    public EventService(EventRepository eventRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public void saveEvent(EventDto eventDto, Long eventOrganiserId) {

        Event event = new Event(eventOrganiserId,
                eventDto.getEventName(),
                eventDto.getLocation(),
                eventDto.getCategory(),
                eventDto.getDescription(),
                eventDto.getEventDateStart(),
                eventDto.getEventDateEnd());


        // zapis do bazy danych
        System.out.println(event);
        eventRepository.save(event);
    }

//    public static List<Event> getAllEvents() {
//        return eventRepository.findAll();
//    }


    public void addMember(Long event_id, Long user_id) {
        Event event = eventRepository.getOne(event_id);
        event.addMember(userRepository.getOne(user_id));
        eventRepository.save(event);
    }


}
