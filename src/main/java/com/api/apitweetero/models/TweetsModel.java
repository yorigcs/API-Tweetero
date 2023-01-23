package com.api.apitweetero.models;

import com.api.apitweetero.dtos.TweetsDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class TweetsModel {

    public TweetsModel(TweetsDTO tweets) {
        this.username = tweets.username();
        this.tweet = tweets.tweet();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(length = 30, nullable = false)
    String username;

    @Column(nullable = false)
    String tweet;

}
