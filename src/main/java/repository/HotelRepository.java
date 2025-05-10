package repository;

import entity.Hotel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class HotelRepository implements PanacheRepository<Hotel> {

    public List<Hotel> getAll() {
        return findAll().list();
    }

}
