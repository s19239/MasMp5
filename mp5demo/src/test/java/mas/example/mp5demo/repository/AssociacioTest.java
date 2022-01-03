package mas.example.mp5demo.repository;

import mas.example.mp5demo.model.Organiser;
import mas.example.mp5demo.model.OutsideEvents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AssociacioTest {
    @Autowired
    private OrganiserRep organiserRep;
    @Autowired
    private OutsideERepository outsideERepository;

    @PersistenceContext
    private EntityManager entityManager;

    Organiser o1;
    OutsideEvents e1;

    @Test
    public void testRequiredDependencies(){
        assertNotNull(organiserRep);
        assertNotNull(outsideERepository);
    }
    @BeforeEach
    public void initdata(){
o1=Organiser.builder().name("Alina").surname("Baimur").depname("It").salary(4000).build();
e1=OutsideEvents.builder().name("Google confirance").budget(500).CompaniesName("Google").description("confirence for managers and programmers").build();

    }
   @Test
    public void testSave(){
        o1.getEvents().add(e1);
        organiserRep.save(o1);
        e1.setOrg(o1);
        outsideERepository.save(e1);

        Optional<Organiser> arg=organiserRep.findById(o1.getId());
        assertTrue(arg.isPresent());
        System.out.println(arg.get().getEvents());
        assertEquals(1,arg.get().getEvents().size());
    }

}
