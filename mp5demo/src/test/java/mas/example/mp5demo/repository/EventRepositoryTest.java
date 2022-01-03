package mas.example.mp5demo.repository;

import mas.example.mp5demo.model.CorporateEvents;
import mas.example.mp5demo.model.OutsideEvents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EventRepositoryTest {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OutsideERepository outsideERepository;
    @Autowired
    private CorporateRepository corporateRepository;

OutsideEvents o1,o2;
CorporateEvents c1;

@PersistenceContext
private EntityManager entityManager;
@BeforeEach
public void initData(){
    o1=OutsideEvents.builder().name("Google confirance").budget(500).CompaniesName("Google").description("confirence for managers and programmers").build();
    o2=OutsideEvents.builder().name("Amazon").budget(700).CompaniesName("Amazon").description("confirence for managers").build();
    c1=CorporateEvents.builder().name("Milestone").budget(20000).numberOfPeole(80).build();


}
    @Test
    public void testDependencies(){
    assertNotNull(eventRepository);
    assertNotNull(outsideERepository);
    assertNotNull(corporateRepository);
    }

    @Test
    public void testsaveall(){
    outsideERepository.saveAll(Arrays.asList(o1,o2));
    corporateRepository.save(c1);
    entityManager.flush();
    assertEquals(3,eventRepository.count());
    }
}