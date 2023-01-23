package com.api.apitweetero.repositories;

import com.api.apitweetero.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetsRepository extends JpaRepository<Tweet,String> {
    List<Tweet> findByUserId(String username);
}
