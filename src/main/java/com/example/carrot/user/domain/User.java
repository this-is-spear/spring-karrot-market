package com.example.carrot.user.domain;

import lombok.Getter;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Getter
public class User {
    private UUID id;
    private String nickname;
    private String password;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public User(UUID id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }
}
