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
    private LocalDateTime dateAdded = LocalDateTime.now();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)

    @JoinColumn(name = "event_id")

    private Event event;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
            @JoinColumn(name = "user_id")
    private User user;

    public Comment(String content, Event event, User user) {
        this.content = content;
        this.event = event;
        this.user = user;
    }
}
