package endpoint;

import api.PersonApi;
import entity.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mapper.PersonMapper;
import model.dto.PersonDto;
import model.dto.PersonGetListResponseDto;
import service.PersonService;

import java.util.List;

@Transactional
public class PersonApiImpl implements PersonApi {

    @Inject
    PersonService personService;

    @Inject
    PersonMapper personMapper;

    @Override
    public PersonGetListResponseDto getPeople() {
        List<Person> allPerson = personService.getAllPerson();
        return personMapper.toDto(allPerson);
    }

    @Override
    public PersonDto getPersonFetched(Long id) {
        return new PersonDto();
    }

    @Override
    public void createPerson(PersonDto person) {
        personService.createOrUpdatePerson(null, person);
    }

    @Override
    public void updatePerson(Long id, PersonDto person) {
        personService.createOrUpdatePerson(id, person);
    }

    @Override
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }
}
