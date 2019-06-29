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

    private Event event;

    private User user;

    public Comment(String content, String author) {
        this.content = content;
        this.author = author;

    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", dateAdded=" + dateAdded +
                ", event=" + event +
                '}';
    }
}
