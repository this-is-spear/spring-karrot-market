package com.example.carrot.users.repository;

import com.example.carrot.users.domain.User;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserRepository {
    UUID saveUser(User user);
    User getUser(UUID userId);

    UUID updateUserNickname(UUID uuid, String updateNickname);
}
