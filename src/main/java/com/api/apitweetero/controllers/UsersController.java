package com.api.apitweetero.controllers;

import com.api.apitweetero.dtos.UsersDTO;
import com.api.apitweetero.models.UsersModel;
import com.api.apitweetero.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/sign-up")
    public  ResponseEntity<String> createUser(@RequestBody @Valid UsersDTO req) {
        this.service.save(req);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

}
