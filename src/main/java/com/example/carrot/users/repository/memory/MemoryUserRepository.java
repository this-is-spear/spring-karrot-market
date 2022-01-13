package com.example.carrot.users.repository.memory;

import com.example.carrot.users.domain.User;
import com.example.carrot.users.repository.UserRepository;
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
public class MemoryUserRepository implements UserRepository {

    Map<UUID, User> userMap = new ConcurrentHashMap<>();

    @Override
    public UUID saveUser(User user) {
        UUID uuid = getUUID();
        User saveUser = User.builder().id(uuid).nickname(user.getNickname()).password(user.getPassword()).build();
        userMap.put(uuid, saveUser);
        return uuid;
    }

    private UUID getUUID() {
        return UUID.randomUUID();
    }

    @Override
    public User getUser(UUID userId) {
        return userMap.get(userId);
    }

    @Override
    public UUID updateUserNickname(UUID uuid, String updateNickname) {
        User user = userMap.get(uuid);
        User updateUser = User.builder().id(user.getId()).password(user.getPassword()).nickname(updateNickname).build();
        userMap.put(uuid, updateUser);
        return updateUser.getId();
    }
}
