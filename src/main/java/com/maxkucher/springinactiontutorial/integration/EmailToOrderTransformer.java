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
        extends AbstractMailMessageTransformer<OrderIntegrationDto> {


    @Override
    protected AbstractIntegrationMessageBuilder<OrderIntegrationDto> doTransform(javax.mail.Message message) throws Exception {
        OrderIntegrationDto order = processPayload(message);
        return MessageBuilder.withPayload(order);
    }

    // TODO: 10/25/2019 implement
    private OrderIntegrationDto processPayload(Message message) {
        throw new NotImplementedException();
    }
}
