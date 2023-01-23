package com.api.apitweetero.models;

import com.api.apitweetero.dtos.TweetsDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tweets")
public class Tweet {

    public Tweet(TweetsDTO tweets, String userId) {
        this.userId = userId;
        this.tweet = tweets.tweet();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String tweet;

    @Column(nullable = false)
    private String userId;



}
