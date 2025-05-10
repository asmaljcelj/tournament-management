package mapper;

import entity.Event;
import entity.Person;
import model.dto.EventDto;
import model.dto.EventListResponseDto;
import model.dto.PersonDto;
import model.dto.PersonGetListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = {DateMapper.class})
public interface EventMapper {

    EventDto toDto(Event event);

    default EventListResponseDto toDto(List<Event> events) {
        EventListResponseDto dto = new EventListResponseDto();
        List<EventDto> peopleDto = events.stream().map(this::toDto).collect(Collectors.toList());
        dto.setEvents(peopleDto);
        return dto;
    }

}
