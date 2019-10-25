package com.maxkucher.springinactiontutorial.integration;

import com.maxkucher.springinactiontutorial.domains.Taco;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderIntegrationDto {
    private final String email;
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
