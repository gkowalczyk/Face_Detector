package com.example.faceappdetector.service;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.entity.FaceObjectEntity;
import com.example.faceappdetector.request.FaceAttributeRequestDto;
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
        // Given
        FaceAttributeRequestDto request = new FaceAttributeRequestDto();
        request.setAgeMin(20.0);

        FaceObjectEntity faceObjectEntity = new FaceObjectEntity();

        when(mongoTemplate.find(any(Query.class), eq(FaceObjectEntity.class)))
                .thenReturn(Flux.just(faceObjectEntity));

        // When
        Flux<FaceObjectEntity> result = faceDetectorService.filterFaces(request);

        // Then
        StepVerifier.create(result)
                .expectComplete()
                .verify();

        verify(mongoTemplate, times(1)).find(any(Query.class), eq(FaceObjectEntity.class));
    }
}