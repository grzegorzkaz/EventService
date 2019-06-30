package pl.sda.eventservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.eventservice.model.Comment;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findFirstByContentAndUser(String content, User user);
}
