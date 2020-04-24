package pl.spring.avocado;

import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.avocado.models.Ingredient;
import pl.spring.avocado.models.Recipe;
import pl.spring.avocado.pojos.SimpleRecipeProjection;
import pl.spring.avocado.repositories.CategoryRepository;
import pl.spring.avocado.repositories.IngredientRepository;
import pl.spring.avocado.repositories.RecipeRepository;
import pl.spring.avocado.repositories.UnitOfMeasureRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class Service {
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public Service(CategoryRepository categoryRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public Recipe getRecipe(Long id) {
//        Optional<SimpleRecipeProjection> simpleRecipeProjectionOptional = recipeRepository.getById(id);
//        return simpleRecipeProjectionOptional.orElseThrow();
        return recipeRepository.findById(id).orElse(null);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Set<Ingredient> getListOfIngredients(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElseThrow().getIngredients();
    }

    public Ingredient getIngredientFromRecipe(Long ingredientId, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        Set<Ingredient> ingredients = recipe.getIngredients();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId().equals(ingredientId)) {
                return ingredient;
            }
        }
        throw new IllegalArgumentException("There is not ingredient with id: " + ingredientId);
    }

    public void removeIngredientFromRecipe(Long ingredientId, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        Set<Ingredient> ingredients = recipe.getIngredients();
        ingredients.removeIf(ingredient -> ingredient.getId().equals(ingredientId));
        recipeRepository.save(recipe);
    }

    public Ingredient addIngredientToRecipe(Ingredient ingredient, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        Set<Ingredient> ingredients = recipe.getIngredients();
        ingredients.add(ingredient);
        recipeRepository.save(recipe);
        return ingredient;
    }
}
