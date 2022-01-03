package mas.example.mp5demo.repository;

import mas.example.mp5demo.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Long> {
}
