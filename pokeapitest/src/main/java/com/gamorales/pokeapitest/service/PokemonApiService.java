package com.gamorales.pokeapitest.service;

import com.gamorales.pokeapitest.model.generated.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonApiService {

    @Value("${pokeapi.url}")
    private String pokeapiUrl;

    public Pokemon getPokemonById(int id){
        RestTemplate template = new RestTemplate();
        ResponseEntity<Pokemon> pokemonResponseEntity = template.exchange(pokeapiUrl+ id, HttpMethod.GET, null, Pokemon.class);
        return pokemonResponseEntity.getBody();
    }
}
