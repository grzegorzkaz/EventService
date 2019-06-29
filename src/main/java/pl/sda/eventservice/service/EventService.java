package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.model.Comment;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.enums.EventCategoryEnum;
import pl.sda.eventservice.repository.CommentRepository;
import pl.sda.eventservice.repository.EventRepository;

import java.sql.Date;
import java.util.List;

@Service
public class EventService {

    EventRepository eventRepository;
    CommentRepository commentRepository;

    @Autowired
    public EventService(EventRepository eventRepository, CommentRepository commentRepository){
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    public void saveEvent(EventDto eventDto) {

        Event event = new Event(eventDto.getEventName(),
                eventDto.getLocation(),
                eventDto.getCategory(),
                eventDto.getDescription(),
                eventDto.getEventDateStart(),
                eventDto.getEventDateEnd());


                // zapis do bazy danych
                System.out.println(event);
        eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getAllPostsByCategory(EventCategoryEnum category) {
        return eventRepository.findAllByCategory(category);
    }

    public void addCommentToEvent(CommentDto commentDto){
        Comment comment = new Comment(commentDto.getContent(), commentDto.getAuthor());
        commentRepository.save(comment);
    }
}
