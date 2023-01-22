package com.api.apitweetero.models;

import com.api.apitweetero.dtos.UsersDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UsersModel {

    public UsersModel(UsersDTO users) {
        this.avatar = users.avatar();
        this.username = users.username();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(length = 30, nullable = false)
    String username;

    @Column(nullable = false)
    String avatar;

}
