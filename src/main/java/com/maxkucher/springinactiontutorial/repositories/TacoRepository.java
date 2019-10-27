package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Taco;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TacoRepository extends ReactiveCassandraRepository<Taco, UUID> {
}
