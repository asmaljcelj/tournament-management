package mapper;

import entity.Person;
import model.dto.PersonDto;
import model.dto.PersonGetListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = {DateMapper.class})
public interface PersonMapper {

    @Mapping(source = "country.name", target = "country")
    PersonDto toDto(Person person);


    default PersonGetListResponseDto toDto(List<Person> people) {
        PersonGetListResponseDto dto = new PersonGetListResponseDto();
        List<PersonDto> peopleDto = people.stream().map(this::toDto).collect(Collectors.toList());
        dto.setPersons(peopleDto);
        return dto;
    }

}
