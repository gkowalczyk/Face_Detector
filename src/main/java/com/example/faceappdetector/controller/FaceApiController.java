package com.example.faceappdetector.controller;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.dto.ImgUrl;
import com.example.faceappdetector.mapper.FaceObjectMapper;
import com.example.faceappdetector.request.FaceAttributeRequestDto;
import com.example.faceappdetector.service.FaceDetectorService;
import com.example.faceappdetector.service.FaceAnalyzerAdapter;
import com.example.faceappdetector.service.FaceMatchService;
import com.example.faceappdetector.service.SaveDataToDb;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FaceApiController {

    private final FaceDetectorService faceDetectorService;
    private final FaceObjectMapper faceObjectMapper;
    private final FaceAnalyzerAdapter faceAnalyzerAdapter;
    private final SaveDataToDb saveDataToDb;
    private final FaceMatchService faceMatchService;

    @PostMapping("/api/face")
    public ResponseEntity<Mono<FaceObject>> analyzeImage(@RequestBody ImgUrl imgUrl) {
        return ResponseEntity.ok(faceAnalyzerAdapter.getFaceByUrl(imgUrl.getUrl()));
    }

    @PostMapping("/api/face/filter")
    public ResponseEntity<Flux<FaceObject>> filterFaces(@RequestBody FaceAttributeRequestDto faceAttributes) {
        Flux<FaceObject> mappedFaces = faceDetectorService.filterFaces(faceAttributes)
                .map(faceObjectMapper::toDto);
        return ResponseEntity.ok(mappedFaces);
    }

    @PostMapping("/api/face/save")
    public ResponseEntity<Void> saveFaceData(@RequestBody ImgUrl imgUrl) {
        saveDataToDb.saveDataToDb(imgUrl.getUrl());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/face/getSimilar")
    public ResponseEntity<Flux<FaceObject>> getSimilarFaces(@RequestBody ImgUrl imgUrl) {
        return ResponseEntity.ok(faceMatchService.matchFace(imgUrl.getUrl()));
    }
}

