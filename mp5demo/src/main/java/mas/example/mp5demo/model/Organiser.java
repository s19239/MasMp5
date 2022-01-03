package mas.example.mp5demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Builder
@ToString
public class Organiser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory ")
    @Size(min = 2,max = 50)
    private String name;
    @NotBlank(message = "Surname is mandatory ")
    @Size(min = 2,max = 50)
    private String surname;
    @NotBlank(message = "Department Name is mandatory ")
    @Size(min = 2,max = 50)
    private String depname;

    @Min(100)
    private double salary;

  @OneToMany(mappedBy = "org",fetch = FetchType.LAZY)
   @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Event>events=new HashSet<>();

public Organiser(){}
}
