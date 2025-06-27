package com.example.faceappdetector.service;

import com.example.faceappdetector.client.FaceApiClient;
import com.example.faceappdetector.client.FacePlusApiClient;
import com.example.faceappdetector.controller.FaceApiController;
import com.example.faceappdetector.dto.FaceObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaceAnalyzerAdapter {

    private final FacePlusApiClient facePlusApiClient;
    private final FaceApiClient faceApiClient;

    public Mono<FaceObject> getFaceByUrl(String url) {
        Mono<List<FaceObject>> azureData = faceApiClient.getFaceByUrl(url);
        Mono<List<FaceObject>> facePlusData = facePlusApiClient.getFaceByUrl(url);
        return Mono.zip(azureData, facePlusData)
                .map(tuple -> merge(tuple.getT1(), tuple.getT2()));
    }

    public FaceObject merge(List<FaceObject> azureFaces, List<FaceObject> facePlusFaces) {

        FaceObject azure = azureFaces.get(0);
        FaceObject facePlus = facePlusFaces.get(0);
        azure.getFaceAttributes().setGender(facePlus.getFaceAttributes().getGender());
        azure.getFaceAttributes().setEmotion(facePlus.getFaceAttributes().getEmotion());
        azure.getFaceAttributes().setSkinstatus(facePlus.getFaceAttributes().getSkinstatus());
        azure.getFaceAttributes().setBeauty(facePlus.getFaceAttributes().getBeauty());
        azure.setFaceToken(facePlus.getFaceToken());
        return azure;
    }
}