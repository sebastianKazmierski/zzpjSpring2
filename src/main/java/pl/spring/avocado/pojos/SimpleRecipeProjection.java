package pl.spring.avocado.pojos;
import org.springframework.data.rest.core.config.Projection;
import pl.spring.avocado.models.Ingredient;
import pl.spring.avocado.models.Recipe;

import java.util.List;

@Projection(types = Recipe.class)
public interface SimpleRecipeProjection {
    Long getId();
    int getCookTime();
    String getDescription();
    int getPrepTime();
    int getServings();
}
