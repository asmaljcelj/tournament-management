package mapper;

import entity.Country;
import entity.Person;
import model.dto.CountryDto;
import model.dto.CountryGetListResponseDto;
import model.dto.PersonDto;
import model.dto.PersonGetListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CountryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "abbreviation", target = "abbreviation")
    CountryDto toDto(Country country);

    default CountryGetListResponseDto toDto(List<Country> people) {
        CountryGetListResponseDto dto = new CountryGetListResponseDto();
        List<CountryDto> peopleDto = people.stream().map(this::toDto).collect(Collectors.toList());
        dto.setCountries(peopleDto);
        return dto;
    }

}
