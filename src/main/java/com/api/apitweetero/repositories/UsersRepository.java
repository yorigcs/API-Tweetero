package com.api.apitweetero.repositories;

import com.api.apitweetero.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,String> {
    User findByUsername(String name);

}
