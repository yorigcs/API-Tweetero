package com.api.apitweetero.services;

import com.api.apitweetero.dtos.UsersDTO;
import com.api.apitweetero.errors.ConflictException;
import com.api.apitweetero.models.User;
import com.api.apitweetero.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository repository;

    public  UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public void save(UsersDTO data) throws ConflictException {
        User user = this.repository.findByUsername(data.username());
        if(user != null) throw new ConflictException("This username already exists!");
        this.repository.save(new User(data));
    }
}
