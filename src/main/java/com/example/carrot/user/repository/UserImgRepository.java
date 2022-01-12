package com.example.carrot.user.repository;

import com.example.carrot.user.domain.UserImg;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserImgRepository {
    void init(UUID uuid);
    void save(UUID uuid, String userImgPath);
    String getImagePath(UUID uuid);
}
