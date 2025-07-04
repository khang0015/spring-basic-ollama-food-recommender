package com.example.springbasicollamafoodrecommender.controller;

import com.example.springbasicollamafoodrecommender.dto.IngredientsRequest;
import com.example.springbasicollamafoodrecommender.service.ollamaservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecommendController {
    private final ollamaservice ollama;

    public RecommendController(ollamaservice ollama) {
        this.ollama = ollama;
    }

    @PostMapping("/recommend")
    public Map<String, List<String>> recommend(@RequestBody Map<String, List<String>> body) {
        List<String> ingredients = body.get("ingredients");
        List<String> result = ollama.recommendRecipe(ingredients);
        return Map.of("result", result);
    };
}
