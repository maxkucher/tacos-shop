package com.maxkucher.springinactiontutorial.controllers;

import com.maxkucher.springinactiontutorial.domains.Taco;
import com.maxkucher.springinactiontutorial.repositories.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/***
 *  produces = "application/json" property
 *  tells that this controller should
 *  be invoked when "Accept" header includes "application/json"
 * */
@RestController
@RequestMapping(value = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DesignTacoRestController {
    private final TacoRepository tacoRepo;


    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable Long id) {
        Optional<Taco> optionalTaco = tacoRepo.findById(id);
        return optionalTaco.orElse(null);
    }




}
