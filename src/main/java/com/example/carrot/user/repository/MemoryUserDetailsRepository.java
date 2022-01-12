package com.example.carrot.user.repository;

import com.example.carrot.user.domain.UserDetails;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemoryUserDetailsRepository implements UserDetailsRepository{

    Map<UUID, UserDetails> userDetailsMap = new ConcurrentHashMap<>();

    @Override
    public UUID init(UUID uuid, UserDetails userDetails) {
        userDetailsMap.put(uuid, userDetails);
        return uuid;
    }

    @Override
    public UserDetails getUserDetails(UUID uuid) {
        return userDetailsMap.get(uuid);
    }
}
