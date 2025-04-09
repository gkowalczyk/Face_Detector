package com.example.faceappdetector.controller;

import com.example.faceappdetector.client.FaceApiClient;
import com.example.faceappdetector.model.FaceAttributes;
import com.example.faceappdetector.model.FaceObject;
import com.example.faceappdetector.model.ImgUrl;
import com.example.faceappdetector.model.dto.FaceAttributeRequestDto;
import com.example.faceappdetector.service.FaceDetectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FaceApiController {

    private final FaceApiClient faceApiClient;
    private final FaceDetectorService faceDetectorService;

    @PostMapping("/api/face")
    public ResponseEntity<Mono<List<FaceObject>>> analyzeImage(@RequestBody ImgUrl imgUrl) {
        return ResponseEntity.ok(faceApiClient.getFaceByUrl(imgUrl.getUrl()));

    }

    @PostMapping("/api/face/filter")
    public ResponseEntity<Mono<List<FaceObject>>> filterFaces(@RequestBody FaceAttributeRequestDto faceAttributes) {
        return ResponseEntity.ok(faceDetectorService.filterFaces(faceAttributes));
    }
}
