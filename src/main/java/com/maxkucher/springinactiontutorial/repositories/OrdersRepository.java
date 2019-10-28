package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrdersRepository extends ReactiveCrudRepository<Order, String> {
}
