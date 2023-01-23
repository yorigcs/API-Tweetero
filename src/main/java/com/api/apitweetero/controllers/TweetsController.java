package com.api.apitweetero.controllers;

import com.api.apitweetero.dtos.TweetsDTO;
import com.api.apitweetero.dtos.TweetsWithAvatarDTO;
import com.api.apitweetero.errors.NotFoundException;
import com.api.apitweetero.services.TweetsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/{username}")
    public  ResponseEntity<List<TweetsWithAvatarDTO>> getTweetsByUsernameWithAvatar(@PathVariable String username) throws NotFoundException {
        List<TweetsWithAvatarDTO> tweets = this.tweetsService.getTweetsByUsernameWithAvatar(username);
        return  new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<TweetsWithAvatarDTO>> getTweetsByPage(@RequestParam String page){
        List<TweetsWithAvatarDTO> tweets = this.tweetsService.getTweetsByPage(Integer.parseInt(page));
        return  new ResponseEntity<>(tweets, HttpStatus.OK);
    }
}
