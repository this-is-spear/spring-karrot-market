package com.example.carrot.user.repository;

import com.example.carrot.user.domain.UserImg;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserImgRepository {
    UUID init(UUID uuid);
    UUID save(UserImg userImg);
    String getImagePath(UUID uuid);
}