package com.maxkucher.springinactiontutorial.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxkucher.springinactiontutorial.domains.Order;
import com.maxkucher.springinactiontutorial.domains.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrdersRepository implements OrdersRepository {
    private final SimpleJdbcInsert orderInserter;
    private final SimpleJdbcInsert orderTacoInserter;
    private final ObjectMapper objectMapper;


    @Autowired
    public JdbcOrdersRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();

    }

    @Override
    public Order save(Order order) {
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos) {
            saveTacoToOrder(orderId, taco);
        }
        return order;
    }

    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values =
                objectMapper.convertValue(order, Map.class);

        values.put("placedAt", order.getPlacedAt());
        return orderInserter
                .executeAndReturnKey(values)
                .longValue();
    }

    private void saveTacoToOrder(long orderId, Taco taco) {
        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());
        orderTacoInserter.execute(values);
    }
}
