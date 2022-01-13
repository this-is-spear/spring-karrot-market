package com.example.carrot.place.repository;

import com.example.carrot.place.domain.UserPlace;

import java.util.List;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserPlaceRepository {
    UUID save(UserPlace userPlace);
    UserPlace findByUser_id(UUID user_id);
    List<UserPlace> findByPlace_code(UUID place_code);
}
