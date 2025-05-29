package com.example.faceappdetector.controller;

import com.example.faceappdetector.client.AzureVideoIndexClient;
import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.dto.FaceVideoDto;
import com.example.faceappdetector.response.VideoAttributeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class AzureVideoIndexController {

    private final AzureVideoIndexClient azureVideoIndexClient;

    @PostMapping("/api/video/add")
    public ResponseEntity<Mono<VideoAttributeResponseDto>> addVideo(@RequestParam String videoUrl,
                                                                    String videoName, String description) {
        return ResponseEntity.ok(azureVideoIndexClient.uploadVideo(videoUrl, videoName, description));
    }

    @PostMapping("/api/video/callback")
    public ResponseEntity<Flux<FaceObject>> handleCallBackFromAzurePortal(@RequestParam String id,
                                                                          @RequestParam String state) {
        log.info("Callback received: videoId={}, state={}", id, state);
        if ("Processed".equalsIgnoreCase(state)) {
            return ResponseEntity.ok(azureVideoIndexClient.analyzeVideo(id));
        }
        return ResponseEntity.ok(Flux.empty());
    }


}


