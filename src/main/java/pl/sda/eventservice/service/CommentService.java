package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.model.Comment;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.repository.CommentRepository;
import pl.sda.eventservice.repository.EventRepository;
import pl.sda.eventservice.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CommentService {

    UserRepository userRepository;
    EventRepository eventRepository;
    CommentRepository commentRepository;

    @Autowired
    public CommentService(EventRepository eventRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public void saveComment(CommentDto commentDto, Event event, User user) {

        Comment comment = new Comment(commentDto.getContent(), event, user);

        // zapis do bazy danych
        commentRepository.save(comment);
    }

    public Comment addComment(Long event_id, Long user_id, CommentDto commentDto) {
        Event event = eventRepository.getOne(event_id);
        User user = userRepository.getOne(user_id);
        Comment comment = new Comment(commentDto.getContent(), event, user);
        event.addComment(comment);

        return commentRepository.save(comment);
    }
}