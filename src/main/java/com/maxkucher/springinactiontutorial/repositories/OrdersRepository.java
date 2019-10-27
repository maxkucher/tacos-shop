package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends ReactiveCrudRepository<Order, UUID> {
}
