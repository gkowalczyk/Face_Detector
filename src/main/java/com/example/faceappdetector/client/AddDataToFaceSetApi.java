package com.example.faceappdetector.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddDataToFaceSetApi {
    @Value("${azure.face.add.url}")
    private String addFaceUrl;
    @Value("${azure.face.plus.app.key}")
    private String facePlusAppKey;
    @Value("${azure.face.plus.app.secret}")
    private String facePlusAppSecret;
    @Value("${azure.faceSet.plus.app.key}")
    private String faceSetAppPlusKey;

    private final WebClient webClient;

    public Mono<String> addFaceToFaceSet(String faceToken) {
        return webClient.post()
                .uri(addFaceUrl)
                .body(BodyInserters
                        .fromFormData("api_key", facePlusAppKey)
                        .with("api_secret", facePlusAppSecret)
                        .with("face_tokens", faceToken)
                        .with("faceset_token", faceSetAppPlusKey))
                .retrieve()
                .bodyToMono(String.class);
    }
}
