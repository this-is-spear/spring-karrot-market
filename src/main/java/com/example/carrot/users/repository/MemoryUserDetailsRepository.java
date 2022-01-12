package com.example.carrot.users.repository;

import com.example.carrot.users.domain.UserDetails;

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
        UserDetails build = UserDetails.builder().user_id(uuid).phone_number(userDetails.getPhone_number()).name(userDetails.getName()).build();
        userDetailsMap.put(uuid, build);
        return uuid;
    }

    @Override
    public UserDetails getUserDetails(UUID uuid) {
        return userDetailsMap.get(uuid);
    }
}
