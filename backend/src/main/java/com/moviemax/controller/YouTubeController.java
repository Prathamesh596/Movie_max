package com.moviemax.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/youtube")
@CrossOrigin(origins = "http://localhost:5173")
public class YouTubeController {

    @Value("${youtube.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/search")
    public ResponseEntity<String> searchVideos(@RequestParam String q) {

        String url =
                "https://youtube.googleapis.com/youtube/v3/search" +
                        "?part=snippet" +
                        "&maxResults=20" +
                        "&type=video" +
                        "&regionCode=IN" +
                        "&key=" + apiKey +
                        "&q=" + q;

        return ResponseEntity.ok(
                restTemplate.getForObject(url, String.class)
        );
    }
}
