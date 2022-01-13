package com.example.carrot.place.repository.memory;

import com.example.carrot.place.domain.UserPlace;
import com.example.carrot.place.repository.UserPlaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-14
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemoryUserPlaceRepository implements UserPlaceRepository {

    Map<UUID, UserPlace> userPlaceMap = new ConcurrentHashMap<>();

    @Override
    public UUID save(UserPlace userPlace) {
        UUID user_id = userPlace.getUser_id();
        userPlaceMap.put(user_id, userPlace);
        return user_id;
    }

    @Override
    public UserPlace findByUser_id(UUID user_id) {
        return userPlaceMap.get(user_id);
    }

    @Override
    public List<UserPlace> findByPlace_code(UUID place_code) {
        List<UserPlace> userPlaceList = new ArrayList<>();

        userPlaceMap.forEach((uuid, userPlace) -> {
            if (userPlace.getPlace_code() == place_code) {
                userPlaceList.add(userPlace);
            }
        });

        return userPlaceList;
    }
}
