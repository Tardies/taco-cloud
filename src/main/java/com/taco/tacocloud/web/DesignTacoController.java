package com.taco.tacocloud.web;

import com.taco.tacocloud.Ingredient;
import com.taco.tacocloud.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.taco.tacocloud.Ingredient;
import com.taco.tacocloud.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String ShowDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", Type.WRAP),
                new Ingredient("COTO", "kukurydzianna", Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina", Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojonne w kostkę", Type.VEGGIES),
                new Ingredient("LETC", "sałata", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Type.SAUCE));
        Type[] types = Type.values();
        Arrays.stream(types).forEach(a -> model.addAttribute(a.toString().toLowerCase(Locale.ROOT), ingredients.stream().filter(i -> a.equals(i.getType())).collect(Collectors.toList())));
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Design design) {
        //nope
        log.info("Przetwarzanie projektu taco: " + design);
        return "redirect:/orders/current";
    }
}
