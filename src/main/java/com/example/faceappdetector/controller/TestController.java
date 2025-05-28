package com.example.faceappdetector.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/ffmpeg")
    public ResponseEntity<String> checkFfmpegAvailability() {
        try {
            Process process = new ProcessBuilder("ffmpeg", "-version").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            return ResponseEntity.ok("FFMPEG działa!\n\n" + output);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("FFMPEG NIE działa: " + e.getMessage());
        }
    }
}