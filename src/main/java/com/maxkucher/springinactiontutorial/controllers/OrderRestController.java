package com.maxkucher.springinactiontutorial.controllers;


import com.maxkucher.springinactiontutorial.domains.Order;
import com.maxkucher.springinactiontutorial.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/orders", produces = "application/json")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrdersRepository ordersRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Order> createOrder(@RequestBody Mono<Order> order) {
        return ordersRepository
                .saveAll(order).next();
    }

    @PutMapping
    public Mono<Order> putOrder(@RequestBody Order order) {
        return ordersRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id, HttpServletResponse response) {
        try {
            ordersRepository.deleteById(id);
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } catch (EmptyResultDataAccessException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

    }


}
