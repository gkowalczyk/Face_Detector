package com.example.faceappdetector.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImgBBClient {

    @Value("${img.api.key}")
    private String imgBbApiKey;

    public Mono<String> uploadToImgBB(Path imagePath, String name) {
        return Mono.fromCallable(() -> {

                    byte[] fileContent = Files.readAllBytes(imagePath);
                    return Base64.getEncoder().encodeToString(fileContent);
                })
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(encodedImage -> {
                    WebClient webClient = WebClient.create("https://api.imgbb.com");
                    return webClient.post()
                            .uri(uriBuilder -> uriBuilder
                                    .path("/1/upload")
                                    .queryParam("key", imgBbApiKey)
                                    .queryParam("name", name)
                                    .queryParam("expiration", 60)
                                    .build())
                            .body(BodyInserters.fromFormData("image", encodedImage))
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .retrieve()
                            .bodyToMono(JsonNode.class)
                            .map(jsonNode -> jsonNode.path("data").path("url").asText());
                });
    }
}

