package mas.example.mp5demo;

import lombok.RequiredArgsConstructor;
import mas.example.mp5demo.model.Organiser;
import mas.example.mp5demo.repository.OrganiserRep;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final OrganiserRep rep;


    @EventListener
    public void atStart(ContextRefreshedEvent e){
        System.out.println("refreshed");
Iterable<Organiser>all=rep.findAll();
System.out.println(all);
    }
}
