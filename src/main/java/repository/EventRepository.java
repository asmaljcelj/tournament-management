package repository;

import entity.Event;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {

    public List<Event> getAll() {
        return findAll().list();
    }

}
