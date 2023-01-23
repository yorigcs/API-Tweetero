package com.api.apitweetero.repositories;

import com.api.apitweetero.models.TweetsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetsRepository extends JpaRepository<TweetsModel,String> {
}
