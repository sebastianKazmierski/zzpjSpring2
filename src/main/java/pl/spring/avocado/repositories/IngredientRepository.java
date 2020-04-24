package pl.spring.avocado.repositories;

import org.hibernate.graph.InvalidGraphException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spring.avocado.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
