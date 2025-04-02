package com.example.faceappdetector;

import com.example.faceappdetector.model.FaceObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class FaceApiClient {

    private static final String FACE_API_URL = "https://gkowalczyk1989.cognitiveservices.azure.com//face/v1.2-preview.1/detect?";
    @Value("${azure.face.api.key}")
    private String faceAppKey;
    private final WebClient webClient;


    public Mono<List<FaceObject>> getFaceByUrl(String url) {
        return webClient.post()
                .uri(getFaceApiUrl())
                .headers(httpHeaders -> httpHeaders.addAll(getHttpHeaders()))
                .bodyValue(new ImgUrl(url))
                .retrieve()
                .bodyToMono(FaceObject[].class)
                .map(Arrays::asList)
                .onErrorResume(e -> {
                    log.error("Błąd podczas pobierania twarzy: {}", e.getMessage());
                    return Mono.just(Collections.emptyList());
                });
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Ocp-Apim-Subscription-Key", faceAppKey);
        httpHeaders.add("Content-Type", "application/json");
        return httpHeaders;
    }

    public URI getFaceApiUrl() {
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(FACE_API_URL);
            uriBuilder
                    .setParameter("detectionModel", "detection_01")
                    .setParameter("recognitionModel", "recognition_03")
                    .setParameter("returnFaceAttributes", "glasses, age, smile,headPose," +
                            "occlusion,accessories,blur,exposure,noise,qualityForRecognition," +
                            " hair, makeup, facialHair, headPose, smile")
                    .setParameter("returnFaceLandmarks", "True")
                    .setParameter("returnRecognitionModel", "True")
                    .setParameter("faceIdTimeToLive", "60");
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }
}
