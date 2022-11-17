package com.taco.tacocloud;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "Nazwa musi skladać się przynajmniej z 5 znaków.")
    private String name;
    @Size(min = 1, message = "Musisz wybrać przynajmniej jeden składnik.")
    private List<String> ingredients;
}
