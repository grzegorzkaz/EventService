package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.controller.dto.EventDto;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.Event;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.repository.EventRepository;

import java.sql.Date;

@Service
public class EventService {

    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
}
