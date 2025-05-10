package service;

import entity.Hotel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.dto.HotelDto;
import repository.HotelRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class HotelService {

    @Inject
    HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.getAll();
    }

    public void createOrUpdateHotel(Long id, HotelDto hotel) {
        Hotel hotelEntity = new Hotel();
        if (id != null) {
            hotelEntity = hotelRepository.findById(id);
        }
        hotelEntity.setName(hotel.getName());
        hotelRepository.persist(hotelEntity);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

}
