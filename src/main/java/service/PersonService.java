package service;

import entity.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.dto.PersonDto;
import repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PersonService
{

    @Inject
    PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.getAll();
    }

    public void createOrUpdatePerson(Long id, PersonDto person) {
        Person personEntity = new Person();
        if (id != null) {
            personEntity = personRepository.findById(id);
        }
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setEmail(person.getEmail());
        personEntity.setGender(person.getGender());
        personEntity.setBirthday(person.getBirthday() != null ? LocalDate.parse(person.getBirthday()) : LocalDate.now());
        personEntity.setEmail(person.getEmail());
        personEntity.setUserId(UUID.randomUUID().toString());
        personEntity.setExternalId(person.getExternalId());
        personRepository.persist(personEntity);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
