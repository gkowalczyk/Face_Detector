package com.example.faceappdetector.service;

import com.example.faceappdetector.model.FaceObject;
import com.example.faceappdetector.model.dto.FaceAttributeRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class FaceDetectorServiceTest {

    @Mock
    private ReactiveMongoTemplate mongoTemplate;

    @InjectMocks
    private FaceDetectorService faceDetectorService;

    @Test
    void shouldShowFacesFilterByAge() {
        //Given
        FaceAttributeRequestDto faceAttributes = new FaceAttributeRequestDto();
        faceAttributes.setAgeMin(20.0);
        FaceObject faceObject = new FaceObject();
        List<FaceObject> faceObjects = List.of(faceObject);

        //When
        when(mongoTemplate.find(any(Query.class), eq(FaceObject.class)))
                .thenReturn(Flux.fromIterable(faceObjects));
        Mono<List<FaceObject>> filteredFaces = faceDetectorService.filterFaces(faceAttributes);
        //Then
        StepVerifier.create(filteredFaces)
                .expectNext(faceObjects)
                .verifyComplete();
        verify(mongoTemplate).find(any(Query.class), eq(FaceObject.class));
    }
}