package com.maxkucher.springinactiontutorial.repositories;

import com.maxkucher.springinactiontutorial.domains.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrdersRepository implements OrdersRepository {
    private final JdbcTemplate jdbc;


    @Autowired
    public JdbcOrdersRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}
