package pl.sda.eventservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.enums.EventCategoryEnum;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByCategory(EventCategoryEnum category);
}
