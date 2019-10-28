package com.maxkucher.springinactiontutorial.services;


import com.maxkucher.springinactiontutorial.domains.RegistrationForm;
import com.maxkucher.springinactiontutorial.domains.User;
import com.maxkucher.springinactiontutorial.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public Mono<User> saveUser(Mono<RegistrationForm> form) {
        return userRepository.saveAll(form.map(f -> f.toUser(encoder))).next();
    }
}
