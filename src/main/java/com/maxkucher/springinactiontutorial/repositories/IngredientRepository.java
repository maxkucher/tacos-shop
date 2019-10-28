package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {


}
