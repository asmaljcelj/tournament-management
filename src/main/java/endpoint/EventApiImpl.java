package endpoint;

import api.EventApi;
import entity.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mapper.EventMapper;
import model.dto.EventDto;
import model.dto.EventListResponseDto;
import service.EventService;

import java.util.List;

@Transactional
public class EventApiImpl implements EventApi {

    @Inject
    EventService eventService;

    @Inject
    EventMapper eventMapper;

    @Override
    public EventListResponseDto getEvents() {
        List<Event> allEvents = eventService.getAllEvents();
        return eventMapper.toDto(allEvents);
    }

    @Override
    public void createPerson(EventDto event) {
        eventService.createOrUpdateEvent(null, event);
    }

    @Override
    public void updatePerson(Long id, EventDto event) {
        eventService.createOrUpdateEvent(id, event);
    }

    @Override
    public void deletePerson(Long id) {
        eventService.deleteEvent(id);
    }
}
