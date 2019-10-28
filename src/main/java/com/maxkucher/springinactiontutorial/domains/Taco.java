package com.maxkucher.springinactiontutorial.domains;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Taco {

    @Id
    private String id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Must be at least 5 chars long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

}
