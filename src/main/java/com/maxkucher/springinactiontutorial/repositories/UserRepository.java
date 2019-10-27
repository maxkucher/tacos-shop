package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
