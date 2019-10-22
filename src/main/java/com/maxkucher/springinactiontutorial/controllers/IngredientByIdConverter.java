package com.maxkucher.springinactiontutorial.controllers;


import com.maxkucher.springinactiontutorial.domains.Ingredient;
import com.maxkucher.springinactiontutorial.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository repository;


    @Autowired
    public IngredientByIdConverter(IngredientRepository repository) {
        this.repository = repository;
    }


    @Override
    public Ingredient convert(String s) {
        return repository.findById(s).get();
    }
}
