package pl.sda.eventservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.eventservice.model.enums.EventCategoryEnum;
import pl.sda.eventservice.model.enums.EventLocationEnum;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String eventName;
    private EventLocationEnum location;
    private EventCategoryEnum category;
    private String description;
    private String eventDateStart;
    private String eventDateEnd;

    public Event(String eventName, EventLocationEnum location, EventCategoryEnum category,
                 String description,String eventDateStart,String eventDateEnd) {
        this.eventName = eventName;
        this.location = location;
        this.category = category;
        this.description = description;
        this.eventDateStart = eventDateStart;
        this.eventDateEnd = eventDateEnd;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "event")
    private List<Comment> comments;

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

}
