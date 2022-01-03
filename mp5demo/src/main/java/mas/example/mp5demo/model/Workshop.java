package mas.example.mp5demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workshop {

     @ManyToOne(optional = false)
     @JoinColumn(name="pro_id",nullable = false,updatable = false)
    private Program prograg;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String Description;
    private boolean isMandatory;


}
