package com.maxkucher.springinactiontutorial.services;


import com.maxkucher.springinactiontutorial.domains.Taco;
import com.maxkucher.springinactiontutorial.repositories.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TacoService {
    private final TacoRepository repository;

    public Flux<Taco> findAll()
    {
        return repository.findAll();
    }

    public Mono<Taco> findTacoById(Mono<Long> id)
    {
        return repository.findById(id);
    }

    public Mono<Taco> saveTaco(Mono<Taco> taco)
    {
        return repository.save(taco);
    }

}
