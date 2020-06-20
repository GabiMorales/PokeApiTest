package com.gamorales.pokeapitest.controller;

import com.gamorales.pokeapitest.model.generated.AbilitiesItem;
import com.gamorales.pokeapitest.model.generated.Ability;
import com.gamorales.pokeapitest.model.generated.Pokemon;
import com.gamorales.pokeapitest.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PokemonController {

    @Autowired
    private PokemonApiService pokemonApiService;

    @GetMapping("/poke/{id}")
    public Pokemon getPokemonById(@PathVariable("id") int id){
        return pokemonApiService.getPokemonById(id);
    }

    @GetMapping("/poke/{id}/abilities")
    public List<Ability> getPokemonAbilitiesById(@PathVariable("id") int id){
        return pokemonApiService.getPokemonById(id)
                .getAbilities()
                .stream()
                .map(AbilitiesItem::getAbility)
                .collect(Collectors.toList());
    }
}
