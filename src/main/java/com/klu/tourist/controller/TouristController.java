package com.klu.tourist.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.tourist.entity.Tourist;
import com.klu.tourist.repo.TouristRepo;


@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristRepo repository;

    private final String VALID_TOKEN = "tourist123";

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(
            @RequestHeader(value = "Token", required = false)
            String token) {

        // Token validation
        if (token == null || !VALID_TOKEN.equals(token)) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unauthorized: Invalid Token Provided");
        }

        // Retrieve all tourist records
        List<Tourist> tourists = repository.findAll();

        return ResponseEntity.ok(tourists);
    }
}