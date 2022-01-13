package com.example.carrot.place.repository;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserPlace {
    UUID save(UserPlace userPlace);
    UserPlace findByUser_id(UUID user_id);
    UserPlace findByPlace_code(UUID place_code);
}
