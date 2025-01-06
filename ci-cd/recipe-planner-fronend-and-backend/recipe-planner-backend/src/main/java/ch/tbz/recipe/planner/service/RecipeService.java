package ch.tbz.recipe.planner.service;

import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.repository.RecipeRepository;
import ch.tbz.recipe.planner.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final RecipeEntityMapper mapper;
    private final RecipeRepository repository;

    public RecipeService(RecipeEntityMapper mapper, RecipeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<Recipe> getRecipes() {
        List<RecipeEntity> recipeEntities = repository.findAll();
        return recipeEntities.stream().map(mapper::entityToDomain).toList();
    }

    public Recipe getRecipeById(UUID recipeId) {
        return mapper.entityToDomain(repository.findById(recipeId).orElse(null));
    }

    public Recipe addRecipe(Recipe recipe) {
        RecipeEntity createdRecipe = repository.save(mapper.domainToEntity(recipe));
        return mapper.entityToDomain(createdRecipe);
    }

    public Recipe updateRecipe(UUID recipeId, Recipe recipe) {
        RecipeEntity existingRecipeEntity = repository.findById(recipeId).orElse(null);
        if (existingRecipeEntity == null) {
            return null; // Recipe not found
        }
        // Updates
        existingRecipeEntity.setName(recipe.getName());
        existingRecipeEntity.setDescription(recipe.getDescription());
        existingRecipeEntity.setImageUrl(recipe.getImageUrl());

        // Speichern des aktualisierten Rezeptes
        RecipeEntity updatedRecipeEntity = repository.save(existingRecipeEntity);
        return mapper.entityToDomain(updatedRecipeEntity); // Rückgabe des aktualisierten Rezeptes
    }
}
