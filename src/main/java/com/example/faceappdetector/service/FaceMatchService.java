package com.example.faceappdetector.service;

import com.example.faceappdetector.client.FacePlusApiClient;
import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.mapper.FaceObjectMapper;
import com.example.faceappdetector.repository.FaceRepository;
import com.example.faceappdetector.response.FaceApiMatchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FaceMatchService {

    private final FaceRepository faceRepository;
    private final FacePlusApiClient facePlusApiClient;
    private final FaceObjectMapper faceObjectMapper;

    public Flux<FaceObject> matchFace(String url) {
        return facePlusApiClient.getSimilarFaces(url)
                .flatMapMany(response -> {
                    if (response.getResults() == null || response.getThresholds() == null) {
                        return Flux.error(new RuntimeException("Invalid response from Face++ API"));
                    }
                    List<String> matchingTokens = response.getResults().stream()
                            .filter(result -> result.getConfidence() >= response.getThresholds().get_1e_3())
                            .map(FaceApiMatchResponse.Result::getFaceToken)
                            .collect(Collectors.toList());

                    matchingTokens.forEach(token -> {
                        log.info("Matching tokens: " + token);
                    });

                     if (matchingTokens.isEmpty()) {
                        log.info("No matching faces found for the provided URL.");
                        return Flux.empty();
                    }

                    return faceRepository.findAll()
                            .filter(entity -> matchingTokens.contains(entity.getFaceToken()))
                            .map(faceObjectMapper::toDto);

                })
                .onErrorResume(ex -> {
                    ex.printStackTrace();
                    return Flux.error(new RuntimeException("Face matching error: " + ex.getMessage()));
                });
    }
}

