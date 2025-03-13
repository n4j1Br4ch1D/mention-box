package com.anmoon.mentionbox.service;

import com.anmoon.mentionbox.entity.ItemEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmbeddingService {
    private final WebClient webClient = WebClient.create("http://localhost:8000");


    public List<Double> getEmbedding(String text) {
        Map<String, Object> response = webClient.post()
                .uri("/embed/")
                .bodyValue(Map.of("text", text))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Double> test = (List<Double>) response.get("embedding");
        log.info("===>test:{}", test);
        return test;
    }



}
