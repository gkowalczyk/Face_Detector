package com.example.faceappdetector.client;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.response.FaceApiMatchResponse;
import com.example.faceappdetector.response.FacePlusApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatusCode;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FacePlusApiClient implements FaceClientInterface {

    @Value("${azure.face.plus.api.url}")
    private String facePlusApiUrl;
    @Value("${azure.face.plus.api.find.url}")
    private  String facePlusApiFindUrl;
    @Value("${azure.face.plus.app.key}")
    private String facePlusAppKey;
    @Value("${azure.face.plus.app.secret}")
    private String facePlusAppSecret;
    @Value("${azure.faceSet.plus.app.key}")
    private String faceSetAppPlusKey;

    private final WebClient webClient;

    public Mono<List<FaceObject>> getFaceByUrl(String url) {
        return webClient.post()
                .uri(facePlusApiUrl)
                .body(BodyInserters
                        .fromFormData("api_key", facePlusAppKey)
                        .with("api_secret", facePlusAppSecret)
                        .with("image_url", url)
                        .with("return_attributes", "gender,emotion,beauty,skinstatus"))
                .retrieve()
                .bodyToMono(FacePlusApiResponse.class)
                .map(FacePlusApiResponse::getFaces)
                .onErrorResume(e -> {
                    log.error("Error: {}", e.getMessage());
                    return Mono.just(Collections.emptyList());
                });
    }

    public Mono<FaceApiMatchResponse> getSimilarFaces(String url) {
             return webClient.post()
                .uri(facePlusApiFindUrl)

                .body(BodyInserters
                        .fromFormData("api_key", facePlusAppKey)
                        .with("api_secret", facePlusAppSecret)
                        .with("image_url", url)
                        .with("faceset_token", faceSetAppPlusKey)
                        .with("return_result_count", "3"))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class).flatMap(error -> {
                            log.error("Error response from Face++ API: {}", error);
                            return Mono.error(new RuntimeException("Error from Face++ API: " + error));
                        }))
                .bodyToMono(FaceApiMatchResponse.class)
                .onErrorResume(e -> {
                    log.error("Exception: {}", e.getMessage());
                    return Mono.error(new RuntimeException("Error face: " + e.getMessage()));
                });
    }
}

