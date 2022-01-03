package mas.example.mp5demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_id","program_id"})
})
public class ProgramEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="event_id",nullable = false)
    @NotNull
    private OutsideEvents event;

    @ManyToOne
    @JoinColumn(name="program_id",nullable = false)
    @NotNull
    private Program program;

    @NotNull
    private LocalDate start;

    @NotNull
    private LocalDate end;

    private String description;

}
