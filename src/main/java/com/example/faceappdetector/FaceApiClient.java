package com.example.faceappdetector;

import com.example.faceappdetector.model.FaceObject;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

@Service
public class FaceApiClient {

    private static final String FACE_API_URL = "https://gkowalczyk1989.cognitiveservices.azure.com//face/v1.2-preview.1/detect?";
    @Value("${FACE_APP_KEY}")
    private String faceAppKey;


    public List<FaceObject> getFaceByUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ImgUrl> imgUrlHttpEntity = getHttpEntity(url);
        ResponseEntity<FaceObject[]> exchange = restTemplate.exchange(
                getFaceApiUrl(),
                HttpMethod.POST,
                imgUrlHttpEntity,
                FaceObject[].class);
       return Optional.of(exchange)
                .map(ResponseEntity::getBody)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public HttpEntity<ImgUrl> getHttpEntity(String url) {
        HttpHeaders httpHeaders = getHttpHeaders();
        ImgUrl imgUrl = new ImgUrl(url);
        return new HttpEntity<>(imgUrl, httpHeaders);
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
