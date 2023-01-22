package com.api.apitweetero.repositories;

import com.api.apitweetero.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel,String> {
}
