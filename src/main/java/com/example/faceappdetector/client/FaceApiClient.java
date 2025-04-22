package com.example.faceappdetector.client;

import com.example.faceappdetector.repository.FaceRepository;
import com.example.faceappdetector.aspect.SaveDataToDb;
import com.example.faceappdetector.model.FaceObject;
import com.example.faceappdetector.model.ImgUrl;
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
public class FaceApiClient {

    private static final String FACE_API_URL = "https://gkowalczyk1989.cognitiveservices.azure.com//face/v1.2-preview.1/detect?";
    @Value("${azure.face.api.key}")
    private String faceAppKey;
    private final WebClient webClient;
    private final FaceRepository faceRepository;

    @SaveDataToDb
    public Mono<List<FaceObject>> getFaceByUrl(String url) {
        return webClient.post()
                .uri(getFaceApiUrl())
                .headers(httpHeaders -> httpHeaders.addAll(getHttpHeaders()))
                .bodyValue(new ImgUrl(url))
                .retrieve()
                .bodyToMono(FaceObject[].class)
                .map(Arrays::asList)
                .map(faceList -> {
                    faceList.forEach(face -> face.setImageUrl(url));
                    return faceList;
                })
                .flatMapMany(faceRepository::saveAll)
                .collectList()
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
