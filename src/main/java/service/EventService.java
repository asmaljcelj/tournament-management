package service;

import entity.Event;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.dto.EventDto;
import repository.EventRepository;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class EventService {
    
    @Inject
    EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.getAll();
    }

    public void createOrUpdateEvent(Long id, EventDto event) {
        Event eventEntity = new Event();
        if (id != null) {
            eventEntity = eventRepository.findById(id);
        }
        eventEntity.setName(event.getName());
        eventEntity.setEventId(event.getEventId());
        eventEntity.setSport(event.getSport());
        eventEntity.setYear(event.getYear());
        eventEntity.setEventType(event.getEventType());
        eventEntity.setDateFrom(LocalDate.parse(event.getDateFrom()));
        eventEntity.setDateTo(LocalDate.parse(event.getDateTo()));
        eventEntity.setEventFrom(LocalDate.parse(event.getEventFrom()));
        eventEntity.setEventTo(LocalDate.parse(event.getEventTo()));
        eventRepository.persist(eventEntity);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    
}
