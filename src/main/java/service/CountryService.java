package service;

import entity.Country;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.dto.CountryDto;
import repository.CountryRepository;

import java.util.List;

@ApplicationScoped
public class CountryService {

    @Inject
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.getAll();
    }

    public void createOrUpdatePerson(Long id, CountryDto country) {
        Country countryEntity = new Country();
        if (id != null) {
            countryEntity = countryRepository.findById(id);
        }
        countryEntity.setAbbreviation(country.getAbbreviation());
        countryEntity.setName(country.getAbbreviation());
        countryRepository.persist(countryEntity);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

}
