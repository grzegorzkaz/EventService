package pl.sda.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long commentId;

    private String content;
    private String author;
    private LocalDateTime dateAdded = LocalDateTime.now();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Comment comment;

    public Comment(String content, String author, Event event) {
        this.content = content;
        this.author = author;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", dateAdded=" + dateAdded +
                ", event=" + event.getEventId() +
                '}';
    }
}
