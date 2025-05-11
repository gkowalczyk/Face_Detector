package com.example.faceappdetector.client;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.dto.ImgUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FaceApiClient implements FaceClientInterface {

    @Value("${azure.face.api.url}")
    private String faceAppUrl;
    @Value("${azure.face.api.key}")
    private String faceAppKey;
    private final WebClient webClient;


    public Mono<List<FaceObject>> getFaceByUrl(String url) {

        return webClient.post()
                .uri(getFaceApiUrl())
                .headers(httpHeaders -> httpHeaders.addAll(getHttpHeaders()))
                .bodyValue(new ImgUrl(url))
                .retrieve()
                .onStatus(status -> status.isError(), response -> {
                    return response.bodyToMono(String.class).flatMap(body -> {
                        log.error("Azure API error: {}", body);
                        return Mono.error(new RuntimeException("Azure API returned error: " + body));
                    });
                })

                .bodyToMono(FaceObject[].class)
                .map(Arrays::asList)
                .map(faceList -> faceList.stream()
                        .peek(faceObject -> faceObject.setUrl(url))
                        .toList())
                .onErrorResume(e -> {
                    log.error("Error: {}", e.getMessage());
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
            URIBuilder uriBuilder = new URIBuilder(faceAppUrl);
            uriBuilder
                    .setParameter("detectionModel", "detection_01")
                    .setParameter("recognitionModel", "recognition_04")
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
