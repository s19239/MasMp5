package mas.example.mp5demo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder

public abstract class Event {
    private String name;
    private int budget;

   @ManyToOne
   @JoinColumn(name = "organiser_id")
   @ToString.Exclude
   @EqualsAndHashCode.Exclude
    private Organiser org;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
