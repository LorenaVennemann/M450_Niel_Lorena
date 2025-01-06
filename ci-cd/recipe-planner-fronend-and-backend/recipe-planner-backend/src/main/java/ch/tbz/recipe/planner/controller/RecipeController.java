package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin(origins = {"http://localhost:3000"})
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping("/api/recipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        List<Recipe> recipes = service.getRecipes();
        if (recipes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/api/recipes/recipe/{recipeId}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable UUID recipeId) {
        Recipe recipe = service.getRecipeById(recipeId);
        if (recipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping(value = "/api/recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe addedRecipe = service.addRecipe(recipe);
        return new ResponseEntity<>(addedRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/api/recipes/recipe/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable UUID recipeId, @RequestBody Recipe recipe) {
        Recipe updatedRecipe = service.updateRecipe(recipeId, recipe);
        if (updatedRecipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }
}
