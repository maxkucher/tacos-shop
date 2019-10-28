package com.maxkucher.springinactiontutorial.controllers;


import com.maxkucher.springinactiontutorial.domains.Ingredient;
import com.maxkucher.springinactiontutorial.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class IngredientByIdConverter implements Converter<String, Mono<Ingredient>> {
    private final IngredientRepository repository;


    @Autowired
    public IngredientByIdConverter(IngredientRepository repository) {
        this.repository = repository;
    }


    @Override
    public Mono<Ingredient> convert(String s) {
        return repository.findById(s);
    }
}
