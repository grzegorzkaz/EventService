package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.model.Comment;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.repository.CommentRepository;
import pl.sda.eventservice.repository.EventRepository;

@Service
public class EventService {

    EventRepository eventRepository;
    CommentRepository commentRepository;

    @Autowired
    public EventService(EventRepository eventRepository, CommentRepository commentRepository){
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    public void addCommentToEvent(CommentDto commentDto){
        Comment comment = new Comment(commentDto.getContent(), commentDto.getAuthor());
        commentRepository.save(comment);
    }


}
