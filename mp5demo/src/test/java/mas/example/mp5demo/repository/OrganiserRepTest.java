package mas.example.mp5demo.repository;

import mas.example.mp5demo.model.Organiser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class OrganiserRepTest {
    @Autowired
    private OrganiserRep organiserRep;
   @PersistenceContext
    private EntityManager entityManager;
    Organiser o1;
    @BeforeEach
    public void initData(){
        o1=Organiser.builder().name("Aziza").surname("Baimur").depname("HR").salary(150).build();
    }
   @Test
    public void testRequiredDependencies(){
assertNotNull(organiserRep);
    }
   @Test
    public void testFetchOrganiser(){
      Iterable<Organiser> all= organiserRep.findAll();
      for(Organiser o : organiserRep.findAll()){
          System.out.println(o);
      }
   }

   @Test
   public void testSaveOrganiser(){
organiserRep.save(o1);
entityManager.flush();
long count =organiserRep.count();
assertEquals(3,count);
    }
   @Test
    public void testInvalidOrganiser(){
        assertThrows(ConstraintViolationException.class,() ->{
            o1.setSalary(50);
            organiserRep.save(o1);
            entityManager.flush();
        });

    }

    @Test
    public void testFindByName(){
      List<Organiser> res= organiserRep.findByName("Aliia");
      assertEquals(1,res.size());

    }

    @Test
    public void testFindByNameAnddep(){
        List<Organiser> res= organiserRep.findByNameAndDepname("Aliia","Finance");
        assertEquals(1,res.size());

    }

    @Test
    public void testFindBySalGreaterthan(){
        List<Organiser> res= organiserRep.findBySalaryGreaterthan(1000);
        assertEquals(2,res.size());

    }
}