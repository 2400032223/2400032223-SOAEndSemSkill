package com.example.tourist.controller;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TouristController {

    private final TouristRepository touristRepository;

    @Value("${app.token}")
    private String expectedToken;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(@RequestHeader(value = "token", required = false) String token) {
        if (token == null || !expectedToken.equals(token)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Unauthorized: The token is invalid"));
        }

        List<Tourist> tourists = touristRepository.findAll();
        return ResponseEntity.ok(tourists);
    }
}
