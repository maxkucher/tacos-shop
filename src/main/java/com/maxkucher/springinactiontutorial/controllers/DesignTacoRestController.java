package com.maxkucher.springinactiontutorial.controllers;

import com.maxkucher.springinactiontutorial.domains.Taco;
import com.maxkucher.springinactiontutorial.services.TacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/***
 *  produces = "application/json" property
 *  tells that this controller should
 *  be invoked when "Accept" header includes "application/json"
 * */
@Configuration
@RequiredArgsConstructor
public class DesignTacoRestController {
    private final TacoService tacoService;

    @Bean
    public RouterFunction<?> routerFunction()
    {
        return route(GET("/design/taco"),this::recents)
                .andRoute(POST("/design"),this::postTaco);
    }



    public Mono<ServerResponse> recents(ServerRequest request)
    {
        return ServerResponse.ok()
                .body(tacoService.findAll().take(12),Taco.class);
    }

    public Mono<ServerResponse> postTaco(ServerRequest request) {
        Mono<Taco> taco = request.bodyToMono(Taco.class);
        Mono<Taco> savedTaco = tacoService.saveTaco(taco);
        return ServerResponse.created(URI.create(
                "http://localhost:8080/design/taco/"+savedTaco.getId()))
                .body(savedTaco,Taco.class);
    }



}
