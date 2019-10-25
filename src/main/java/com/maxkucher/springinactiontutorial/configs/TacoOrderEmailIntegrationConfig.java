package com.maxkucher.springinactiontutorial.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Configuration
public class TacoOrderEmailIntegrationConfig {
    @Bean
    public IntegrationFlow tacoEmailIntegrationFlow(
            EmailProperties properties,
            EmailToOrderTransformer emailToOrderTransformer,
            OrderSubmitMessageHandler orderSubmitMessageHandler
    )
    {
        return IntegrationFlows
                .from(Mail.imapInboundAdapter(properties.getImapUrl()),
                        e -> e.poller(properties.getPollRate()))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitMessageHandler)
                .get();
    }
}
