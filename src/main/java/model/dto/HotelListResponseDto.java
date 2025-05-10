package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelListResponseDto {

    @JsonProperty("hotels")
    private List<HotelDto> hotels;

}
