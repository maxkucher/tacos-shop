package com.maxkucher.springinactiontutorial.controllers;


import com.maxkucher.springinactiontutorial.domains.Order;
import com.maxkucher.springinactiontutorial.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/orders", produces = "application/json")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrdersRepository ordersRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order)
    {
        return ordersRepository
                .save(order);
    }


}
