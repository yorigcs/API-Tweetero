package com.api.apitweetero.controllers;

import com.api.apitweetero.dtos.UsersDTO;
import com.api.apitweetero.errors.ConflictException;
import com.api.apitweetero.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/sign-up")
    public  ResponseEntity<String> createUser(@RequestBody @Valid UsersDTO req) throws ConflictException {
        this.service.save(req);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

}
