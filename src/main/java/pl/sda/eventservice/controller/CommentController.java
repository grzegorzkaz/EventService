package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventservice.controller.dto.CommentDto;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.service.CommentService;
import pl.sda.eventservice.service.UserService;

@RestController
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment/{event_id}")
    public void addComment(@PathVariable("event_id") Long event_id, Long user_id, CommentDto commentDto){
        commentService.addComment(event_id, user_id, commentDto);
    }
}
