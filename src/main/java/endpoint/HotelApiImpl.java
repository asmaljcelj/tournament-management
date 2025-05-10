package endpoint;

import api.HotelApi;
import entity.Hotel;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mapper.HotelMapper;
import model.dto.HotelDto;
import model.dto.HotelListResponseDto;
import service.HotelService;

import java.util.List;

@Transactional
public class HotelApiImpl implements HotelApi {

    @Inject
    HotelService hotelService;

    @Inject
    HotelMapper hotelMapper;

    @Override
    public HotelListResponseDto getHotels() {
        List<Hotel> allHotels = hotelService.getAllHotels();
        return hotelMapper.toDto(allHotels);
    }

    @Override
    public HotelDto getHotelFetched(Long id) {
        return new HotelDto();
    }

    @Override
    public void createHotel(HotelDto hotel) {
        hotelService.createOrUpdateHotel(null, hotel);
    }

    @Override
    public void updateHotel(Long id, HotelDto hotel) {
        hotelService.createOrUpdateHotel(id, hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelService.deleteHotel(id);
    }
}
