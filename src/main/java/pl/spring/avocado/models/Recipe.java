package pl.spring.avocado.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cookTime;
    private String description;
    @Lob
    private String directions;
    private int prepTime;
    private int servings;
    @OneToMany(mappedBy = "recipe")
    Set<Ingredient> ingredients = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> category = new HashSet<>();
}
