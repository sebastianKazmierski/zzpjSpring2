package pl.spring.avocado;

import org.springframework.web.bind.annotation.*;
import pl.spring.avocado.models.Ingredient;
import pl.spring.avocado.models.Recipe;

import java.util.Set;

@RestController
public class Controller {
    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable("id") long id) {
        return service.getRecipe(id);
    }

    @DeleteMapping("/recipe{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        service.deleteRecipe(id);
    }

    @GetMapping("/ingredients{id}")
    public Set<Ingredient> getIngredientsForRecipe(@PathVariable("id") Long id) {
        return service.getListOfIngredients(id);
    }

    @GetMapping("/ingredient")
    public Ingredient getIngredientForRecipe(@RequestParam Long ingredientId, @RequestParam Long recipeId) {
        return service.getIngredientFromRecipe(ingredientId, recipeId);
    }

    @DeleteMapping("/ingredient")
    public void deleteIngredientForRecipe(@RequestParam Long ingredientId, @RequestParam Long recipeId) {
        service.removeIngredientFromRecipe(ingredientId,recipeId);
    }

    @PostMapping("/ingredient")
    public Ingredient addIngredient(@RequestParam Long recipeId, @RequestBody Ingredient ingredient) {
        return service.addIngredientToRecipe(ingredient,recipeId);
    }
}
