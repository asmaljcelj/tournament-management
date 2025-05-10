package mapper;

import entity.Hotel;
import model.dto.HotelDto;
import model.dto.HotelListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface HotelMapper {

    HotelDto toDto(Hotel hotel);

    default HotelListResponseDto toDto(List<Hotel> people) {
        HotelListResponseDto dto = new HotelListResponseDto();
        List<HotelDto> peopleDto = people.stream().map(this::toDto).collect(Collectors.toList());
        dto.setHotels(peopleDto);
        return dto;
    }

}
