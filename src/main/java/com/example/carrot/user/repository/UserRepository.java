package com.example.carrot.user.repository;

import com.example.carrot.user.domain.User;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserRepository {
    UUID saveUser(User user);
    User getUser(UUID userId);
}
