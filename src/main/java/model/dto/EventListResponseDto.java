package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventListResponseDto {

    @JsonProperty("events")
    private List<EventDto> events;

}
