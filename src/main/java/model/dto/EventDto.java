package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.enums.EventTypeEnum;
import entity.enums.SportEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("sport")
    private SportEnum sport;
    @JsonProperty("event_type")
    private EventTypeEnum eventType;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("date_from")
    private String dateFrom;
    @JsonProperty("date_to")
    private String dateTo;
    @JsonProperty("event_from")
    private String eventFrom;
    @JsonProperty("event_to")
    private String eventTo;

}
