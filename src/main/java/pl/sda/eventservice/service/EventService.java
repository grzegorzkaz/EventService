package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.repository.EventRepository;

@Service
public class EventService {

    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
}
