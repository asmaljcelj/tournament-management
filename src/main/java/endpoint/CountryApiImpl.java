package endpoint;

import api.CountryApi;
import entity.Country;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mapper.CountryMapper;
import model.dto.CountryDto;
import model.dto.CountryGetListResponseDto;
import service.CountryService;

import java.util.List;

@Transactional
public class CountryApiImpl implements CountryApi {

    @Inject
    CountryService countryService;

    @Inject
    CountryMapper countryMapper;

    @Override
    public CountryGetListResponseDto getCountries() {
        List<Country> countries = countryService.getAllCountries();
        return countryMapper.toDto(countries);
    }

    @Override
    public CountryDto getCountryFetched(Long id) {
        return new CountryDto();
    }

    @Override
    public void createCountry(CountryDto country) {
        countryService.createOrUpdatePerson(null, country);
    }

    @Override
    public void updateCountry(Long id, CountryDto country) {
        countryService.createOrUpdatePerson(id, country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryService.deleteCountry(id);
    }
}
