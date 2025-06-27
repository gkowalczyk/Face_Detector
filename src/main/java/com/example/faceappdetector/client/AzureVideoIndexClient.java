package com.example.faceappdetector.client;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.dto.FaceVideoDto;
import com.example.faceappdetector.response.VideoAttributeResponseDto;
import com.example.faceappdetector.service.VideoFrameExtractor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AzureVideoIndexClient {

    private final WebClient webClient;
    private final String azureIndexerUrl = "https://api.videoindexer.ai/eastus/Accounts";
    @Value("${azure.video.account-id}")
    private String accountId;
    private final String callbackUrl = "https://face-detector-app.site/api/video/callback";
    private final AzureAuthVideoIndexClient azureAuthVideoIndexClient;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final VideoFrameExtractor videoFrameExtractor;
    private final Map<String, String> videoFrameCache = new ConcurrentHashMap<>();

    public Mono<VideoAttributeResponseDto> uploadVideo(String url,
                                                       String name,
                                                       String description) {

        return azureAuthVideoIndexClient.generateVideoIndexToken()
                .flatMap(token -> {
                    String uri = String.format("%s/%s/Videos?name=%s&description=%s&videoUrl=%s&callbackUrl=%s&accessToken=%s",
                            azureIndexerUrl, accountId, name, description, url, callbackUrl, token);

                    return webClient.post()
                            .uri(uri)
                            .retrieve()
                            .onStatus(HttpStatusCode::isError, response ->
                                    response.bodyToMono(String.class).flatMap(error -> {
                                        log.error("Error response from Azure API: {}", error);
                                        return Mono.error(new RuntimeException("Error from Azure API: " + error));
                                    }))
                            .bodyToMono(VideoAttributeResponseDto.class)
                            .doOnNext(videoAttributeResponseDto -> {
                                videoFrameCache.put(videoAttributeResponseDto.getId(), url);
                                log.info("Video uploaded successfully: {}", videoAttributeResponseDto.getId());
                            });
                });
    }

    public Flux<FaceObject> analyzeVideo(String videoId) {

        return azureAuthVideoIndexClient.generateVideoIndexToken()
                .flatMapMany(token -> {
                    String uri = String.format("%s/%s/Videos/%s/Index?accessToken=%s",
                            azureIndexerUrl, accountId, videoId, token);

                    return webClient.get()
                            .uri(uri)
                            .retrieve()
                            .bodyToMono(String.class)
                            .flatMapMany(response -> Mono.fromCallable(() -> {
                                        try {
                                            JsonNode jsonNode = OBJECT_MAPPER.readTree(response);
                                            JsonNode faceVideosNode = jsonNode.path("videos").get(0).path("insights").path("faces");
                                            return OBJECT_MAPPER.treeToValue(faceVideosNode, FaceVideoDto[].class);
                                        } catch (Exception e) {
                                            log.error("Error parsing faces from JSON: {}", e.getMessage(), e);
                                            throw new RuntimeException("Parsing error", e);
                                        }
                                    })
                                    .subscribeOn(Schedulers.boundedElastic())
                                    .flatMapMany(Flux::fromArray))
                            .flatMap(faceVideoDto -> {
                                        log.info("Received face video data id: {}", videoId);
                                        String start = faceVideoDto.getThumbnails().get(0).getInstances().get(0).getStart();
                                        String end = faceVideoDto.getThumbnails().get(0).getInstances().get(0).getEnd();
                                        String videoUrl = videoFrameCache.getOrDefault(videoId, null);
                                        return videoFrameExtractor.extractFrames(videoUrl, start, end);
                                    });
                })
                .doOnNext(faceObject -> log.info("Detected face: {}", faceObject))
                .onErrorResume(e -> {
                    log.error("Error retrieving face video id data: {}", e.getMessage(), e);
                    return Flux.empty();
                });
    }
}