package pl.spring.avocado.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spring.avocado.models.Recipe;
import pl.spring.avocado.pojos.SimpleRecipeProjection;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
//    Optional<SimpleRecipeProjection> getById(Long id);
}
