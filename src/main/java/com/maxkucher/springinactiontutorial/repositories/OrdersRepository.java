package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Order;

public interface OrdersRepository {
    Order save(Order order);
}
