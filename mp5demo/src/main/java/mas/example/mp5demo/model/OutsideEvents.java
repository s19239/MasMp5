package mas.example.mp5demo.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)

public class OutsideEvents extends Event {

    private String CompaniesName;
    private String description;

    @OneToMany(mappedBy = "event",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProgramEvent> programEvents=new HashSet<>();
/*
    @ElementCollection
    @CollectionTable(name = "outsideType",joinColumns = @JoinColumn(name = "outside_id"))
    @Builder.Default
    private Set<String> types=new HashSet<>();
*/
}
