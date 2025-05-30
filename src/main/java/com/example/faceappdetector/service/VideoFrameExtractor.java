package com.example.faceappdetector.service;

import com.example.faceappdetector.client.ImgBBClient;
import com.example.faceappdetector.dto.FaceObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoFrameExtractor {

    private final FaceMatchService faceMatchService;
    private final ImgBBClient imgBBClient;

    public Flux<FaceObject> extractFrames(String videoUrl, String startTime, String endTime) {
        return Mono.fromCallable(() -> extractMiddleTimeStamp(startTime, endTime))
                .flatMap(middleTimeStamp -> extractFrameWithFFmpeg(videoUrl, middleTimeStamp))
                .flatMapMany(path -> imgBBClient.uploadToImgBB(path, path.getFileName().toString())
                        .doFinally(signal -> deleteTempImage(path.toString()))
                        .flatMapMany(faceMatchService::matchFace))
                .doOnError(error -> log.error("Error extracting frames: {}", error.getMessage(), error));
    }

    public Double extractMiddleTimeStamp(String startTime, String endTime) {
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
        return (secondsStart + secondsEnd) / 2;
    }

    public Mono<Path> extractFrameWithFFmpeg(String videoUrl, double middleTimeStamp) {
        return Mono.fromCallable(() -> {
            String fileName = "frame_" + System.currentTimeMillis() + ".png";
            String imagePath = System.getProperty("java.io.tmpdir") + "/" + fileName;

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
                throw new RuntimeException("FFmpeg process failed with exit code: " + exitCode);
            }
            log.info("Frame extracted successfully: {}", imagePath);
            return Path.of(imagePath);
        }).subscribeOn(Schedulers.boundedElastic());
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
