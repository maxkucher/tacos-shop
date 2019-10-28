package com.maxkucher.springinactiontutorial.controllers;


import com.maxkucher.springinactiontutorial.domains.RegistrationForm;
import com.maxkucher.springinactiontutorial.domains.User;
import com.maxkucher.springinactiontutorial.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class RegistrationController {
    private final UsersService usersService;


    @PostMapping
    public Mono<ServerResponse> processRegistration(Mono<RegistrationForm> form) {
        Mono<User> userMono = usersService.saveUser(form);
        return ServerResponse.ok().build();
    }
}
