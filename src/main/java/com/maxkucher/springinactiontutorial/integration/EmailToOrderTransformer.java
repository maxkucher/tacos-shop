package com.maxkucher.springinactiontutorial.integration;

import com.maxkucher.springinactiontutorial.domains.Order;
import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.mail.Message;

@Component
public class EmailToOrderTransformer
extends AbstractMailMessageTransformer<Order> {


    @Override
    protected AbstractIntegrationMessageBuilder<Order> doTransform(javax.mail.Message message) throws Exception {
        Order order = processPayload(message);
        return MessageBuilder.withPayload(order);
    }

    // TODO: 10/25/2019 implement
    private Order processPayload(Message message) {
        throw new NotImplementedException();
    }
}
