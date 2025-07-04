package com.example.springbasicollamafoodrecommender.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ollamaservice {

    private final RestTemplate restTemplate;

    public ollamaservice(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<String> recommendRecipe(List<String> ingredients) {
        String userPrompt = String.format(
                "Here is a list of ingredients: %s.\n" +
                "Suggest a few creative recipe name ideas. Only respond with recipe names, one per line.",
                ingredients
        );

        Map<String, Object> request = Map.of(
                "model", "llama3",
                "prompt", userPrompt,
                "stream", false
        );

        String url = "http://localhost:11434/api/generate";

        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> body = response.getBody();

        if (body != null && body.containsKey("response")) {
            String responseString = (String) body.get("response");
            List<String> result = Arrays.asList(responseString.split("\n"));
            return result;
        }

        return List.of("No response");
    };

}
