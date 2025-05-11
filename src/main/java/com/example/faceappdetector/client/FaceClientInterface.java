package com.example.faceappdetector.client;

import com.example.faceappdetector.dto.FaceObject;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FaceClientInterface {
    Mono<List<FaceObject>> getFaceByUrl(String url);
}
