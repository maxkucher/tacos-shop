package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
