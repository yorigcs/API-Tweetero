package com.api.apitweetero.controllers;

import com.api.apitweetero.dtos.TweetsDTO;
import com.api.apitweetero.errors.NotFoundException;
import com.api.apitweetero.services.TweetsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
public class TweetsController {

    private final TweetsService tweetsService;

    public TweetsController(TweetsService tweetsService) {
        this.tweetsService = tweetsService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid TweetsDTO req) throws NotFoundException {
        this.tweetsService.save(req);
        return  new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }
}
