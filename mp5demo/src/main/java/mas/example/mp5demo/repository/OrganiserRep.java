package mas.example.mp5demo.repository;

import mas.example.mp5demo.model.Organiser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrganiserRep extends CrudRepository<Organiser,Long> {

    public List<Organiser> findByName(String name);
    public List<Organiser> findByNameAndDepname(String name,String depname);

    @Query("from Organiser as o where o.salary >:minsal")
    public List<Organiser> findBySalaryGreaterthan(@Param("minsal") double a);

    @Query("from Organiser as o left join fetch o.events where o.id=:id ")
    public Optional<Organiser> findById(@Param("id") Long id);
}
