package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String zip);

    List<Order> readOrderByZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);
}
