package com.api.apitweetero.repositories;

import com.api.apitweetero.models.TweetsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetsRepository extends JpaRepository<TweetsModel,String> {
    List<TweetsModel> findByUsername(String username);
}
