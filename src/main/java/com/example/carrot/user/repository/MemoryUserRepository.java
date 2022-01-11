package com.example.carrot.user.repository;

import com.example.carrot.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Repository
public class MemoryUserRepository implements UserRepository{

    Map<UUID, User> userMap = new ConcurrentHashMap<UUID, User>();

    @Override
    public UUID saveUser(User user) {
        UUID uuid = UUID.randomUUID();
        User saveUser = new User(uuid, user.getNickname(), user.getPassword());
        userMap.put(uuid, saveUser);
        return uuid;
    }

    @Override
    public User getUser(UUID userId) {
        return userMap.get(userId);
    }
}
