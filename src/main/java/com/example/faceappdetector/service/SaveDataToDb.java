package com.example.faceappdetector.service;

import com.example.faceappdetector.aspect.AddToFaceSetAfterSave;
import com.example.faceappdetector.entity.FaceObjectEntity;
import com.example.faceappdetector.mapper.FaceObjectMapper;
import com.example.faceappdetector.repository.FaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveDataToDb {
    private final FaceAnalyzerAdapter faceAnalyzerAdapter;
    private final FaceRepository faceRepository;
    private final FaceObjectMapper faceObjectMapper;

    @AddToFaceSetAfterSave
    public Mono<String> saveDataToDb(String url) {
        return faceAnalyzerAdapter.getFaceByUrl(url)
                .flatMap(faceObject -> {
                    String token = faceObject.getFaceToken();
                    FaceObjectEntity faceObjectEntity = faceObjectMapper.toEntity(faceObject);
                    return faceRepository.save(faceObjectEntity)
                            .doOnSuccess(e -> log.info("Data was saved: {}", e))
                            .doOnError(err -> log.error("Error: ", err))
                            .thenReturn(token);
                });
    }
}

