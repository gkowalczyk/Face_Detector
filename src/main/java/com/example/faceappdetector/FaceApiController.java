package com.example.faceappdetector;

import com.example.faceappdetector.model.FaceObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FaceApiController {

    private final FaceApiClient faceApiClient;

    @PostMapping("/api/face")
    public ResponseEntity<Mono<List<FaceObject>>> analyzeImage(@RequestBody ImgUrl imgUrl) {
        return ResponseEntity.ok(faceApiClient.getFaceByUrl(imgUrl.getUrl()));
    }
}
