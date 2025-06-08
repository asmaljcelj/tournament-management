package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

}
