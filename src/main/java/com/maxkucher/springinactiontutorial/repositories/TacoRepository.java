package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TacoRepository extends ReactiveCrudRepository<Taco, String> {
}
