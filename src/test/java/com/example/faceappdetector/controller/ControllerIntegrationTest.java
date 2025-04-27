package com.example.faceappdetector.controller;

import com.example.faceappdetector.model.FaceAttributes;
import com.example.faceappdetector.model.FaceObject;
import com.example.faceappdetector.model.dto.FaceAttributeRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;

@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class ControllerIntegrationTest {

    @BeforeEach
    void before() {
        mongoTemplate.dropCollection(FaceObject.class).block();
    }

    @AfterEach
    void after() {
        mongoTemplate.dropCollection(FaceObject.class).block();
    }

    public FaceObject prepareDataToTest() {
        FaceObject faceObject = new FaceObject();
        faceObject.setFaceAttributes(new FaceAttributes());
        faceObject.getFaceAttributes().setAge(25.0);
        return faceObject;
    }

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;


    @DisplayName("Should return filtered face objects between given age range")
    @Test
    void shouldReturnFilteredFaceObjectsByAge() {

        //Given
        FaceObject faceObject = prepareDataToTest();
        mongoTemplate.insert(faceObject).block();

        FaceAttributeRequestDto faceAttributeRequestDto = new FaceAttributeRequestDto();
        faceAttributeRequestDto.setAgeMin(20.0);
        faceAttributeRequestDto.setAgeMax(30.0);

          //When and Then
        webTestClient.post()
                .uri("/api/face/filter")
                .bodyValue(faceAttributeRequestDto)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FaceObject.class)
                .hasSize(1)
                .consumeWith(response -> {
                    List<FaceObject> faceObjects = response.getResponseBody();

                    assert faceObjects.get(0).getFaceAttributes().getAge() >= 20.0;
                    assert faceObjects.get(0).getFaceAttributes().getAge() <= 30.0;
                });
    }
}
