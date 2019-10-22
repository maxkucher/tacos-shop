package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
