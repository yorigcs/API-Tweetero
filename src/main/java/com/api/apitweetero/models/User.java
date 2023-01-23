package com.api.apitweetero.models;

import com.api.apitweetero.dtos.UsersDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    public User(UsersDTO users) {
        this.avatar = users.avatar();
        this.username = users.username();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;


}
