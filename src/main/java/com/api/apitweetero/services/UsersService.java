package com.api.apitweetero.services;

import com.api.apitweetero.dtos.UsersDTO;
import com.api.apitweetero.models.UsersModel;
import com.api.apitweetero.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository repository;

    public  UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public void save(UsersDTO data) {
        this.repository.save(new UsersModel(data));
    }
}
