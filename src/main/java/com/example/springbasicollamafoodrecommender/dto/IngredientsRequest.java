package com.example.springbasicollamafoodrecommender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.List;

public class IngredientsRequest {
    @JsonProperty("data")
    private List<String> ingredients;

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
