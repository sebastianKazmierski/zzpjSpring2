package pl.spring.avocado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String description;
    @ManyToOne()
    @JsonIgnore
    private Recipe recipe;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UnitOfMeasure uom;
}
