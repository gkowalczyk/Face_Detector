package com.example.faceappdetector.controller;

import com.example.faceappdetector.client.FaceApiClient;
import com.example.faceappdetector.model.FaceObject;
import com.example.faceappdetector.model.ImgUrl;
import com.example.faceappdetector.service.FaceDetectorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest(FaceApiController.class)
@ActiveProfiles("test")
class ControllerUnitTest {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private FaceApiClient faceApiClient;
    @MockBean
    private FaceDetectorService faceDetectorService;

    @DisplayName("Should return face objects when given a valid image URL")
    @Test
    void shouldReturnFaceObjects() {

        // Given
        String url = "https://example.com/image.jpg";
        ImgUrl i = new ImgUrl(url);
        List<FaceObject> faceObjects = List.of(new FaceObject());

        // When
        when(faceApiClient.getFaceByUrl(url)).thenReturn(Mono.just(faceObjects));

        //Then
        webTestClient.post()
                .uri("/api/face")
                .bodyValue(i)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FaceObject.class).hasSize(1);
    }

    @DisplayName("Should return 500 error when given an invalid URL")
    @Test
    void shouldReturnErrorWhenGivenInvalidUrl() {
        // Given
        String url = "invalid_url";
        ImgUrl i = new ImgUrl(url);

        // When
        when(faceApiClient.getFaceByUrl(url)).thenReturn(Mono.error(new Exception("Invalid URL")));

        // Then
        webTestClient.post()
                .uri("/api/face")
                .bodyValue(i)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @DisplayName("Should return empty faces when no faces are detected")
    @Test
    void shouldReturnEmptyFaces() {
        String url = "https://example.com/image.jpg";
        ImgUrl i = new ImgUrl(url);
        List<FaceObject> faceObjects = List.of(new FaceObject());

        // When
        when(faceApiClient.getFaceByUrl(url)).thenReturn(Mono.just(Collections.emptyList()));

        //Then
        webTestClient.post()
                .uri("/api/face")
                .bodyValue(i)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FaceObject.class)
                .hasSize(0);
    }
}

