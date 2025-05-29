package com.example.faceappdetector.service;

import com.example.faceappdetector.client.FacePlusApiClient;
import com.example.faceappdetector.client.ImgBBClient;
import com.example.faceappdetector.dto.FaceObject;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class VideoFrameExtractor {

    private final FacePlusApiClient facePlusApiClient;
    private Flux<FaceObject> faceObjectsFlux;
    private final FaceMatchService faceMatchService;
    private final ImgBBClient imgBBClient;

    public Flux<FaceObject> extractFrames(String videoUrl, String startTime, String endTime) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("H:mm")
                .optionalStart()
                .appendPattern(":ss")
                .optionalStart()
                .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
                .optionalEnd()
                .optionalEnd()
                .toFormatter();

        LocalTime timeStart = LocalTime.parse(startTime, formatter);
        LocalTime timeEnd = LocalTime.parse(endTime, formatter);

        double secondsStart = timeStart.toSecondOfDay() + (timeStart.getNano() / 1_000_000_000.0);
        double secondsEnd = timeEnd.toSecondOfDay() + (timeEnd.getNano() / 1_000_000_000.0);
        double middleTimeStamp = (secondsStart + secondsEnd) / 2;

        String fileName = "frame_" + System.currentTimeMillis() + ".png";
        String imagePath = System.getProperty("java.io.tmpdir") + "/" + fileName;

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "ffmpeg",
                    "-ss", String.valueOf(middleTimeStamp),
                    "-i", videoUrl,
                    "-frames:v", "1",
                    "-q:v", "1",
                    "-vf", "scale=1280:720,unsharp",
                    imagePath
            );
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                log.error("FFmpeg exited with code {}", exitCode);
                return Flux.error(new RuntimeException("FFmpeg error"));
            }

            String fileUrl = imgBBClient.uploadToImgBB(Path.of(imagePath), fileName);
            log.info("Frame extracted successfully: {}", fileUrl);

            return faceMatchService.matchFace(fileUrl)
                    .doOnComplete(() -> log.info("Face matching completed for video: {}", videoUrl))
                    .doOnError(e -> log.error("Error during face matching: {}", e.getMessage(), e))
                    .doFinally(signalType -> {
                        deleteTempImage(imagePath);
                        log.info("Temporary image deleted: {}", imagePath);
                    });
        } catch (Exception e) {
            log.error("Error extracting frame from video: {}", e.getMessage(), e);
            return Flux.error(e);
        }
    }

    private void deleteTempImage(String imagePath) {
        try {
            Files.deleteIfExists(Path.of(imagePath));
            log.info("Temporary image deleted: {}", imagePath);
        } catch (Exception e) {
            log.error("Error deleting temporary image: {}", e.getMessage(), e);
        }
    }
}
