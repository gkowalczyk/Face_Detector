package com.example.faceappdetector.controller;

import com.example.faceappdetector.dto.FaceAttributes;
import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.entity.FaceAttributesEntity;
import com.example.faceappdetector.entity.FaceObjectEntity;
import com.example.faceappdetector.mapper.FaceObjectMapper;
import com.example.faceappdetector.request.FaceAttributeRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
        mongoTemplate.dropCollection(FaceObjectEntity.class).block();
    }

    @AfterEach
    void after() {
        mongoTemplate.dropCollection(FaceObjectEntity.class).block();
    }

    public FaceObjectEntity prepareDataToTest() {
        FaceObjectEntity faceObjectEntity = new FaceObjectEntity();
        FaceAttributesEntity faceAttributes = new FaceAttributesEntity();
        faceAttributes.setAge(25.0);
        faceObjectEntity.setFaceAttributes(faceAttributes);
        return faceObjectEntity;
    }

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;



    @DisplayName("Should return filtered face objects between given age range")
    @Test
    void shouldReturnFilteredFaceObjectsByAge() {

        //Given
        FaceObjectEntity faceObject = prepareDataToTest();
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